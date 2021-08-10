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
        <li v-if="state.isLogin === false"><router-link :to="{name: 'AccountLogin'}" class="loginBtn">로그인</router-link></li>
        <li v-if="state.isLogin === true" @click="onClickLogout"><p class="loginBtn">로그아웃</p></li>
      </ul>
    </div>
  </div>
</template>

<script>
import '@/assets/style/navbar.scss'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: "Navbar",

  setup() {
    const store = useStore()
    const state = reactive({
      isLogin : computed(() => {
        return store.state.isLogin
      })
    })

    console.log(state.isLogin, '나 지금 navbar !!!!')

    function onClickLogout() {
      store.dispatch('logout')
    }


    return {
      state,
      onClickLogout
    }
  }

}
</script>

<style>

</style>