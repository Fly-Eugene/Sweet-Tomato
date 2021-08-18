<template>
  <section class="study_search">
    <img src="@/assets/img/study_find.svg" alt="">
    <p>원하는 스터디를 찾아주세요</p>
    <div class="hashtag_input">
      <input type="text" placeholder="해시태그를 입력해주세요" v-model="study_hash" @keyup.enter='searchStudy'>
      <i class="fas fa-search"></i>
    </div>
    <div class="hashtags">
      <span class="study_hash_tag"  @click="deleteHash(hash)" v-for="hash in state.find_hash" :key="hash">
        <span v-if="hash" class="tag">{{ hash }}</span>
      </span>
    </div>
  </section>
</template>

<script>
import '@/assets/style/StudyMain/study_main_search.scss'
import { reactive, ref } from 'vue'
import { useStore } from 'vuex'
export default {
  name: 'StudySearch',

  setup(props, { emit }) {
    const store = useStore()
    const state = reactive({
      find_hash: []

    })
    const study_hash = ref('')
    const study_hash_list = ref([])

    const searchStudy = function() {
      study_hash_list.value.push('#' + study_hash.value)
      state.find_hash.push('#' + study_hash.value)
      study_hash.value = ''
      emit('studySearch', study_hash_list.value)
    }
    function deleteHash(hash) {
      
      for (var i = 0; i < state.find_hash.length; i++) {
        if (state.find_hash[i] === hash) {
          state.find_hash.splice(i, 1)
          study_hash_list.value.splice(i, 1)
          break
        }
      }
      emit('studySearch', study_hash_list.value)
    }
    return {
      store,
      state,
      deleteHash,
      study_hash,
      study_hash_list,
      searchStudy,
    }
  }
}
</script>

<style>
</style>