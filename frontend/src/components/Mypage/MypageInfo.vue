<template>
  <section class='mypage_info'>
    <article class='mypage_left'>
      <div class='recent_access'>
        <p>최근 접속</p>
        <p>{{ state.recentStudies[0].recentlyConnectionTime.slice(0, 10) }} </p>
        <p>{{ state.recentStudies[0].recentlyConnectionTime.slice(11, 16) }}</p>
      </div>
      <div class="studyname">
        <p>{{ state.recentStudies[0].study.studyName }}</p>
      </div>
      <div class="enterBtn">
        <p @click="this.$router.push({name: 'DetailStudy', params: { id: state.recentStudies[0].study.id }})">입장하기</p>
      </div>
    </article>
    <article class='mypage_right'>
      <i class="fas fa-cog"></i>
      <div class="right_top">
        <div class="profile_img">
          <img src="@/assets/img/basic_profile.png" alt="">
        </div>
        <div class="profile_welcome">
          <p>어서오세요</p>
          <p>{{ state.myInfo.username }} 님</p>
        </div>
      </div>
      <div class="right_bottom">
        <div class="email">
          <span>Email</span>
          <span>{{ state.myInfo.email }}</span>
        </div>
        <div class="group">
          <span>Group</span>
          <span>{{ state.myInfo.department }}</span>
        </div>
      </div>
    </article>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_info.scss'
import { useStore } from 'vuex'
import { reactive } from 'vue'


export default {
  name: 'MypageInfo',

  setup() {
    const store = useStore()
    const state = reactive({
      myInfo: store.state.myInfo,
      // myProfile: store.state.server_url + 'profile/' + state.myInfo.id,
      recentStudies: store.state.myRecentStudy
    })
    function check() {
      console.log(state.myInfo)
    }
    return {
      state,
      check
    }
  }
}
</script>

<style>

</style>