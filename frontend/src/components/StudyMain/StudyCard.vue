<template>
  <section class="card">
    <section class="card_wrapper">
      <i class="far fa-heart"></i>
      <div class="card_name">
        <!-- <p>{{ props.study.id }}</p> -->
        <p>최근 스터디 일자: 2021년 07월 28일</p>
      </div>
      <div class="card_hashtag">
        <ul>
          <li># 파이썬</li>
          <li># 코딩</li>
          <li># 모각코</li>
        </ul>
      </div>
      <div class="card_img">
        <img src="@/assets/img/basic_profile.png" alt="">
      </div>
      <div class="card_footer">
        <div>          
          <img src="@/assets/img/tomato1.svg" alt="">
          <span>X 200</span>
        </div>
        <div>
          더보기
        </div>
      </div>
    </section>
  </section>
</template>

<script>
import '@/assets/style/StudyMain/study_card.scss'
import { onMounted } from '@vue/runtime-core'
export default { 
  name: 'StudyCard',
  props: {
    study: Object
  },
  setup() {
    onMounted(() => {
      console.log(this.study)
    })
  }
}
</script>

<style>

</style>