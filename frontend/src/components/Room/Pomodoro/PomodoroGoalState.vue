<template>
  <section class="pomodoro_goal">
    <div class="pomodoro_goal_header">
      <span>오늘의 목표</span>
      <button @click="$emit('gotoPomodoroSetting')">설정 버튼</button>
    </div>
    <div class="pomodoro_goal_state">
      <img src="@/assets/img/tomato1.svg" alt="">
      <span>X</span>
      <span v-if="state.study_pomodoro_goals.goalTomato === null">0</span>
      <span v-else>{{state.study_pomodoro_goals.goalTomato}}</span>
    </div>
  </section>
</template>

<script>
import { computed, reactive } from 'vue'
import { useStore } from 'vuex'
import '@/assets/style/Room/Pomodoro/pomodoro_goal_state.scss'


export default {
  name: 'PomodoroGoalState',

  setup(){
    const store = useStore()
    const state = reactive({
      study_pomodoro_goals: computed(()=> {
        return store.state.studyPomodoroGoals
      })
    })

    return {
      state
    }
  }

}
</script>

<style>

</style>