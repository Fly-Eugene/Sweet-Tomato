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
export default {
  name: 'Mypage',

  components: {
    MypageInfo,
    MypageTomato,
    MypageStudyTime,
    MypageStudyList
  }
}
</script>

<style>

</style>