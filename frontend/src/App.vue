<template>
  <div>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <div id="nav">
    <router-link :to="{name: 'Home'}">Home</router-link> |
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
  
  <div v-if="state.nav_show" class="innerHeader">
    <Navbar/>
  </div>


  <!-- <div class="startPageTomato">
    <img src="@/assets/img/tomato1.svg" alt="">
    <button @click="$router.push({name: 'Home'})">시작하기</button>
  </div> -->

  <router-view/>
  <div v-if="state.nav_show" class="footer">      
  </div>

</template>

<script>
import '@/assets/style/app.scss'
import Navbar from '@/views/Navbar.vue'
import { useStore } from 'vuex'
import { computed, onMounted, onUnmounted, reactive} from 'vue'

export default {
  name: 'App',

  components: {
    Navbar
  },

  setup() {
    const store = useStore()

    const state = reactive({
      nav_show : computed(()=> {
        return store.state.nav_show
      }),
      // tomato_show : computed(() => {
      //   return store.state.start_page_tomato_show
      // })
    })

    onMounted(() => {
      store.dispatch('checkLogin')
      // store.dispatch('showTomato')
    })

    onUnmounted(() => {
      // store.dispatch('hideTomato')
    })

    
    return {
      state,
    }
  }
}
</script>
