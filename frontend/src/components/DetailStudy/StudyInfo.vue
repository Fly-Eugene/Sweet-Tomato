<template>
  <section class="info_card">
      <article class="info_left">
        <div class="info_img" src="" alt=""></div>
        <!-- <img class="info_img" :src="`${image_url}`"> -->
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
    const image_url = props.info.profile.path + props.info.profile.thumbnail
    console.log(image_url)

    return {
      image_url,
      
    }
  }

  
}
</script>

<style>

</style>