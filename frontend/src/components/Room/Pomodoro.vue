<template>
  <div class="pomodoro_box">
    <div class="pomodoro_header">
      <span>뽀모도로</span>
      <span>X</span>
    </div>
    <div class="pomodoro_content">
      <PomodoroSetting/>
      <PomodoroState/>
      <PomodoroTimer/>
    </div>
    <!-- <v-show></v-show> -->
  </div>
</template>

<script>
import PomodoroSetting from '@/components/Room/Pomodoro/PomodoroSetting'
import PomodoroState from '@/components/Room/Pomodoro/PomodoroState'
import PomodoroTimer from '@/components/Room/Pomodoro/PomodoroTimer'
import '@/assets/style/Room/pomodoro.scss'

export default {
  name: 'Pomodoro',
  components: {
    PomodoroSetting,
    PomodoroState,
    PomodoroTimer
  }
}
</script>

<style>

</style>