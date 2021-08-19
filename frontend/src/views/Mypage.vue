<template>
  <!-- <div @click="move" v-if="!state.plz">이동하기</div> -->
  <div class="mypage_main" v-if="state.plz">
    <MypageInfo :myStudyList='state.myStudyList'/>
    <MypageTomato :myTomato='state.myTomato'/>
    <MypageStudyTime :myStudyTime='state.myStudyTime'/>
    <MypageStudyList :myStudyList='state.myStudyList'/>
  </div>
</template>

<script>
import MypageInfo from '@/components/Mypage/MypageInfo'
import MypageTomato from '@/components/Mypage/MypageTomato'
import MypageStudyTime from '@/components/Mypage/MypageStudyTime'
import MypageStudyList from '@/components/Mypage/MypageStudyList'
import '@/assets/style/mypage.scss'
import { useStore } from 'vuex'
import { onBeforeMount, onUnmounted, reactive } from 'vue'

export default {
  name: 'Mypage',

  components: {
    MypageInfo,
    MypageTomato,
    MypageStudyTime,
    MypageStudyList
  },

  setup() {
    const store = useStore()
    const state = reactive({
      plz: false,
      myStudyList: store.state.myRecentStudy ? store.state.myRecentStudy : false,
      myStudyTime: store.state.myStudyTime !== null ? store.state.myStudyTime :  [{"studyTimeId": 0, "studyDate": "2021-08-18", "studyTime": 0, "memberId": 0}],
      myTomato: store.state.myTomato !== null ? store.state.myTomato : 0,
    })

    onBeforeMount(() => {
      store.dispatch('checkLogin')
      state.plz = true
    })
    onUnmounted(() => {
      state.plz = false
    })
    return {
      state,
    }
  }
}
</script>

<style>

</style>