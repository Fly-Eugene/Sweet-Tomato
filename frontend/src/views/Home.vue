<template>
  <div class="home">
    <div class="circle"></div>
    <div class="rectangle"></div>
    
    <div class="HomeMain">
      <HomeMain/>
    </div>
    
  </div>
</template>

<script>
import '@/assets/style/Home.scss'
import HomeMain from '@/components/Home/HomeMain'

export default {
  name: 'Home',
  components: {
    HomeMain
  }
}
</script>
