<template>
  <div class="card_data" v-for="study in store.state.searchedStudies" :key="study">
    <StudyCard :study="study"/>
  </div>
  <div class="page_nation">
    <span>이전</span>
    <span>1</span>
    <span>2</span>
    <span>3</span>
    <span>이후</span>
  </div>  
</template>

<script>
import '@/assets/style/StudyMain/study_cards.scss'
import StudyCard from '@/components/StudyMain/StudyCard.vue'
// import { reactive } from '@vue/reactivity'
import { useStore } from 'vuex'
import { reactive } from '@vue/reactivity'

export default {
  name: 'StudyCards',

  components: {
    StudyCard
  },

  setup() {
    const store = useStore()
    const state = reactive({
      stuides: store.state.searchedStudies
    })
    return {
      store,
      state
    }
  }
}
</script>

<style>

</style>