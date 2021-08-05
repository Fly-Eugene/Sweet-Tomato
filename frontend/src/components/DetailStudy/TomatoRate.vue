<template>
  <section class="tomato_section">
    <header class="tomato_header">우리 토마토</header>
    <apexchart width="500" type="bar" :options="options" :series="series"></apexchart>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/tomato_rate.scss'

export default {
  name: 'TomatoRate',


  setup() {

    const options = {
      chart: {
        id: 'vuechart-example'
      },
      xaxis: {
        categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998]
      }
    }
    
    const series = [{
      name: 'series-1',
      data: [30, 40, 45, 50, 49, 60, 70, 91]
    }]




    return {
      options,
      series,

    }
  }

}
</script>

<style>

</style>