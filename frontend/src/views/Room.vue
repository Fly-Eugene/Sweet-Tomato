<template>
  <section class="room_wrapper">
    <section class="room_top">      
      <section class="room_left">
        <OpenVidu :studyId='studyId' :leave='state.leave' :chat='state.chat' :audio='state.audio' :video='state.video' :part='state.part' @closeBtn="closeEveryDialog"/>
      </section>
      <section v-if="state.rightOn" class="room_right">
        <div v-if="state.dialog[0]">
          <RoomInfo @closeBtn="closeEveryDialog"/> 
        </div>
        <div v-if="state.dialog[1]">
          <!-- <Participants @closeBtn="closeEveryDialog"/> -->
        </div>
        <div v-if="state.dialog[2]">
          <!-- <Chatting/> -->
          <!-- <SideOptions/> -->
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
        @closeTimer="onCloseTimer"
        @leaveRoom="onLeaveRoom"
        @clickAudio="onClickAudio"
        @clickVideo="onClickVideo"/>
    </section>
  </section>
</template>

<script>
import OpenVidu from '@/views/Openvidu'
import Pomodoro from '@/components/Room/Pomodoro'
import Timer from '@/components/Room/Timer'
import RoomFooter from '@/components/Room/RoomFooter'
import SideOptions from '@/components/Room/SideOptions'
import Participants from '@/components/Room/Participants'
import RoomInfo from '@/components/Room/RoomInfo'
import '@/assets/style/room_wrapper.scss'
import { reactive } from '@vue/reactivity'

export default {
  name: 'Room',
  props : {
    studyId : {
      type: String,
      required: true
    }
  },
  components: {
    OpenVidu,
    Pomodoro,
    Timer,
    RoomFooter,
    SideOptions,
    Participants,
    RoomInfo
  },

  setup() {
    const state = reactive({
      // 0: 정보 / 1: 참여자 / 2: 채팅 / 3: 뽀모도로 / 4: 캘린더 / 5: 타이머
      dialog: {0: false, 1: false, 2: false, 3: false, 4: false, 5: false},
      rightOn: false,
      leave: false,
      chat: false,
      audio: true,
      video: true,
      part: false
    })
    
    function closeEveryDialog () {
      for (var key in state.dialog) {
        if (state.dialog[key] == true) {
          state.dialog[key] = false
        }
      }
      state.chat = false
      state.rightOn = false
      state.part = false
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
      state.part = true
    }
    function onCloseChatting () {
      closeEveryDialog()
      state.rightOn = true
      state.dialog[2] = true
      state.chat = true
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
    function onLeaveRoom () {
      state.leave = true
    }
    function onClickAudio(){
      console.log("??여긴")
      if(state.audio) state.audio = false
      else state.audio = true
    }
    function onClickVideo(){
      if(state.video) state.video = false
      else state.video = true
    }
    return {
      onCloseRoomInfo,
      onCloseParticipants,
      onCloseChatting,
      onClosePomodoro,
      onCloseCalander,
      onCloseTimer,
      closeEveryDialog,
      onLeaveRoom,
      onClickAudio,
      onClickVideo,
      state
    }
  },
}
</script>

<style>

</style>