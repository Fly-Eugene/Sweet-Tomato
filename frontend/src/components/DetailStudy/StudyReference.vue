<template>
  <article class="reference_content_sub"></article>
  <article class="reference_content">
    <div class="study_data" v-for="data in state.study_data" :key="data.id">
      <div class="study_data_title">{{ data.subject }}</div>
      <div class="study_data_writer">작성자 : {{ data.memberId }}</div>
    </div>


  </article>
</template>

<script>
import '@/assets/style/DetailStudy/study_reference.scss'
import {useStore} from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name : 'StudyReference',

  setup() {
    const store = useStore()

    const state = reactive({
      study_data : computed(() => {
        return store.state.studyData
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