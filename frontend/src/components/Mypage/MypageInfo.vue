<template>
  <section class='mypage_info'>
    <article class='mypage_left'>
      <div class='recent_access'>
        <p>최근 접속</p>      
        <p>{{ this.myStudyList[0].recentlyConnectionTime.slice(0, 10) }} </p>
      </div>
      <div class="studyname">
        <p>{{ this.myStudyList[0].study.studyName }}</p>
      </div>
      <div class="enterBtn">
        <p @click="this.$router.push({name: 'DetailStudy', params: { id: this.myStudyList[0].study.id }})">입장하기</p>
      </div>
    </article>
    <article class='mypage_right'>
      <i class="fas fa-cog"></i>
      <div class="right_top">
        <div class="profile_img">
          <img :src="`${profile_url}`" alt="">
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
  
  props: {
    myStudyList: Object  
  },

  setup(props){
    const store = useStore()
    
    const state = reactive({
      myInfo: store.state.myInfo,
    })

    const server_url = store.state.server_url
    const profile_url = server_url + 'profile/' + state.myInfo.id
    function check() {
      console.log(props.myStudyList)
    }
    return {
      state,
      profile_url,
      check
    }
  }
}
</script>

<style>

</style>