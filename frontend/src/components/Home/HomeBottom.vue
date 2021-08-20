<template>
  <div class="bottom_wrapper">
    <div class="box_top">
      <div class="card" @mouseover="state.card_1 = true" @mouseleave="state.card_1 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/tBtnblack1.png" alt="">
            <p>뽀모도로</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/tBtnwhite1.png" alt="">
            <p>뽀모도로</p>
          </div>
        </div>
      </div>
      <div class="card" @mouseover="state.card_2 = true" @mouseleave="state.card_2 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/alarm_black_24dp.svg" alt="">
            <p>타이머</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/alarm_white_24dp.svg" alt="">
            <p>타이머</p>
          </div>
        </div>
      </div>
      <div class="card" @mouseover="state.card_3 = true" @mouseleave="state.card_3 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/search_black.png" alt="">
            <p>스터디찾기</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/search_white.png" alt="">
            <p>스터디 찾기</p>
          </div>
        </div>
      </div>
      <div class="card" @mouseover="state.card_4 = true" @mouseleave="state.card_4 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/detail_black.png" alt="">
            <p>상세페이지</p>
          </div>
        </div>
        <div class="card_inner_white" @click="test">
          <div class="content">            
            <img id="white" src="@/assets/img/detail_white.png" alt="">
            <p>상세페이지</p>
          </div>
        </div>
      </div>

      <div class="card" @mouseover="state.card_5 = true" @mouseleave="state.card_5 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/mypage_black.png" alt="">
            <p>마이페이지</p>
          </div>
        </div>
        <div class="card_inner_white" @click="test">
          <div class="content">            
            <img id="white" src="@/assets/img/mypage_white.png" alt="">
            <p>마이페이지</p>
          </div>
        </div>
      </div>
    </div>

    
    <div class="box_bottom">
      <div class="box_wrapper" v-show="state.card_1">
        <div class="box_left">
          <div class="box_inner">
            <img src="@/assets/img/main_pomodoro.png" alt="">
          </div>
        </div>
        <div class="box_right">
          <div>
            <p>뽀모도로</p>
            <p class="bottom_line"></p>
            <span>뽀모도로 공부법으로 스터디 진행</span>
            <span>공부한 시간만큼 토마토가 생성됩니다.</span>
          </div>
        </div>
      </div>
      <div class="box_wrapper" v-show="state.card_2">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/main_timer.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>타이머</p>
              <p class="bottom_line"></p>
              <span>화상채팅방에서 사용할 수 있는 타이머 기능</span>
              <span>사이트를 이용하면서 따로 타이머를 켜지 않아도 됩니다.</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_3">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/main_study.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>스터디찾기</p>
              <p class="bottom_line"></p>
              <span></span>
              <span>원하는 테마를 검색하여 스터디를 찾아보세요</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_4">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/main_detail.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>상세페이지</p>
              <p class="bottom_line"></p>
              <span>스터디별 토마토 현황을 그래프로 한 눈에 파악할 수 있습니다.</span>
              <span>댓글과 자료실을 통해 스터디원들과 커뮤니케이션도 가능합니다.</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_5">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/main_mypage.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>마이페이지</p>
              <p class="bottom_line"></p>
              <span>그래프와 토마토 갯수를 통해 공부 시간을 비교해보세요</span>
              <span>가장 최근 접속한 스터디도 바로 방문할 수 있습니다.</span>
            </div>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import '@/assets/style/Home/HomeBottom.scss'
import { reactive } from '@vue/reactivity'

export default {
  name: 'HomeBottom',

  setup() {
    const state = reactive({
      card_1: false,
      card_2: false,
      card_3: false,
      card_4: false,
      card_5: false
    })
    function test() {
      console.log(state.card_5)
    } 
    return {
      state,
      test
    }
  }
}
</script>

<style>

</style>