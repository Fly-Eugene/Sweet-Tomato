<template>
  <section class="make_study_body">
    <article class="make_study_card">
      <Navbar />
      <section class="make_study_content">
        <header class="select_open">
          <!-- <span>비공개 스터디</span> -->
          <div class="select_open_btn"></div>
        </header>
        <div class="background_photo"></div>
        <button class="background_photo_btn">+ 스터디 프로필</button>
        <article class="card_left">
          <div class="study_name">
            <span>스터디 이름 📚</span>
            <br>
            <input type="text" v-model="study_name">
          </div>
          <div class="hash_tag">
            <span>해시태그 📌</span>
            <br>
            <input type="text" placeholder="#어떤 종류의 스터디 인가요? 🔍" v-model="hash_tag" @keyup.enter="onEnter">
            <!-- key로 할만한거 찾기!! 우선 내용으로 key 대체-->
            <!-- <ul><MakeStudyHashTag v-for="hash in hash_tag_list" :key="hash"/></ul> -->
            <div class="hash_tag_content"><div class="hash_tag_item" v-for="hash in hash_tag_list" :key="hash">{{ hash }}</div></div>
          </div>
        </article>
        <article class="card_right">
          <div class="study_content">
            <span>스터디 소개 🙌🏻</span>
            <textarea cols="30" rows="10" type="text" placeholder="스터디를 멋지게 표현해주세요 👏🏻" v-model="study_content"></textarea>
          </div>
        </article>
        <button class="make_study_btn" @click="onClickMakeStudy">스터디 만들기</button>
      </section>
    </article>
  </section>
</template>

<script>
import '@/assets/style/make_study.scss'
import Navbar from '@/views/Navbar.vue'
// import MakeStudyHashTag from '@/components/MakeStudy/MakeStudyHashTag.vue'
import {ref} from 'vue'
import { useStore } from 'vuex'

export default {
  name: "MakeStudy",
  components: {
    Navbar,
    // MakeStudyHashTag
  },

  setup() {

    const store = useStore()
    
    const study_name = ref('')
    const hash_tag = ref('')
    const hash_tag_list = ref([])
    const study_content = ref('')

    const onEnter = function() {
      hash_tag_list.value.push('#' + hash_tag.value)
      console.log(hash_tag_list.value)
      hash_tag.value = ''
    }

    const onClickMakeStudy = function() {
      store.dispatch('makeStudy', {  })
    }



    return {
      study_name,
      hash_tag,
      hash_tag_list,
      study_content,

      onEnter,
      onClickMakeStudy,

    }
  }

}
</script>

<style>

</style>            