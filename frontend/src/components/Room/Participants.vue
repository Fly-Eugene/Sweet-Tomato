<template>
  <div class="participants_box">
    <div class="participants_header">
      <span>참가자 목록</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="participants_content">
        <li v-for="user in state.participants" :key="user" style="margin: 20px 30px;">
        {{ user }} 
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
  setup(props){
    const store = useStore()
    const state = reactive({
      participants: computed(() => {
        console.log(store.state.participants)
        return store.state.participants;
      })
    })
    return {
      state
    }
  },
}
</script>

<style>

</style>