<template>
  <section class="make_study_body">
    <article class="make_study_card">
      <Navbar />
      <section class="make_study_content">
        <header class="select_open">
          <div v-if="state.study_security === 'public'" class="select_open_btn_public" @click="onClickSecurity">공개</div>
          <div v-else class="select_open_btn_private" @click="onClickSecurity">비공개</div>
        </header>
        <div v-if="state.profile_image === ''" class="background_photo"></div>
        <div v-else class="background_photo" :style="`background-image : url(${state.profile_image})`"></div>
        <input @change="upload" accept="image/*" type="file" class="background_photo_btn" id="file" name="study_profile">
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
import {reactive, ref} from 'vue'
// import { useStore } from 'vuex'
import $axios from 'axios'

export default {
  name: "MakeStudy",
  components: {
    Navbar,
  },

  setup() {

    // const store = useStore()
    const state = reactive({
      selectedFile: null,
      profile_image: '',
      study_security: 'public'
    })
    
    const study_name = ref('')
    const hash_tag = ref('')
    const hash_tag_list = ref([])
    const study_content = ref('')

    function upload(e) {
      const file = e.target.files;
      state.selectedFile = file[0]
      console.log(file[0])
      const url = URL.createObjectURL(file[0])
      console.log(url);
      state.profile_image = url
    }

    const onEnter = function() {
      hash_tag_list.value.push('#' + hash_tag.value)
      hash_tag.value = ''
    }

    const onClickMakeStudy = function() {
      const frm = new FormData()
      const photoFile = document.getElementById("file")
      frm.append("files", photoFile.files[0])
      frm.append("jsonData", JSON.stringify({ studyName: study_name.value, studyIntro : study_content.value, secutiry: state.study_security, themes: hash_tag_list.value}))
      $axios.post("https://localhost:5000/study", frm, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(res => {
        console.log(res)
      })
      .catch( err => {
        console.log(err)
      })
    
    }

    const onClickSecurity = function() {
      console.log('함수 실행 중')
      if (state.study_security === 'public') {
        state.study_security = 'private'
      } else {
        state.study_security = 'public'
      }
    }



    return {
      state,
      study_name,
      hash_tag,
      hash_tag_list,
      study_content,

      upload,
      onEnter,
      onClickMakeStudy,
      onClickSecurity,

    }
  }

}
</script>

<style>

</style>            