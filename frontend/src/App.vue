<template>
  <div>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link :to="{name: 'AccountLogin'}">AccountLogin</router-link> |
      <router-link :to="{name: 'AccountSignup'}">Signup</router-link> |
      <router-link :to="{name: 'StudyMain'}">StudyMain</router-link> |
      <router-link :to="{name: 'OpenVidu'}">OpenVidu</router-link> |
      <router-link :to="{name: 'Modal'}">Modal 확인</router-link> |
      <!-- 스터디 디테일 페이지에 대해 동적 라우터를 형성합니다. 현재 테스트 중이므로 스터디 1번으로 동적 라우팅 -->
      <router-link :to="{name: 'DetailStudy', params: {id: 1}}">Study Detail</router-link> |
      <router-link :to="{name: 'Mypage'}">Mypage</router-link> |
      <router-link :to="{name: 'Room'}">RoomCheck</router-link> |
    </div>
    
    <div class="innerHeader">
      <Navbar/>
    </div>
    <router-view/>
    <div class="footer">      
    </div>
  </div>

</template>

<script>
import '@/assets/style/app.scss'
import Navbar from '@/views/Navbar.vue'
import $axios from 'axios'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: 'App',

  components: {
    Navbar
  },

  setup() {
    const state = reactive({
      accessToken : computed(() => {
        return localStorage.getItem('jwt')
      })
    })

    const store = useStore()
    
    if (state.accessToken) {
      store.state.isLogin = true
    } else {
      store.isLogin = false
    }

    if (state.accessToken) {
      $axios.defaults.headers.common['Authorization'] = `Bearer ${state.accessToken}`
    } else {
      $axios.defaults.headers.common['Authorization'] = null
    }
    

  }
}
</script>
