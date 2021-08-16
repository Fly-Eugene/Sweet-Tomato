<template>
  <div class="pomodoro_box">
    <div class="pomodoro_header">
      <span>뽀모도로</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="pomodoro_content">
      <PomodoroSetting v-if="state.pomodoro_setting === true" :studyId="studyId" @completePomodoroSetting="state.pomodoro_setting = false"/>
      <PomodoroGoalState v-if="state.pomodoro_setting === false" @gotoPomodoroSetting="state.pomodoro_setting = true"/>
      <PomodoroState v-if="state.pomodoro_setting === false"/>
      <PomodoroTimer v-if="state.pomodoro_setting === false"/>
    </div>
  </div>
</template>

<script>
import PomodoroSetting from '@/components/Room/Pomodoro/PomodoroSetting'
import PomodoroGoalState from '@/components/Room/Pomodoro/PomodoroGoalState'
import PomodoroState from '@/components/Room/Pomodoro/PomodoroState'
import PomodoroTimer from '@/components/Room/Pomodoro/PomodoroTimer'
import '@/assets/style/Room/pomodoro.scss'
import { computed, onMounted, reactive } from 'vue'
import { useStore } from 'vuex'

export default {
  name: 'Pomodoro',
  props: {
    studyId: {
      type: String,
      required: true
    }
  },
  components: {
    PomodoroSetting,
    PomodoroGoalState,
    PomodoroState,
    PomodoroTimer
  },

  setup(props){

    const store = useStore()
    const state = reactive({
      study_pomodoro_goals: computed(()=> {
        return store.state.studyPomodoroGoals
      }),

      pomodoro_setting: false
    })

    onMounted(() => {
      store.dispatch('getPomodoroGoal', props.studyId)
    })

    return {
      state
    }
  }
}
</script>

<style>

</style>