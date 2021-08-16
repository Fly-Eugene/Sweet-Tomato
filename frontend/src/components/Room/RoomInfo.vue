<template>
  <div class="participants_box">
    <div class="participants_header">
      <span>스터디 정보</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="participants_content">
        <img class="info_img" :src="`${study_profile_url}`">
        <div>{{this.state.info.studyName}}</div>
        <div>{{this.state.info.studyIntro}}</div>
        <div>{{this.state.info.themes}}</div>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Room/participants.scss'
import { reactive, computed } from 'vue'
import { useStore } from 'vuex'
export default {
  name: 'RoomInfo',
  setup(){
    const store = useStore()
    const state = reactive({
      info: computed(() => {
        return store.state.studyInfo
      }),
    })
    const server_url = store.state.server_url
    const study_profile_url = server_url + 'profile/study?studyId=' + state.info.id;
    return {
      state,
      study_profile_url
    }
  },
}
</script>

<style>

</style>