<template>
  <section class="card_wrapper">
    <div class="card_name">
      <p>{{ this.study.studyName }}</p>
    </div>
    <div class="card_hashtag">
      <ul v-for="theme in this.study.themes" :key="theme">
        <li>{{ theme }}</li>
      </ul>
    </div>
    <div class="card_img">
      <img :src="`${study_profile_url}`" alt="">
    </div>
    <div class="card_footer">
      <div @click="this.$router.push({name: 'DetailStudy', params: { id: this.study.id }})">
        더보기
      </div>
    </div>
    <!-- <div>{{ this.study }}</div> -->
  </section>
  
</template>

<script>
import '@/assets/style/StudyMain/study_card.scss'
import { useStore } from 'vuex'

export default { 
  name: 'StudyCard',
  
  props: {
    study: Object
  },

  setup(props) {
    const store = useStore()

    function check(study) {
      console.log(study)
    }

    const server_url = store.state.server_url
    const study_profile_url = server_url + 'profile/study?studyId=' + props.study.id

    return {
      check,
      study_profile_url
    }
  }
}
</script>

<style>

</style>