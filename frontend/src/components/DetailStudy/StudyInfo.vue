<template>
  <section class="info_card">
      <article class="info_left">
        <div class="info_img" :style="`background-image : url(${state.img_url})`"></div>
        <!-- <img class="info_img" :src="`${state.image_url}`"> -->
        <button class="apply_btn">신청하기</button>
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

  // props : {
  //   info : {
  //     type: Object,
  //     required: true
  //   }
  // },

  setup() {
    const store = useStore()
    const state = reactive({
      info: computed(() => {
        return store.state.studyInfo
      }),

      img_url : computed(()=> {
        return store.state.studyImg
      })
    })

    console.log(state.img_url, '이게 img_url 인데')

    return {
      state
    }
  }

  
}
</script>

<style>

</style>