<template>
  <section class="study_main">
    <StudySearch @studySearch='onSearch'/>
    <StudyCards @movePage='onMove'/>
  </section>
</template>

<script>

import '../assets/style/study_main.scss'
import StudySearch from '@/components/StudyMain/StudySearch.vue'
import StudyCards from '@/components/StudyMain/StudyCards.vue'
import { useStore } from 'vuex'
import { onMounted, reactive } from 'vue'

export default {
  name: "StudyMain",
  
  components: {
    StudySearch,
    StudyCards
  },


  setup(){
    const store = useStore()
    const state = reactive({
      hash: []
    })

    function onSearch(value) {
      store.dispatch('searchStudy', {themes: value, page: 1})
      state.hash = value
    }
    function onMove(pageNum) {
      store.dispatch('searchStudy', {themes: store.state.studyHashtag, page: pageNum})
      state.hash = store.state.studyHashtag
    }
    onMounted(() => {
      store.dispatch('checkLogin')
      store.dispatch('searchStudy', {themes: [], page: 1})
    })
    return {
      store,
      state,
      onSearch,
      onMove
    }
  }
}
</script>

<style>

</style>