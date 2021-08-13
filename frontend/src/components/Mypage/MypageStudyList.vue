<template>
  <section class="mypage_study_list">
    <div class="list_box">
      <header>내 스터디</header>
      <div class="list_wrapper">
        <div class="first_study" @click="this.$router.push({name: 'DetailStudy', params: { id: state.recentStudies[0].study.id }})">
          <p>{{ state.recentStudies[0].study.studyName }}</p>
          <p>({{ state.recentStudies[0].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
        <div class="second_study" @click="this.$router.push({name: 'DetailStudy', params: { id: state.recentStudies[1].study.id }})">
          <p>{{ state.recentStudies[1].study.studyName }}</p>
          <p>({{ state.recentStudies[1].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
        <div class="third_study" @click="this.$router.push({name: 'DetailStudy', params: { id: state.recentStudies[2].study.id }})">
          <p>{{ state.recentStudies[2].study.studyName }}</p>
          <p>({{ state.recentStudies[2].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
      </div>  
    </div>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_study_list.scss'
import { useStore } from 'vuex'
import { onMounted, reactive } from 'vue'

export default {
  name: 'MypageStudyList',
  
  setup() {
    const store = useStore()
    const state = reactive({
      recentStudies: store.state.myRecentStudy
    })

    onMounted(() => {      
      console.log(store.state.myRecentStudy)
    })
    return {
      state,
    }
  }
}
</script>

<style>

</style>