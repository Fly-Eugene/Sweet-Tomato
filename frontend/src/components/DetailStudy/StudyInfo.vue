<template>
  <section class="info_card">
      <article class="info_left">
        <!-- <div class="info_img" :style="`background-image : url(${study_profile_url})`"></div> -->
        <img class="info_img" :src="`${study_profile_url}`">
        <button class="apply_btn" @click="onClickStudyApply">신청하기</button>
        
      </article>
      <article class="info_right">
        <div class="info_name">{{ state.info.studyName }}</div>
        <div class="info_tags">
          <span class="info_tag" v-for="tag in state.info.themes" :key="tag">{{ tag }}</span>
        </div>
        <div class="info_content">{{ state.info.studyIntro }}</div>
        <button class="enter_btn ">입장하기</button>
      </article>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_info.scss'
import { reactive } from 'vue'
import { computed } from '@vue/runtime-core'
import { useStore } from 'vuex'

export default {
  name: 'StudyInfo',

  props: {
    studyId: {
      type: String,
      required: true,
    }
  },

  setup(props) {
    const store = useStore()
    const state = reactive({
      info: computed(() => {
        return store.state.studyInfo
      }),

      img_url : computed(()=> {
        return store.state.studyImg
      })
    })

    const server_url = store.state.server_url
    const study_profile_url = server_url + 'profile/study?studyId=' + props.studyId



    const onClickStudyApply = function() {
      store.dispatch('studyApply', props.studyId)
    }


    return {
      state,
      study_profile_url,
      onClickStudyApply
    }
  }

  
}
</script>

<style>

</style>