<template>
  <div class="mypage_main">
    <MypageInfo/>
    <MypageTomato/>
    <MypageStudyTime/>
  </div>
</template>

<script>
import MypageInfo from '@/components/Mypage/MypageInfo'
import MypageTomato from '@/components/Mypage/MypageTomato'
import MypageStudyTime from '@/components/Mypage/MypageStudyTime'
import '@/assets/style/mypage.scss'
export default {
  name: 'Mypage',

  components: {
    MypageInfo,
    MypageTomato,
    MypageStudyTime
  }
}
</script>

<style>

</style>