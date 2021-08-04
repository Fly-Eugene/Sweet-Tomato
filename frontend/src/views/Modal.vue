<template>
<div v-if="showModal">
  <button id="show-modal" @click="showModal = true">Show Modal</button>
  
  <div id="circle"><div id="circle2"></div></div>
  <div id="rectangle"></div>

  <ModalContent @close="showModal = false">
  </ModalContent>

</div>
</template>

<script>
import '@/assets/style/modal.scss'
import ModalContent from '@/components/Modal/Content.vue'
import {ref} from 'vue'

export default {
  name: "Modal",
  components: {
    ModalContent
  },

  setup() {
    const showModal = ref('false')
    
  
    return {
      showModal

    }
  }

}
</script>

<style>
</style>