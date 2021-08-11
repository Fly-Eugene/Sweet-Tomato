<template>
  <section class="chart_section">
    <header class="chart_header">토마토 밭</header>
    <apexchart type="heatmap" height="350" width="1000" :options="chartOptions" :series="series"></apexchart>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_chart.scss'
// import VueApexCharts from 'vue3-apexcharts'
import { useStore } from 'vuex'
import { reactive } from 'vue'
import { computed } from '@vue/runtime-core'

export default {
  name: 'StudyChart',
  setup() {
    const store = useStore()
    function currentDate(){
      var date = new Date();
      var month = leadingZeros(date.getMonth() + 1, 2);
      var today = date.getFullYear() + "-" + month + "-" + leadingZeros(date.getDate(),2);
      console.log(today);
      return today;
    }

    function leadingZeros(n, digits){
      var zero = '';
      n = n.toString();
      if(n.length < digits){
        for(var i = 0; i < digits - n.length; i++)
          zero += '0';
      }
      return zero + n;
    }
    function calculateDate(number){
      const res = []
      for(var i = 0; i < 18; i++){
        res[i] = 0;
      }
      var tomatoes = store.state.tomatoes;
      console.log(tomatoes)
      var today = new Date(currentDate());
      console.log(store.state.tomatoes);
      for(var i = 0; i < tomatoes.length; i++){
          var day1 = new Date(tomatoes[i].date);
          var dateDiff = Math.ceil((today - day1) / (1000*3600*24));
          var temp = dateDiff % 7;
          console.log(temp)
          console.log(number)
          if(number == temp){
            res[18 - Math.ceil(dateDiff/7)] = tomatoes[i].count;
          } 
      }
      console.log(res);
      return res;
    }
    
    function generateData(cnt, min, max) {
      let i
      const res = []
      min = Math.ceil(min);
      max = Math.floor(max);
      for (i=0; i<cnt; i++) {
        res.push(Math.floor(Math.random() * (max - min + 1)) + min)
      }
      return res; //최댓값도 포함, 최솟값도 포함
    }

    const series = [
      { name: 'Metric1',
        data: calculateDate(0)
      },
      { name: 'Metric2',
        data: calculateDate(1)
      },
      { name: 'Metric3',
        data: calculateDate(2)
      },
      { name: 'Metric4',
        data: calculateDate(3)
      },
      { name: 'Metric5',
        data: calculateDate(4)
      },
      { name: 'Metric6',
        data: calculateDate(5)
      },
      { name: 'Metric7',
        data: calculateDate(6)
      }
    ]

    const chartOptions = {
      chart: {
        height: 350,
        type: 'heatmap',
        toolbar: {
          show: false   // 그 위에 확대 축소 다운로드 버튼 없애기
        }
      },
      dataLabels: {
        enabled: false  // 하나하나숫자 나타내기 할거냐 옵션
      },
      colors: ["#E94846"],
      title: {
        text: ''
      },
    }


    return {
      series,
      chartOptions
    }
  }
}

</script>

<style>

</style>