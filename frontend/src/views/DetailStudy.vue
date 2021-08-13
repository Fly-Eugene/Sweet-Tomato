<template>
  <div class="detail_study_all">
    <StudyInfo :studyId='id' @onClickEdit="state.onInfoEdit = true"/>
    <StudyInfoEdit v-if="state.onInfoEdit === true" :studyId='id' @onClickClose="state.onInfoEdit = false"/>
    <TomatoRate/>
    <StudyChart/>
    <StudyCommentNRefer :studyId='id'/>
  </div>
</template>

<script>
import '@/assets/style/detail_study.scss'
import { onMounted, reactive} from 'vue'
import { useStore } from 'vuex'
import StudyInfo from '@/components/DetailStudy/StudyInfo.vue'
import StudyInfoEdit from '@/components/DetailStudy/StudyInfoEdit.vue'
import StudyChart from '@/components/DetailStudy/StudyChart.vue'
import TomatoRate from '@/components/DetailStudy/TomatoRate.vue'
import StudyCommentNRefer from '@/components/DetailStudy/StudyCommentNRefer.vue'


export default {
  name: "DetailStudy",
  components: {
    StudyInfo,
    StudyInfoEdit,
    StudyChart,
    TomatoRate,
    StudyCommentNRefer
  },

  props : {
    id : {
      type: String,
    }
  },

  setup(props) {
    const store = useStore()
    const state = reactive({
      onInfoEdit : false
    })

    onMounted(() => {
      store.dispatch('checkLogin')
      store.dispatch('getStudyInfo', props.id)
      store.dispatch('getComments', props.id)
      store.dispatch('getData', props.id)
      store.dispatch('getStudyTomato', props.id)
    })

    return {
      state,
    }
  }

}

</script>
