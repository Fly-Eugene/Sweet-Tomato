<template>
  <div class="side_option_container">
    <div class="chat_header">
      <span>채팅</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="chat_content">
      <li v-for="chat in chatContents" :key="chat">
        {{ chat.split(' ')[0] }}
        {{ chat.split(' ')[1] }}
        {{ chat.split(' ')[2]}}
      </li>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Room/side_options.scss'

export default {
  name: 'SideOptions',

  props: {
    chatContents: {
      type: Array
    }
  },


  setup(){

    return {

    }
  }
}
</script>

<style>

</style>