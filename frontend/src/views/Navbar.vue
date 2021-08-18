<template>
  <div class="navbar">
    <div class="nav_logo">      
      <router-link to="/">
        <img src="@/assets/img/sweet_tomato.png" alt="">
      </router-link>
    </div>
    <div class="nav_content">
      <ul class="gnb">
        <li><router-link to="/">개요</router-link></li>
        <li><router-link :to="{name: 'StudyMain'}">스터디 찾기</router-link></li>
        <li v-if="state.isLogin === true"><div id="show-modal" @click="onClickMakeStudy">스터디 만들기</div></li>
        <li v-if="state.isLogin === false"><router-link :to="{name: 'AccountLogin'}" class="loginBtn">로그인</router-link></li>
        <li v-if="state.isLogin === true" @click="onClickLogout"><p class="loginBtn">로그아웃</p></li>
      </ul>
    </div>
  </div>

  <MakeStudy v-if="state.makeStudyModal" @closeMakeStudy="state.makeStudyModal = false">
  </MakeStudy>
</template>

<script>
import '@/assets/style/navbar.scss'
import MakeStudy from '@/components/Modal/MakeStudy.vue'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: "Navbar",
  components : {
    MakeStudy,
  },

  setup() {
    const store = useStore()
    const state = reactive({
      isLogin : computed(() => {
        return store.state.isLogin
      }),
      showModalSample : false,
      makeStudyModal : false
    })

    function onClickLogout() {
      store.dispatch('logout')
    }

    function onClickMakeStudy(){
      if (store.state.isLogin === true ) {
        state.makeStudyModal = true
      }
      else {
        alert('로그인 후 이용 바랍니다.')
      }
    }


    return {
      state,
      onClickLogout,
      onClickMakeStudy
    }
  }

}
</script>

<style>

</style>