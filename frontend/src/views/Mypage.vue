<template>
  <div class="mypage_main">
    <MypageInfo/>
    <MypageTomato/>
    <MypageStudyTime/>
    <MypageStudyList/>
  </div>
</template>

<script>
import MypageInfo from '@/components/Mypage/MypageInfo'
import MypageTomato from '@/components/Mypage/MypageTomato'
import MypageStudyTime from '@/components/Mypage/MypageStudyTime'
import MypageStudyList from '@/components/Mypage/MypageStudyList'
import '@/assets/style/mypage.scss'
import { useStore } from 'vuex'
// import { onMounted } from 'vue'

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

    function check() {
      console.log(store.state.myInfo)
    }

    return {
      check
    }
  }
}
</script>

<style>

</style>