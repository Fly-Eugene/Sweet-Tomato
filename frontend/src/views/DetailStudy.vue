<template>
  <div class="detail_study_all">
    <StudyInfo :studyId='id'/>
    <TomatoRate/>
    <StudyChart/>
    <StudyCommentNRefer :studyId='id'/>
  </div>
</template>

<script>
import '@/assets/style/detail_study.scss'
import { onMounted} from 'vue'
import { useStore } from 'vuex'
import StudyInfo from '@/components/DetailStudy/StudyInfo.vue'
import StudyChart from '@/components/DetailStudy/StudyChart.vue'
import TomatoRate from '@/components/DetailStudy/TomatoRate.vue'
import StudyCommentNRefer from '@/components/DetailStudy/StudyCommentNRefer.vue'

export default {
  name: "DetailStudy",
  components: {
    StudyInfo,
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

    onMounted(() => {
      console.log('onMounted 실행')
      store.dispatch('getStudyInfo', props.id)
      // store.dispatch('getStudyImg', props.id )
      store.dispatch('getComments', props.id)
      store.dispatch('getData', props.id)
      store.dispatch('getStudyTomato', props.id)
    })

    return {
      // comment_or_refer,
      // changeToComment,
      // changeToRefer

    }
  }

}

</script>
