<template>
  <section class="room_wrapper">
    <Pomodoro/>
  </section>
</template>

<script>
import Pomodoro from '@/components/Room/Pomodoro'
import '@/assets/style/Room/room_wrapper.scss'

export default {
  name: 'Room',

  components: {
    Pomodoro
  }
}
</script>

<style>

</style>