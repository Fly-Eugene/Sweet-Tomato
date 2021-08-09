<template>
  <section class='mypage_info'>
    <article class='mypage_left'>
      <div class='recent_access'>
        <p>최근 접속</p>
        <p>2021.08.05. 16:13</p>
      </div>
      <div class="studyname">
        <p>와르르 CS 스터디</p>
      </div>
      <div class="enterBtn">
        <p>입장하기</p>
      </div>
    </article>
    <article class='mypage_right'>
      <i class="fas fa-cog"></i>
      <div class="right_top">
        <div class="profile_img">
          <img src="@/assets/img/basic_profile.png" alt="">
        </div>
        <div class="profile_welcome">
          <p>어서오세요</p>
          <p>줄리아 님</p>
        </div>
      </div>
      <div class="right_bottom">
        <div class="email">
          <span>Email</span>
          <span>rmsdlf94@naver.com</span>
        </div>
        <div class="group">
          <span>Group</span>
          <span>SSAFY</span>
        </div>
      </div>
    </article>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_info.scss'
export default {
  name: 'MypageInfo'
}
</script>

<style>

</style>