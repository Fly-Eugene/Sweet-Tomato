<template>
  <div class="detail_study_all">
    <StudyInfo />
    <!-- <StudyInfo :info='state.info' v-if='Object.keys(state.info).length'/> -->
    <TomatoRate/>
    <StudyChart/>
    <StudyComment :studyId='id' v-if="comment_or_refer === 'comment'" @onClickCommentBtn="changeToComment" @onClickReferenceBtn="changeToRefer"/>
    <StudyReference  v-if="comment_or_refer === 'refer'"/>

  </div>
</template>

<script>
import '@/assets/style/detail_study.scss'
import { onMounted, ref } from 'vue'
import { useStore } from 'vuex'
import StudyInfo from '@/components/DetailStudy/StudyInfo.vue'
import StudyChart from '@/components/DetailStudy/StudyChart.vue'
import TomatoRate from '@/components/DetailStudy/TomatoRate.vue'
import StudyComment from '@/components/DetailStudy/StudyComment.vue'
import StudyReference from '@/components/DetailStudy/StudyReference.vue'

export default {
  name: "DetailStudy",
  components: {
    StudyInfo,
    StudyChart,
    TomatoRate,
    StudyComment,
    StudyReference
  },

  props : {
    id : {
      type: String,
    }
  },

  setup(props) {
    const store = useStore()
    const comment_or_refer = ref('comment')

    function changeToComment() {
      comment_or_refer.value = 'comment'
    }

    function changeToRefer() {
      comment_or_refer.value = 'refer'
    }


    
    onMounted(() => {
      console.log('onMounted 실행')
      store.dispatch('getStudyInfo', props.id)
      store.dispatch('getStudyImg', props.id )
      store.dispatch('getComments', props.id)
    })

    return {
      comment_or_refer,
      changeToComment,
      changeToRefer

    }
  }

}

</script>
