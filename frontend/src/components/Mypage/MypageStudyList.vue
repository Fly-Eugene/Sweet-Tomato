<template>
  <section class="mypage_study_list">
    <div class="list_box">
      <header>내 스터디</header>
      <div class="list_wrapper" v-if="myStudyList.length != 0">
        <div class="first_study" @click="this.$router.push({name: 'DetailStudy', params: { id: this.myStudyList[0].study.id }})">
          <p>{{ this.myStudyList[0].study.studyName }}</p>
          <p>({{ this.myStudyList[0].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
        <div v-if="this.myStudyList.length >= 2" class="second_study" @click="this.$router.push({name: 'DetailStudy', params: { id: this.myStudyList[1].study.id }})">
          <p>{{ this.myStudyList[1].study.studyName }}</p>
          <p>({{ this.myStudyList[1].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
        <div v-if="this.myStudyList.length >= 3" class="third_study" @click="this.$router.push({name: 'DetailStudy', params: { id: this.myStudyList[2].study.id }})">
          <p>{{ this.myStudyList[2].study.studyName }}</p>
          <p>({{ this.myStudyList[2].recentlyConnectionTime.slice(11, 16) }})</p>
        </div>
      </div>  
    </div>
  </section>
</template>

<script>
import '@/assets/style/Mypage/mypage_study_list.scss'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: 'MypageStudyList',

  props: {
    myStudyList: Object  
  },

  setup() {
    const store = useStore()
    const state = reactive({
      recentStudies: computed(() => {
        return store.state.myRecentStudy
      })
    })

    // onMounted(() => {      
    //   console.log(store.state.myRecentStudy)
    // })
    return {
      state,
    }
  }
}
</script>

<style>

</style>