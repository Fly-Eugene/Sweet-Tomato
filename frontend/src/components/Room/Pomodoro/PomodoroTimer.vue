<template>
  <div class="pomodoro_timer">
    <div class="timer_header">
      <span>토마토 익기까지</span>
      <span @click="onClickPomodoroTimer">시작</span>
    </div>
    <article class="bar_wrapper">
      <div class="bar_gray">
        <div class="bar_pink" :style="`width: ${state.totalTime/(state.study_pomodoro_goals[state.study_pomodoro_goals.length - 1].goalTime * 60) * 100}%`"></div>
      </div>
    </article>
    <article class="state_time">      
      <span>{{state.timer_minutes}} : {{state.timer_seconds}}</span>
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
  props: {
    studyId: {
      type: String,
      required: true
    }
  },

  setup(props){
    const store = useStore()
    const state = reactive({
      totalTime: 0,
      timer: null,
      timer_minutes: computed(() => {
        return padTime(state.totalTime >= 60 ? Math.floor(state.totalTime / 60) : 0)
      }),
      timer_seconds: computed(() => {
        return padTime(state.totalTime - (state.timer_minutes * 60))
      }),
      study_pomodoro_goals: computed(() => {
        if (store.state.studyPomodoroGoals.length === 0) {
          return null
        }
        else {
          return store.state.studyPomodoroGoals
        }
      }),
    })

    function padTime(time) {
      return (time < 10 ? '0' : '') + time;
    }

    const onClickPomodoroTimer = () => {
      state.timer = setInterval(() => countdown(), 1000)
    }

    const endTimer = () => {
      clearInterval(state.timer)
      state.timer = null
      state.totalTime = 0;
    }

    const countdown = () => {
      if(state.totalTime < state.study_pomodoro_goals[state.study_pomodoro_goals.length - 1].goalTime*60) {
        state.totalTime ++
      } else {
        endTimer()
        // 스터디원 별로 dispatch 보내기
        store.dispatch('addTomato', props.studyId)
        alert('시간종료')
      }
    }

    return {
      state,
      onClickPomodoroTimer,
      countdown

    }
  }
}
</script>

<style>

</style>