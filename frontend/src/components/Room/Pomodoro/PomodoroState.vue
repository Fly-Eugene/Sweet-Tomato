<template>
  <div class="pomodoro_state">
    <article class="state_header">
      <span>목표 달성치</span>
      <span></span>
    </article>
    <article class="state_content">
      <div class="state_content_wrapper">
        <div class="state_profile" v-for="member_tomato in state.study_pomodoro_state" :key="member_tomato">
          <span>{{member_tomato.memberId}}</span>
          <div class="bar">
            <div class="bar_front" :style="`width: ${percent_tomato(study_today_goal, member_tomato.count)}%`"></div>
          </div>
        </div>
        <!-- <div class="state_profile">
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
        </div> -->
      </div>
    </article>
  </div>
</template>

<script>
import '@/assets/style/Room/Pomodoro/pomodoro_state.scss'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: 'PomodoroState',

  setup(){
    const store = useStore()
    const state = reactive({
      study_pomodoro_state: computed(() => {
        return store.state.studyPomodoroState
      })
    })

    const study_today_goal = 10
    function percent_tomato(study_today_goal, member_tomato) {
      let percent = member_tomato / study_today_goal * 100
      if (percent > 100) {
        percent = 100
      }
      return percent
    }

    return {
      state,
      study_today_goal,
      percent_tomato
    }
  }
}
</script>

<style>

</style>