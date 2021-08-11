<template>
  <section class="chart_section">
    <button @click="calculateDate">test</button>
    <button @click="check">check</button>
    <header class="chart_header">토마토 밭</header>
    <apexchart type="heatmap" height="350" width="1000" :options="chartOptions" :series="series"></apexchart>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_chart.scss'
// import VueApexCharts from 'vue3-apexcharts'
import { useStore } from 'vuex'
export default {
  name: 'StudyChart',
  setup() {
    const store = useStore()

    function currentDate(){
      var date = new Date();
      var month = leadingZeros(date.getMonth() + 1, 2);
      var today = date.getFullYear() + "-" + month + "-" + leadingZeros(date.getDate(),2);
      console.log(today);
      return today;
    }

    function leadingZeros(n, digits){
      var zero = '';
      n = n.toString();
      if(n.length < digits){
        for(var i = 0; i < digits - n.length; i++)
          zero += '0';
      }
      return zero + n;
    }
    function calculateDate(){
      var tomatoes = store.state.tomatoes;
      var today = new Date(currentDate());
      for(var i = 0; i < tomatoes.length; i++){
          var day1 = new Date(tomatoes[i].date);
          var dateDiff = Math.ceil((today - day1) / (1000*3600*24));
          console.log(dateDiff);
          var temp = dateDiff % 7;
          switch(temp){
            case 0:
                data1[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 1:
                data2[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 2:
                data3[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 3:
                data4[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 4:
                data5[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 5:
                data6[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            case 6:
                data7[Math.ceil(dateDiff/7)] = tomatoes[i].count;
                break;
            
          }
      }
    }
    function check(){
      console.log(data1);
      console.log(data2);
      console.log(data3);
      console.log(data4);
      console.log(data5);
      console.log(data6);
      console.log(data7);
    }
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
    
    const data1 = []
    const data2 = []
    const data3 = []
    const data4 = []
    const data5 = []
    const data6 = []
    const data7 = []

    const series = [
      { name: 'Metric1',
        data: data1
      },
      { name: 'Metric2',
        data: data2
      },
      { name: 'Metric3',
        data: data3
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
      chartOptions,
      calculateDate,
      check
    }
  }
}

</script>

<style>

</style>