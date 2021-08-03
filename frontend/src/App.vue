<template>
  <div class="innerHeader">
    <Navbar/>  
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

