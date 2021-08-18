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
      myStudyList: store.state.myRecentStudy,
      myStudyTime: store.state.myStudyTime,
      myTomato: store.state.myTomato,
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