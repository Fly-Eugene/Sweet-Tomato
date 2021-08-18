<template>
  <div class="card_data">
    <div class="card" v-for="study in state.studies" :key="study">
      <StudyCard :study="study"/>
    </div>
  </div>
  <div class="page_nation">
    <div>이전</div>
    <div v-for="i in state.pages" :key="i">
      <p @click="movePage(i)">{{ i }}</p>
    </div>
    <div>이후</div>
  </div>  
</template>

<script>
import '@/assets/style/StudyMain/study_cards.scss'
import StudyCard from '@/components/StudyMain/StudyCard.vue'
import { useStore } from 'vuex'
import { reactive } from '@vue/reactivity'
import { computed } from '@vue/runtime-core'

export default {
  name: 'StudyCards',

  
  components: {
    StudyCard
  },

  setup(props, { emit }) {
    const store = useStore()
    const state = reactive({
      studies: computed(() => {
        return store.state.searchedStudies
      }),
      pages: computed(() => {
        return store.state.totalPage
      })
    })
    function movePage(pageNum) {
      emit('movePage', pageNum)
    }
    return {
      store,
      state,
      movePage,
    }
  }
}
</script>

<style>

</style>