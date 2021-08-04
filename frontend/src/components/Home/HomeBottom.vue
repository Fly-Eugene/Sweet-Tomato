<template>
  <div class="bottom_wrapper">
    <div class="box_top">
      <div class="card" @mouseover="state.card_1 = true" @mouseleave="state.card_1 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/alarm_black_24dp.svg" alt="">
            <p>뽀모도로</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/alarm_white_24dp.svg" alt="">
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
            <img id="block" src="@/assets/img/calender_black.svg" alt="">
            <p>캘린더</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/calender_white.svg" alt="">
            <p>캘린더</p>
          </div>
        </div>
      </div>
      <div class="card" @mouseover="state.card_4 = true" @mouseleave="state.card_4 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/help_black.svg" alt="">
            <p>질문하기</p>
          </div>
        </div>
        <div class="card_inner_white">
          <div class="content">            
            <img id="white" src="@/assets/img/help_white.svg" alt="">
            <p>질문하기</p>
          </div>
        </div>
      </div>
      <div class="card" @mouseover="state.card_5 = true" @mouseleave="state.card_5 = false">
        <div class="card_inner_black">
          <div class="content">            
            <img id="block" src="@/assets/img/lock_black.svg" alt="">
            <p>강퇴하기</p>
          </div>
        </div>
        <div class="card_inner_white" @click="test">
          <div class="content">            
            <img id="white" src="@/assets/img/lock_white.svg" alt="">
            <p>강퇴하기</p>
          </div>
        </div>
      </div>
    </div>
    <div class="box_bottom">
      <div class="box_wrapper" v-show="state.card_1">
        <div class="box_left">
          <div class="box_inner">
            <img src="@/assets/img/HomeMiddle.png" alt="">
          </div>
        </div>
        <div class="box_right">
          <div>
            <p>뽀모도로</p>
            <p class="bottom_line"></p>
            <span>테스트 테스트 1</span>
            <span>테스트 테스트 1</span>
          </div>
        </div>
      </div>
      <div class="box_wrapper" v-show="state.card_2">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/HomeMiddle.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>타이머</p>
              <p class="bottom_line"></p>
              <span>테스트 테스트 22</span>
              <span>테스트 테스트 22</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_3">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/HomeMiddle.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>캘린더</p>
              <p class="bottom_line"></p>
              <span>스터디원과 함께 같은 목표를 설정 할 수 있습니다.</span>
              <span>오늘의 목표는 물론 D-DAY까지 함께하세요.</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_4">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/HomeMiddle.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>질문하기</p>
              <p class="bottom_line"></p>
              <span>질문질문</span>
              <span>질문!</span>
            </div>
          </div>
      </div>
      <div class="box_wrapper" v-show="state.card_5">
          <div class="box_left">
            <div class="box_inner">
              <img src="@/assets/img/HomeMiddle.png" alt="">
            </div>
          </div>
          <div class="box_right">
            <div>
              <p>강퇴</p>
              <p class="bottom_line"></p>
              <span>강퇴 강퇴</span>
              <span>강퇴 !</span>
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