<template>
  <section class="mypage_study_time">
    <section class="box_left">
      <header class="mypage_study_header">주간 공부량 비교</header>
        <div class="none" v-if="myStudyTime"> 공부시간 없음 </div>
        <div id='time_chart' v-if="!myStudyTime"></div>
    </section>
    <section class="box_right">
      <div class="amount">
        <p @click="check">총 공부 시간</p>
        <p>{{ state.amountHour }}h {{ state.amountMinute }}m</p>
      </div>
      <div class="weekly">
        <div class="when">
          <p>오늘</p>
          <p>이번 주</p>
        </div>
        <div class="time">
          <p>{{ state.todayHour }}h {{ state.todayMinute }}m</p>
          <p>{{ state.weeklyHour }}h {{ state.weeklyMinute }}m</p>
        </div>
      </div>
    </section>
    <!-- <div>{{ this.myStudyTime }}</div> -->
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_study_time.scss'
import { reactive } from '@vue/reactivity'
import { onMounted } from '@vue/runtime-core'

export default {
  name: 'MypageStudyTime',
  
  props: {
    myStudyTime: Object  
  },
  
  setup(props) {

    const state = reactive({
      answer: [],
      week: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
      weeklyHour: 0,
      weeklyMinute: 0,
      todayHour: 0,
      todayMinute: 0,
      amountHour: 0,
      amountMinute: 0,
    })

    const options = {
      chart: {
        type: 'line'
      },
      series:  [{
        type: 'line',
        name: '지난 주',
        data: []
      }, {
        type: 'line',
        name: '이번 주',
        data: []
      }],

      colors: ["gray", "#FF5757"],

      xaxis: {
        type: 'category',
        categories: ['일', '월', '화', '수', '목', '금', '토']
      },

      stroke: {
        curve: 'smooth'
      }
    } 

    function getInputDayLabel(date) {
      var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
      var today = new Date(date).getDay();
      var todayLabel = week[today];
      return todayLabel;
    }

    function getWeeklyStudyTime(){
      var answer = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
      var i = 0;
      var j = 0
      var weekCnt = 0
      var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');

      while (i < 14 && j < props.myStudyTime.length) {        

        if (getInputDayLabel(props.myStudyTime[j].studyDate) === week[weekCnt]) {
          answer[i] = props.myStudyTime[j].studyTime
          i++;
          j++;
          ++weekCnt;
          weekCnt = weekCnt % 7;
        } else {          
          i++;                   
          ++weekCnt;
          weekCnt = weekCnt % 7; 
        }
      }      
      return answer
    }

    function makeAmount() {
      var answer = 0
      for (var i = 0; i < props.myStudyTime.length; i++) {
        answer = answer + props.myStudyTime[i].studyTime
      }
      return answer
    }

    function sumTime(arr){
      const result = arr.reduce(function add(sum, currValue) {
        return sum + currValue;
      }, 0)
      return result
    }
    
    function calHour(time){
      const hour = Math.floor(time / 60);
      const minute = time - (hour * 60)
      return [hour, minute]
    }

    function getToday(){
      var date = new Date();
      var year = date.getFullYear();
      var month = ("0" + (1 + date.getMonth())).slice(-2);
      var day = ("0" + date.getDate()).slice(-2);
      return year + "-" + month + "-" + day;
    }

    function calToday(){
      var result = [0, 0]
      if(!props.myStudyTime[props.myStudyTime.length-1]) return result      
      if (getToday() === props.myStudyTime[props.myStudyTime.length-1].studyDate) {
        result[0] = calHour(props.myStudyTime[props.myStudyTime.length-1].studyTime)[0]
        result[1] = calHour(props.myStudyTime[props.myStudyTime.length-1].studyTime)[1]
      } 
      return result
    }
    
    function object2array1(obj) {
      let answer = []
      for (let value of Object.values(obj)) {
        options.series[0].data.push(value)
      }
      return answer
    }

    function object2array2(obj) {
      let answer = []
      for (let value of Object.values(obj)) {
        options.series[1].data.push(value)
      }
      return answer
    }
    function check() {
      console.log(props.myStudyTime)
    }
    onMounted(() => {
      state.answer = getWeeklyStudyTime()
      state.weeklyHour = calHour(sumTime(state.answer.slice(7, 14)))[0]
      state.weeklyMinute = calHour(sumTime(state.answer.slice(7, 14)))[1]
      state.todayHour = calToday()[0]
      state.todayMinute = calToday()[1]
      state.amountHour = calHour(makeAmount())[0]
      state.amountMinute = calHour(makeAmount())[1]

      object2array1(state.answer.slice(0, 7))
      object2array2(state.answer.slice(7, 14))
      var chart = new ApexCharts(document.querySelector("#time_chart"), options);
      chart.render();
    })

    return {
      state,
      options,
      getInputDayLabel,
      getWeeklyStudyTime,
      sumTime,
      calHour,
      check
    }
  }
}
</script>

<style>

</style>