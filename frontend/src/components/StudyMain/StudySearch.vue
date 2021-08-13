<template>
  <section class="study_search">
    <img src="@/assets/img/study_find.svg" alt="">
    <span>원하는 스터디를 찾아주세요</span>
    <div class="hashtag_input">
      <input type="text" placeholder="해시태그를 입력해주세요" v-model="study_hash" @keyup.enter='searchStudy'>
      <i class="fas fa-search"></i>
    </div>
    <div class="hashtags">
      <div class="study_hash_tag" v-for="hash in study_hash_list" :key="hash">{{ hash }}</div>
    </div>
    
  </section>
</template>

<script>
import '@/assets/style/StudyMain/study_main_search.scss'
import { reactive, ref } from 'vue'
import { useStore } from 'vuex'
export default {
  name: 'StudySearch',

  setup() {
    const store = useStore()
    const state = reactive({
      find_hash: []
    })
    const study_hash = ref('')
    const study_hash_list = ref([])

    const searchStudy = function() {
      study_hash_list.value.push('#' + study_hash.value)
      state.find_hash.push(study_hash.value)
      study_hash.value = ''
      store.dispatch('searchStudy', {themes: study_hash_list.value, page: 1})
    }
    return {
      store,
      state,
      study_hash,
      study_hash_list,
      searchStudy,
    }
  }
}
</script>

<style>
</style>