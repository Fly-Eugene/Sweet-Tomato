<template>
  <section class="profile_body">
    <section class="profile_card">        
      <header>
        <h2>프로필</h2>
        <button>만들기</button>
      </header>
      <nav>
        <div class="nav_btn_wrapper">            
          <button class="home_btn" href="#none">H</button>
          <button class="search_btn" href="#none">S</button>
          <button class="profile_btn" href="#none">P</button>
        </div>
      </nav>
      <section class="card_left">
        <article class="card_left_top">
          <div class="profile_left">
            <div class="profile_content">                
              <div class="profile_img_wrapper">
                <img src="@/assets/img/basic_profile.png" alt="">
              </div>
              <div class="profile_welcome">
                <h2>어서오세요!</h2>
                <h2>근일 님!</h2>
              </div>
            </div>
            <button class="edit_btn">Edit</button>
          </div>
          <div class="profile_rigth">
            <div class="profile_email">
              <h3>Email</h3>
              <span>유저가 입력한 이메일</span>
            </div>
            <div class="Group">
              <h3>Group</h3>
              <span>유저가 입력한 그룹</span>
            </div>
          </div>
        </article>
        <section class="card_left_bottom">
          <article class="btn_wrapper">
            <button class="tomato_btn" href="#none">T</button>
            <button class="time_btn" href="#none">C</button>
          </article>
          <article class="card_content">
            <div class="tomato">
              <div class="tomato_left">
              </div>                
              <div class="tomato_right">
              </div>    
            </div>
            <div class="clock">
              <div class="clock_top">
              </div>
              <div class="clock_bottom">
              </div>
            </div>         
          </article>
        </section>
      </section>
      <section class="card_right">          
        <article class="card_right_top">
          <h3>최근 접속</h3>
          <p>유저 최근 접속 스터디</p>
          <button>접속하기</button>
        </article>
        <article class="card_right_bottom">
          <div class="studies_table">
            <h3>My Studys</h3>
          </div>
        </article>
      </section>
    </section>
  </section>
</template>

<script>
import '@/assets/style/account_profile.scss'

export default { 
  name: "Profile",
  
}
</script>

<style>

</style>