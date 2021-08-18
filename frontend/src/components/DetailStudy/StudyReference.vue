<template>
  <StudyModalRefer v-if="state.showDataModal === true && Object.keys(state.study_data_speci).length" @close="state.showDataModal = false" @clickEdit="onClickEdit"/>
  <StudyReferenceEdit v-if="state.showEditModal === true" @editClose="state.showEditModal = false"/>

  <article class="reference_content_sub"></article>
  <article class="reference_content">
    <div class="study_data" v-for="data in state.study_data" :key="data.id" @click="onClickStudyDataSpeci(data)">
      <div class="study_data_title">{{ data.subject }}</div>
      <div class="study_data_writer">작성자 : {{ data.member.username }}</div>
    </div>
  </article>
</template>

<script>
import '@/assets/style/DetailStudy/study_reference.scss'
import StudyModalRefer from '@/components/DetailStudy/StudyModalRefer.vue'
import StudyReferenceEdit from '@/components/DetailStudy/StudyReferenceEdit.vue'
import {useStore} from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name : 'StudyReference',
  components: {
    StudyModalRefer,
    StudyReferenceEdit,
  },

  setup() {
    const store = useStore()

    const state = reactive({
      study_data : computed(() => {
        return store.state.studyData
      }),

      showDataModal: false,
      showEditModal: false,

      study_data_speci : computed(() => {
        return store.state.studyDataSpeci
      })
    })

    function onClickStudyDataSpeci(data){
      store.dispatch('getDataSpeci', data.id)
      state.showDataModal = true
    }

    function onClickEdit() {
      state.showDataModal = false
      state.showEditModal = true
    }


    return {
      state,
      onClickStudyDataSpeci,
      onClickEdit

    }
  }

} 
</script>

<style>

</style>