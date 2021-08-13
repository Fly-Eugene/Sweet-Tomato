<template>
  <section class="room_wrapper">
    <section class="room_top">      
      <section class="room_left">
        <!-- <OpenVidu/> -->
      </section>
      <section v-if="state.rightOn" class="room_right">
        <div v-if="state.dialog[0]">
          <!-- <RoomInfo/> -->
        </div>
        <div v-if="state.dialog[1]">
          <!-- <Participants/> -->
        </div>
        <div v-if="state.dialog[2]">
          <!-- <Chatting/> -->
        </div>
        <div v-if="state.dialog[3]">
          <Pomodoro @closeBtn="closeEveryDialog"/>
        </div>
        <div v-if="state.dialog[4]">
          <!-- <Calander/> -->
        </div>
        <div v-if="state.dialog[5]">
          <Timer @closeBtn="closeEveryDialog"/>
        </div>
      </section>
    </section>    
    <section class="room_footer">
      <RoomFooter
        @closeRoomInfo="onCloseRoomInfo"
        @closeParticipants="onCloseParticipants"
        @closeChatting="onCloseChatting"
        @closePomodoro="onClosePomodoro"
        @closeCalander="onCloseCalander"
        @closeTimer="onCloseTimer"/>
    </section>
  </section>
</template>

<script>
// import OpenVidu from '@/views/OpenVidu'
import Pomodoro from '@/components/Room/Pomodoro'
import Timer from '@/components/Room/Timer'
import RoomFooter from '@/components/Room/RoomFooter'
import '@/assets/style/room_wrapper.scss'
import { reactive } from '@vue/reactivity'

export default {
  name: 'Room',

  components: {
    // OpenVidu,
    Pomodoro,
    Timer,
    RoomFooter,
  },

  setup() {
    const state = reactive({
      // 0: 정보 / 1: 참여자 / 2: 채팅 / 3: 뽀모도로 / 4: 캘린더 / 5: 타이머
      dialog: {0: false, 1: false, 2: false, 3: false, 4: false, 5: false},
      rightOn: false
    })
    
    function closeEveryDialog () {
      for (var key in state.dialog) {
        if (state.dialog[key] == true) {
          state.dialog[key] = false
        }
      }
      state.rightOn = false
    }

    function onCloseRoomInfo () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[0] = true
    }
    function onCloseParticipants () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[1] = true
    }
    function onCloseChatting () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[2] = true
    }
    function onClosePomodoro () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[3] = true
    }
    function onCloseCalander () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[4] = true
    }
    function onCloseTimer () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[5] = true
    }

    return {
      onCloseRoomInfo,
      onCloseParticipants,
      onCloseChatting,
      onClosePomodoro,
      onCloseCalander,
      onCloseTimer,
      closeEveryDialog,
      state
    }
  },
}
</script>

<style>

</style>