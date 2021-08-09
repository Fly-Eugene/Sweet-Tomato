<template>
  <section class="mypage_tomato">
    <header class="mypage_tomato_header">내 토마토</header>
    <div id="chart"></div>
    <div class="tomato">
      <img src="@/assets/img/tomato1.svg" alt="">
      <div class="tomato_cnt">
        <p>128개</p>
        <p>(평균 48개)</p>
      </div>
    </div>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_tomato.scss'
import { onMounted } from '@vue/runtime-core';

export default {
  name: 'MypageTomato',

  setup() {
    const options = {
      chart: {
        height: 480,
        type: "radialBar",
      },

      series: [67],
      colors: ["#20E647"],
      plotOptions: {
        radialBar: {
          hollow: {
            margin: 0,
            size: "80%",
          },
          track: {
            dropShadow: {
              enabled: true,
              top: 2,
              left: 0,
              blur: 4,
              opacity: 0.15
            }
          },
          dataLabels: {
            name: {
              offsetY: -10,
              color: "#fff",
              fontSize: "13px"
            },
            value: {
              color: "#fff",
              fontSize: "30px",
              show: true
            }
          }
        }
      },
      fill: {
        type: "gradient",
        gradient: {
          shade: "dark",
          type: "vertical",
          gradientToColors: ["#FF7043"],
          stops: [0, 60]
        }
      },
      stroke: {
        lineCap: "round"
      },
      labels: ["Progress"]
    };
    
    onMounted(() => {
      var chart = new
      ApexCharts(document.querySelector('#chart'), options);
      chart.render()
    })
    return {
      options,
    }
  }
}
</script>

<style>

</style>