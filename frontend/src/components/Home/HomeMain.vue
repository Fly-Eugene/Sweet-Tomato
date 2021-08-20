<template>
  <div class="below_box">
    <div class="front_box">
      <div class="box_left">
        <div class="wrapper">
          <div class="title">
            <span>토마토와 함께</span>
            <span>공부하세요</span>
          </div>
          <div class="content">          
            <span>스터디 전용 화상 채팅 서비스</span>
            <span>스윗 토마토</span>
          </div>
          <button @click="start" style="cursor:pointer;">시작하기</button>
        </div>
      </div>        
      <div class="box_right">
        <img src="@/assets/img/tomato1.svg" alt="">
      </div>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Home/HomeMain.scss'
import router from '@/router'

export default {
  name: 'HomeMain',
  methods: {
    start(){
      router.push({name:'AccountSignup'})
    }
  }
}

</script>

<style>

</style>