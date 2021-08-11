<template>
  <section class="info_card">
      <article class="info_left">
        <div class="info_img" :style="`background-image : url(${state.img_url})`"></div>
        <!-- <img class="info_img" :src="`${state.image_url}`"> -->
        <button class="apply_btn" @click="onClickStudyApply" v-if="!state.checkflag">신청하기</button>
        <button class="apply_btn" @click="onClickStudyResign" v-if="state.checkflag">탈퇴하기</button>
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
import { onMounted} from 'vue'
import { useStore } from 'vuex'
import $axios from 'axios';

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
      }),

      checkflag: computed(() => {
        return store.state.checkflag
      })
    })
    onMounted(() => {
      $axios({
        method: 'get',
        url: store.state.server_url + 'member/studycheck/' + props.studyId
      })
      .then(res => {
        console.log('스터디가입' + res.data)
        store.state.checkflag = res.data
      })
      .catch(err => {
        console.log(err)
      })
    })

    const server_url = store.state.server_url
    const study_profile_url = server_url + 'profile/study?studyId=' + props.studyId



    const onClickStudyApply = function() {
      store.dispatch('studyApply', props.studyId)
      store.state.checkflag = true;
    }
    const onClickStudyResign = function(){
      store.dispatch('studyResign', props.studyId)
      store.state.checkflag = false;
    }

    return {
      state,
      onClickStudyApply,
      onClickStudyResign,
      study_profile_url
    }
  }

  
}
</script>

<style>

</style>