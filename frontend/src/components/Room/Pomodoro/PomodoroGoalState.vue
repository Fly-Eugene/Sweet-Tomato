<template>
  <section class="pomodoro_goal">
    <div class="pomodoro_goal_header">
      <span>오늘의 목표</span>
      <p>{{ nowGoal }}</p>
      <button v-if="state.study_pomodoro_goals === null" @click="$emit('pomodoroSetting', [0, 0])" class="pomodoro_setting">설정 버튼</button>
      <button v-else @click="$emit('pomodoroSetting', [1, state.study_pomodoro_goals[state.study_pomodoro_goals.length - 1].tomatoPlanId] )" class="pomodoro_setting">설정 버튼</button>
    </div>
    <div class="pomodoro_goal_state">
      <img src="@/assets/img/tomato1.svg" alt="">
      <span>X</span>
      <span v-if="state.study_pomodoro_goals === null">0</span>
      <!-- <span v-else>{{state.study_pomodoro_goals}}</span> -->
      <span v-else>{{state.study_pomodoro_goals[state.study_pomodoro_goals.length - 1].goalTomato}}</span>
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