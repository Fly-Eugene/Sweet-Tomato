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
        <li><router-link :to="{name: 'AccountLogin'}" class="loginBtn">로그인</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
import '@/assets/style/navbar.scss'

export default {
  name: "Navbar"

}
</script>

<style>

</style>