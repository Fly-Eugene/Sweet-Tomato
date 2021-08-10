<template>
  <section class="mypage_study_time">
    <section class="box_left">
      <header class="mypage_study_header">주간 공부량 비교</header>
      <div class="chart_wrapper">
        <apexchart width="100%" type="line" :options="options" :series="series" :stroke="stroke"></apexchart>
      </div>
    </section>
    <section class="box_right">
      <div class="amount">
        <p>총 공부 시간</p>
        <p>280h 12m</p>
      </div>
      <div class="weekly">
        <div class="when">
          <p>오늘</p>
          <p>이번 주</p>
        </div>
        <div class="time">
          <p>2h 30m</p>
          <p>5h 32m</p>
        </div>
      </div>
    </section>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_study_time.scss'
export default {
  name: 'MypageStudyTime',

  setup() {

    const options = {}

    const series =  [{
      type: 'line',
      data: [12, 24, 35, 62, 72, 89, 20]
    }, {
      type: 'line',
      data: [8, 4, 37, 98, 5, 7, 2]
    }]

    const stroke = {
      curve: 'smooth'
    }

    return {
      options,
      series,
      stroke
    }
  }
}
</script>

<style>

</style>