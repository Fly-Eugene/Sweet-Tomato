<template>
  <div class="timer_box">
    <div class="timer_header">
      <span>타이머</span>
      <span @click="$emit('closeBtn')">X</span>
    </div>
    <div class="timer_content">
      <div class="timer" v-show="state.timerOn" >
        <span> {{ state.timer_hour }}  |  {{ state.timer_minute }}  |  {{ state.timer_second }}</span>
      </div>
      <div v-show="!state.timerOn">        
        <div class="timer_set">
          <input type="number" v-model="state.hours">
          <span>시</span>
          <input type="number" v-model="state.minutes">
          <span>분</span>
          <input type="number" v-model="state.seconds">
          <span>초</span>
        </div>
      </div>
      <div class="timerBtn">
        <div class="pauseBtn">
          <span @click="endTimer()">취소</span>
        </div>
        <div class="operationBtn">
          <span v-if="state.timerOn && !state.pause" @click="stopTimer()">정지</span>
          <span v-else-if="state.timerOn && state.pause" @click="restartTimer()">재개</span>
          <span v-else @click="startTimer()">시작</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import TimerOn from '@/components/Room/Timer/TimerOn'
import '@/assets/style/Room/timer.scss'
import { computed, reactive } from '@vue/runtime-core';
export default {
  name: 'Timer',

  components: {
    // TimerOn
  },

  setup() {
    
    function padTime(time) {
      return (time < 10 ? '0' : '') + time;
    }

    const state = reactive({
      timerOn: false,
      pause: false,
      hours: 0,
      minutes: 0,
      seconds: 0,
      totalTime: 0,
      timer_hour: computed(() => {
        return padTime(state.totalTime >= 3600 ? Math.floor(state.totalTime / 3600) : 0)
      }),
      timer_minute: computed(() => {
        return padTime(state.totalTime >= 60 ? Math.floor((state.totalTime - (state.timer_hour * 3600)) / 60) : 0)
      }),
      timer_second: computed(() => {
        return padTime(state.totalTime - (state.timer_hour * 60 * 60) - (state.timer_minute * 60))
      }),
      timer: null,
      })
    function startTimer() {
      state.timerOn = true;
      state.totalTime = (state.hours * 60 * 60) + (state.minutes * 60) + (state.seconds)
      // state.bunmo = (state.hours * 60 * 60) + (state.minutes * 60) + (state.seconds)
      state.timer = setInterval(() => this.countdown(), 1000);
    }
    function stopTimer() {
      clearInterval(state.timer)
      state.timer = null,
      state.pause = true;
    }
    function restartTimer() {
      state.timer = setInterval(() => this.countdown(), 1000);
      state.pause = false;
    }
    function endTimer() {
      clearInterval(state.timer);
      state.timer = null;
      state.totalTime = 0;
      state.hours = 0
      state.minutes = 0
      state.seconds = 0
      state.timerOn = false;
    }
    function countdown() {
      if(state.totalTime >= 1) {        
        state.totalTime--;
      } else {
        this.endTimer()
        alert('시간 종료')
      }
    }

    const today = new Date();
    const now_hour = today.getHours() > 13 ? today.getHours() - 12 : today.getHours();
    const now_minute = today.getMinutes();
    const now_second = today.getSeconds();
    const end_time = (now_hour * 60 * 60) + (now_minute * 60) + now_second + state.totalTime
    const end_hour = end_time >= 3600 ? Math.floor(end_time / 3600) : 0
    const end_minute =  end_time >= 60 ? Math.floor((end_time - (end_hour * 3600)) / 60) : 0
    const end_second = end_time - (end_hour * 60 * 60) - (end_minute * 60)
    
    return {
      state,
      startTimer,
      stopTimer,
      restartTimer,
      endTimer,
      countdown,
      padTime,
      now_hour,
      end_time,
      end_hour,
      end_minute,
      end_second,
    }
  },
}
</script>

<style>

</style>