<template>
  <section class="chart_section">
    <header class="chart_header">토마토 밭</header>
    <apexchart type="heatmap" height="350" width="1000" :options="chartOptions" :series="series"></apexchart>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/cstudy_chart.scss'
// import VueApexCharts from 'vue3-apexcharts'

export default {
  name: 'StudyChart',

  setup() {
    function generateData(cnt, min, max) {
      let i
      const res = []
      min = Math.ceil(min);
      max = Math.floor(max);
      for (i=0; i<cnt; i++) {
        res.push(Math.floor(Math.random() * (max - min + 1)) + min)
      }
      return res; //최댓값도 포함, 최솟값도 포함
    }

    const series = [
      { name: 'Metric1',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric2',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric3',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric4',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric5',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric6',
        data: generateData(18, 0, 90)
      },
      { name: 'Metric7',
        data: generateData(18, 0, 90)
      }
    ]

    const chartOptions = {
      chart: {
        height: 350,
        type: 'heatmap',
        toolbar: {
          show: false   // 그 위에 확대 축소 다운로드 버튼 없애기
        }
      },
      dataLabels: {
        enabled: false  // 하나하나숫자 나타내기 할거냐 옵션
      },
      colors: ["#E94846"],
      title: {
        text: ''
      },
    }


    return {
      series,
      chartOptions
    }
  }
}

</script>

<style>

</style>