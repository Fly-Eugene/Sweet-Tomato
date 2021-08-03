<template>
  <div class="home">
    <div class="circle"></div>
    <div class="rectangle"></div>    
    <div class="HomeMain">
      <HomeMain/>
    </div>
    <div class="HomeMiddle">
      <HomeMiddle/>
    </div>
    <div class="HomeBottom">
      <HomeBottom/>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Home.scss'
import HomeMain from '@/components/Home/HomeMain'
import HomeMiddle from '@/components/Home/HomeMiddle'
import HomeBottom from '@/components/Home/HomeBottom'

export default {
  name: 'Home',
  components: {
    HomeMain,
    HomeMiddle,
    HomeBottom
  }
}
</script>
