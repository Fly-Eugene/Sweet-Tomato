<template>
  <div class="side_option_container">
    <li v-for="chat in chatContents" :key="chat">{{ chat }}</li>
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