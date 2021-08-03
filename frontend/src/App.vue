<template>
  <div>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">    
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

export default {
  name: 'App',

  components: {
    Navbar
  }
}
</script>
