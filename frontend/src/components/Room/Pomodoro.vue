<template>
  <div class="pomodoro_box">
    <div class="pomodoro_header">
      <span>뽀모도로</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="pomodoro_content">
      <PomodoroSetting v-if="state.pomodoro_setting === true" :studyId="studyId" :pomodoro_setting_data="state.pomodoro_setting_data" @completePomodoroSetting="state.pomodoro_setting = false"/>
      <PomodoroGoalState v-if="state.pomodoro_setting === false" @pomodoroSetting="pomodoroSetting"/>
      <PomodoroState v-if="state.pomodoro_setting === false"/>
      <PomodoroTimer v-if="state.pomodoro_setting === false" :studyId="studyId"/>
    </div>
  </div>
</template>

<script>
import PomodoroSetting from '@/components/Room/Pomodoro/PomodoroSetting'
import PomodoroGoalState from '@/components/Room/Pomodoro/PomodoroGoalState'
import PomodoroState from '@/components/Room/Pomodoro/PomodoroState'
import PomodoroTimer from '@/components/Room/Pomodoro/PomodoroTimer'
import '@/assets/style/Room/pomodoro.scss'
import { onMounted, onUpdated, reactive } from 'vue'
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
      pomodoro_setting: false,
      pomodoro_setting_data: []
    })

    const pomodoroSetting = (value)=>{
      state.pomodoro_setting_data = value
      state.pomodoro_setting = true
    }

    onMounted(() => {
      store.dispatch('getPomodoroGoal', props.studyId)
      store.dispatch('getPomodoroState', props.studyId)
    })

    onUpdated(() => {
      console.log('업데이트 된대!!!!!')
    })

    return {
      state,
      pomodoroSetting
    }
  }
}
</script>

<style>

</style>