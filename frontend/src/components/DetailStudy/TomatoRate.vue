<template>
  <section class="tomato_section">
    <header class="tomato_header">우리 토마토</header>
    <apexchart width="500" type="donut" :options="options" :series="series"></apexchart>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/tomato_rate.scss'

export default {
  name: 'TomatoRate',


  setup() {

    const options = {}
    
    const series =  [44, 55, 41, 17, 15]




    return {
      options,
      series,

    }
  }

}
</script>

<style>

</style>