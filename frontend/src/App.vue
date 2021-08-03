<template>
<<<<<<< HEAD
  <div class="innerHeader">
    <Navbar/>  
=======
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link :to="{name: 'AccountLogin'}">AccountLogin</router-link> |
    <router-link :to="{name: 'AccountSignup'}">Signup</router-link> |
    <router-link :to="{name: 'Profile'}">Profile</router-link> | 
    <router-link :to="{name: 'StudyMain'}">StudyMain</router-link> |
    <router-link :to="{name: 'MakeStudy'}">MakeStudy</router-link> |
    <router-link :to="{name: 'Room'}">Room</router-link> |
    <router-link :to="{name: 'Modal'}">Modal 확인</router-link> |
>>>>>>> feature/makeStudy
  </div>
  <router-view/>
</template>

<script>
import '@/assets/style/app.scss'
import Navbar from '@/views/Navbar.vue'

export default {
  name: 'App',

  components: {
    Navbar
  }
}
</script>

