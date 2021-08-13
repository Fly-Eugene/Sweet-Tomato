<template>
  <div class="setting_header">
    <img src="@/assets/img/tomato1.svg" alt="">
    <p> 오늘의 뽀모도로를 설정하세요. </p>
  </div>

  <div class="setting_content">
    <div class="setting_goal">
      <p>오늘 스터디 목표</p>
      <select name="studyGoal" id="select_goal">
        <option v-for="option in goalOptions" :key="option" :value="option">{{ option }}</option>
      </select>
    </div>
    
    <div class="setting_time">
      <p>스터디 익는 시간</p>
      <select name="studyGoal" id="select_time">
        <option v-for="option in timeOptions" :key="option" :value="option">{{ option }}</option>
      </select>
    </div>
  </div>

  <button class="pomodoro_setting_btn">설정 완료</button>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_setting.scss'
export default {
  name: 'PomodoroSetting',

  setup() {
    const goalOptions = []
    const timeOptions = []

    for (let i = 1; i < 51; i++) {
      goalOptions.push(i)
    }
    
    for (let j=1; j < 13; j++) {
      timeOptions.push(j*10)
    }

    return {
      goalOptions,
      timeOptions
    }
  }
}
</script>

<style>

</style>