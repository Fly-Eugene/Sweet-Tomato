<template>
  <div class="detail_study_all">
    <StudyInfo :info='state.info' v-if='Object.keys(state.info).length'/>
    <TomatoRate/>
    <StudyChart/>
    <StudyComment :studyId='id'/>

  </div>
</template>

<script>
import '@/assets/style/detail_study.scss'
import { onMounted, reactive, ref } from 'vue'
import $axios from 'axios'
import { useStore } from 'vuex'
import StudyInfo from '@/components/DetailStudy/StudyInfo.vue'
import StudyChart from '@/components/DetailStudy/StudyChart.vue'
import TomatoRate from '@/components/DetailStudy/TomatoRate.vue'
import StudyComment from '@/components/DetailStudy/StudyComment.vue'


export default {
  name: "DetailStudy",
  components: {
    StudyInfo,
    StudyChart,
    TomatoRate,
    StudyComment,
    // StudyReference
  },

  props : {
    id : {
      type: String,
    }
  },

  setup(props) {

    const check = ref(0)
    const state = reactive({
      info : {}
    })
    
    onMounted(() => {
      console.log('onMounted 실행')
      $axios({
        method: 'get',
        url: 'https://localhost:5000/study',
        params : {
          id : props.id
        }
      })
      .then(res => {
        console.log(res.data.data)

        state.info = res.data.data
        console.log(state.info)
      })
      .catch(err => {
        console.log(err)
      }),

      useStore().dispatch('getComments', props.id)
    })

    return {
      state,
      check
    }
  }



  
}

</script>
