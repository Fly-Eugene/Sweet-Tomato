<template>
  <div class="detail_study_all">
    <StudyInfo/>
    <TomatoRate/>
    <StudyChart/>
    <StudyComment/>
  </div>
</template>

<script>
import '@/assets/style/detail_study.scss'
import { onMounted } from 'vue'
import $axios from 'axios'
// import useStore from 'vuex'
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
      type: Number,
    }
  },

  setup(props) {
    
    
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
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })

      



    })

    return {
      
    }
  }



  
}

</script>
