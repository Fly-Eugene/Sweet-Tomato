<template>
  <div class="pomodoro_timer">
    <div class="timer_header">
      <span>토마토 익기까지</span>
      <span>시작</span>
    </div>
    <article class="bar_wrapper">
      <div class="bar_gray">
        <div class="bar_pink"></div>
      </div>
    </article>
    <article class="state_time">      
      <span>12:30</span>
      <span> / </span>
      <span>25:00</span>
    </article> 
  </div>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_timer.scss'
export default {
  name: 'PomodoroTimer'
}
</script>

<style>

</style>