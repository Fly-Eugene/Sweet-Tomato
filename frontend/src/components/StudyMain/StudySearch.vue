<template>
  <section class="study_search">
    <img src="@/assets/img/study_find.svg" alt="">
    <span>원하는 스터디를 찾아주세요</span>
    <div class="hashtag_input">
      <input type="text" placeholder="해시태그를 입력해주세요">
      <i class="fas fa-search"></i>
    </div>
    <div class="hashtags">
      <ul>
        <li>파이썬</li>
        <li>코딩</li>
        <li>모각코</li>
      </ul>
    </div>
  </section>
</template>

<script>
import '@/assets/style/StudyMain/study_main_search.scss'
export default {
  name: 'StudySearch'
}
</script>

<style>
</style>