<template>
<div>
  <button id="show-modal" @click="state.showModalSample = true">Show Modal Sample</button>
  <button id="show-modal" @click="state.makeStudyModal = true">Make Study Modal</button>
<!-- <div v-if="showModal"> -->
  <!-- <button id="show-modal" @click="showModal = true">Show Modal</button> -->
  
  <div id="circle"><div id="circle2"></div></div>
  <div id="rectangle"></div>

  <ModalContent v-if="state.showModalSample" @closeSample="state.showModalSample = false">
  </ModalContent>

  <MakeStudy v-if="state.makeStudyModal" @closeMakeStudy="state.makeStudyModal = false">
  </MakeStudy>



</div>
</template>

<script>
import '@/assets/style/Modal/modal.scss'
import ModalContent from '@/components/Modal/Content.vue'
import MakeStudy from '@/components/Modal/MakeStudy.vue'
import {onMounted, reactive } from 'vue'

export default {
  name: "Modal",
  components: {
    ModalContent,
    MakeStudy,

  },

  setup() {
    const state = reactive({
      showModalSample : false,
      makeStudyModal : false
    }) 

    onMounted(() => {
      state.showModal = false,
      state.makeStudyModal = false
    })
    

    return {
      state,

    }
  }

}
</script>

<style>
</style>