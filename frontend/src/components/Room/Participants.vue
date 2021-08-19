<template>
  <div class="participants_box">
    <div class="participants_header">
      <span>참가자 목록</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="participants_content">
        <li v-for="user in state.participantsInfo" :key="user" style="margin: 20px 30px;">
        {{ user.nickname }} | 
        {{ user.recentlyConnectionTime.split('T')[1] }}
        <span v-if="studyLeader && user.memberId != leaderId" style="color: red; cursor: pointer;" @click="$emit('explusion', user.memberId)">블랙리스트</span>
        </li>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Room/participants.scss'
import { reactive, computed } from 'vue'
import { useStore } from 'vuex'
export default {
  name: 'Participants',
  props:{
      studyLeader: {
      type: Boolean
    },
    leaderId:{
        type:String
    }
  },
  setup(){
    const store = useStore()
    const state = reactive({
      participantsInfo: computed(() => {
        console.log(store.state.participantsInfo)
        return store.state.participantsInfo;
      }),
    })
    return {
      state
    }
  },
}
</script>

<style>

</style>