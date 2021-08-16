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
      <span v-if="state.study_pomodoro_goals === null">0</span>
      <span v-else>{{ state.study_pomodoro_goals[state.study_pomodoro_goals.length - 1].goalTime }}</span>
    </article> 
  </div>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_timer.scss'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: 'PomodoroTimer',

  setup(){
    const store = useStore()
    const state = reactive({
      study_pomodoro_goals: computed(() => {
        if (store.state.studyPomodoroGoals.length === 0) {
          return null
        }
        else {
          return store.state.studyPomodoroGoals
        }
      })
    })

    return {
      state,
    }
  }
}
</script>

<style>

</style>