<template>
  <div class="setting_header">
    <img src="@/assets/img/tomato1.svg" alt="">
    <p> 오늘의 뽀모도로를 설정하세요. </p>
  </div>

  <div class="setting_content">
    <div class="setting_goal">
      <p>오늘 스터디 목표</p>
      <select name="studyGoal" id="select_goal" @change="selectGoal($event)">
        <option v-for="option in goalOptions" :key="option" :value="option">{{ option }}</option>
      </select>
    </div>
    
    <div class="setting_time">
      <p>스터디 익는 시간</p>
      <select name="studyGoal" id="select_time" @change="selectTime($event)">
        <option v-for="option in timeOptions" :key="option" :value="option">{{ option }}</option>
      </select>
    </div>
  </div>

  <button v-if="pomodoro_setting_data[0] === 0" class="pomodoro_setting_btn" @click="onClickSettingPomodoro">설정 완료</button>
  <button v-else class="pomodoro_setting_btn" @click="onClickPatchPomodoro">설정 완료</button>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_setting.scss'
import { reactive } from 'vue'
import { useStore } from 'vuex'

export default {
  name: 'PomodoroSetting',
  props: {
    studyId: {
      type: String,
      required: true
    },
    pomodoro_setting_data : {
      type: Array,
      required: true
    }
  },

  setup(props, {emit}) {
    const goalOptions = ['--목표 개수 설정--']
    const timeOptions = ['--목표 시간 설정--']
    const store = useStore()

    const state = reactive({
      now_goal : '',
      now_time : ''
    })

    console.log(props.pomodoro_setting_data);
    console.log(props.pomodoro_setting_data[0]);
    console.log(props.pomodoro_setting_data[1]);


    for (let i = 1; i < 51; i++) {
      goalOptions.push(i)
    }
    
    for (let j=1; j < 13; j++) {
      timeOptions.push(j*10)
    }

    function selectGoal(e) {
      state.now_goal = e.target.value
    }

    function selectTime(e) {
      state.now_time = e.target.value
    }

    function onClickSettingPomodoro(){
      store.dispatch('setPomodoro', {goal: state.now_goal, time: state.now_time, studyId: props.studyId})
      emit('completePomodoroSetting')
    }

    const onClickPatchPomodoro = () => {
      store.dispatch('patchPomodoro', {goal: state.now_goal, time: state.now_time, studyId: props.studyId, tomatoPlanId: props.pomodoro_setting_data[1]})
      emit('completePomodoroSetting')
    }

    return {
      state,
      goalOptions,
      timeOptions,
      
      selectGoal,
      selectTime,
      onClickSettingPomodoro,
      onClickPatchPomodoro
    }
  }
}
</script>

<style>

</style>