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

export default {
  name: "StudyMain",
  
  components: {
    StudySearch,
    StudyCards
  }
}
</script>

<style>

</style>