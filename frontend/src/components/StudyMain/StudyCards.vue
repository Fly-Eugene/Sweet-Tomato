<template>
  <div class="card_data">
    <StudyCard/>
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

export default {
  name: 'StudyCards',

  components: {
    StudyCard
  }
}
</script>

<style>

</style>