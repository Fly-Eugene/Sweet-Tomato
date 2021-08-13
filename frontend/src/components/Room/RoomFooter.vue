<template>
  <div class="room_footer_center">    
    <i class="fas fa-phone-alt" ></i>
    <i class="fas fa-video"></i>
    <!-- <i class="fas fa-share-alt"></i> -->
    <i class="fas fa-times-circle"></i>
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
}
</script>

<style>

</style>