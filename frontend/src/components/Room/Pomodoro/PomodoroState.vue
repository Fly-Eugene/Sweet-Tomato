<template>
  <div class="pomodoro_state">
    <article class="state_header">
      <span>목표 달성치</span>
      <span></span>
    </article>
    <article class="state_content">
      <div class="state_content_wrapper">          
        <div class="state_profile">
          <span>줄</span>
          <div class="bar">
            <div class="bar_front"></div>
          </div>
        </div>
        <div class="state_profile">
          <span>근</span>
          <div class="bar">
            <div class="bar_front"></div>
          </div>
        </div>
        <div class="state_profile">
          <span>유</span>
          <div class="bar">
            <div class="bar_front"></div>
          </div>
        </div>
        <div class="state_profile">
          <span>종</span>
          <div class="bar">
            <div class="bar_front"></div>
          </div>
        </div>
        <div class="state_profile">
          <span>혜</span>
          <div class="bar">
            <div class="bar_front"></div>
          </div>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_state.scss'
export default {
  name: 'PomodoroState'
}
</script>

<style>

</style>