<template>
  <section class="info_card">
      <article class="info_left">
        <div class="info_img" :style="`background-image : url(${image_url})`">이미지 표시 구간</div>
        <button class="apply_btn">신청하기</button>
      </article>
      <article class="info_right">
        <div class="info_name">{{ info.studyName }}</div>
        <div class="info_tags">
          <span class="info_tag" v-for="tag in info.themes" :key="tag">{{ tag }}</span>
        </div>
        <div class="info_content">{{ info.studyIntro }}</div>
        <button class="enter_btn ">입장하기</button>
      </article>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_info.scss'

export default {
  name: 'StudyInfo',

  props : {
    info : {
      type: Object,
      required: true
    }
  },

  setup(props) {
    console.log('여기는 Study_info', props)

    const image_url = 'http://localhost:5001/' + props.info.profile.image
    console.log(image_url)


    return {

    }
  }

  
}
</script>

<style>

</style>