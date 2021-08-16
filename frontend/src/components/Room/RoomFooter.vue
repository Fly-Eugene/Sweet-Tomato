<template>
  <div class="room_footer_center">    
    <i class="fas " @click="onClickAudio" :class="this.audio"></i>
    <i class="fas " @click="onClickVideo" :class="this.video"></i>
    <!-- <i class="fas fa-share-alt"></i> -->
    <i class="fas fa-times-circle" @click="$emit('leaveRoom')"></i>
  </div>
  <div class="room_footer_right">
    <i class="fas fa-info-circle" @click="$emit('closeRoomInfo')"></i>
    <i class="fas fa-user-friends" @click="$emit('closeParticipants')"></i>
    <i class="far fa-comment" @click="$emit('closeChatting')"></i>
    <li class="item">
      <i class="hamburger fas fa-bars"></i>
      <ul>
        <li><img src="@/assets/img/tomatoBtn.png" alt="" @click="$emit('closePomodoro')"></li>
        <li><i class="far fa-calendar-plus" @click="$emit('closeCalander')"></i></li>
        <li><i class="fas fa-stopwatch" @click="$emit('closeTimer')"></i></li>
      </ul>
    </li>
  </div>
</template>

<script>
import '@/assets/style/Room/room_footer.scss'
export default {
  name: 'RoomFooter',
  data() {
    return {
      audio: 'fa-phone',
      video: 'fa-video'
    };
  },
  methods: {
    onClickVideo(){
      this.$emit('clickVideo')
      console.log('안녕')
      if(this.video == 'fa-video'){
        this.video = 'fa-video-slash';
      }else{
        this.video = 'fa-video'
      }
    },
    onClickAudio(){
      this.$emit('clickAudio')
      console.log('안녕하세요')
      if(this.audio == 'fa-phone'){
        this.audio = 'fa-phone-slash'
      }else{
        this.audio = 'fa-phone'
      }
    }
  }
}
</script>

<style>

</style>