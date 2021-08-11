<template>
  <section class="study_main">
    <StudySearch/>
    <StudyCards/>
  </section>
</template>

<script>

import '../assets/style/study_main.scss'
import StudySearch from '@/components/StudyMain/StudySearch.vue'
import StudyCards from '@/components/StudyMain/StudyCards.vue'
import { useStore } from 'vuex'
import { onMounted } from 'vue'

export default {
  name: "StudyMain",
  
  components: {
    StudySearch,
    StudyCards
  },

  setup(){
    const store = useStore()

    onMounted(() => {
      store.dispatch('checkLogin')
    })
  }
}
</script>

<style>

</style>