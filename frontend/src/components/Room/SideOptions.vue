<template>
  <div class="side_option_container">
    <div class="chat_header">
      <span>채팅</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="chat_content" style="height: 80%; overflow-y:scroll;">
      <li v-for="chat in chatContents" :key="chat" style="margin: 20px 30px;">
        <div style="color: #555; margin:5px 0;">
        {{ chat.split('&$')[0] }} | {{ chat.split('&$')[2] }}
        </div>
        {{ chat.split('&$')[1]}}
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