<template>
  <section class="mypage_tomato">
    <header class="mypage_tomato_header">내 토마토</header>
    <div id="chart"></div>
    <div class="tomato">
      <img src="@/assets/img/tomato1.svg" alt="">
      <div class="tomato_cnt">
        <p>{{ state.myTomato }} 개</p>
        <p>(전체 {{ state.everyTomato }}개)</p>
      </div>
    </div>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_tomato.scss'
import { onMounted, reactive, computed } from '@vue/runtime-core';
import { useStore } from 'vuex';

export default {
  name: 'MypageTomato',
  props: {
    myTomato: Number
  },
  setup() {
    const store = useStore()
    const state = reactive({
      myTomato: computed(() => {
        return store.state.myTomato
      }),
      everyTomato: computed(() => {
        return store.state.everyTomato
      })
    })
    const options = {
      chart: {
        height: 480,
        type: "radialBar",
      },

      series: [(state.myTomato/state.everyTomato) * 100],
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
      state,
      options,
    }
  }
}
</script>

<style>

</style>