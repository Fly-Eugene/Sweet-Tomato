<template>
  <section class="study_main_body">
    <section class="study_main_card">
      <header>
        <h2>스터디 찾기</h2>
        <button>만들기</button>
      </header>
      <nav>
        <div class="nav_btn_wrapper">
          <button class="home_btn" href="#none">H</button>
          <button class="search_btn" href="#none">S</button>
          <button class="profile_btn" href="#none">P</button>
        </div>
      </nav>    
      <section class="input_wrapper">
        <form class="serach_form" action="">
          <div>
            <input type="text" placeholder="원하는 스터디를 찾아보세요.">
          </div>
        </form>
        <button>검색</button>
      </section>
      <section class="hashtags">
        <div class="hashtag">
          <p># 코딩</p>
          <a href="#none">X</a>
        </div>
      </section>
      <section class="study_cards">
        <div class="card_wrapper">
          <div class="card">

          </div>
        </div>

        <footer class="pagination">
          <span>이전</span>
          <span>1</span>
          <span>2</span>
          <span>3</span>
          <span>이후</span>
        </footer>
      </section>
    </section>
  </section>
</template>

<script>

import '../assets/style/study_main.scss'

export default {
  name: "StudyMain",
  
}
</script>

<style>

</style>