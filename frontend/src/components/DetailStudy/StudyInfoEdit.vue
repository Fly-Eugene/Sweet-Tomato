<template>
  <div class="modal-mask">
    <div class="modal-container">
      <div class="close_button" @click="$emit('onClickClose')">X</div>

      <header class="select_open">
        <div v-if="study_security === 'public'" class="select_open_btn_public" @click="onClickSecurity"><i class="fas fa-lock-open fa-2x"></i></div>
        <div v-else class="select_open_btn_private" @click="onClickSecurity"><i class="fas fa-lock fa-2x"></i></div>
      </header>

      <section class="make_study_content">

        <article class="card_left">
          <div v-if="state.profile_image !== ''" :style="`background-image : url(${state.profile_image})`" class="background_photo"></div>
          <img v-else :src="`${study_profile_url}`" class="background_photo">
          <label for="edit_file" class="background_photo_btn">
            <p>스터디 프로필</p>
          </label>
          <input @change="upload" accept="image/*" type="file" id="edit_file" name="study_profile"/>
        </article>

        <article class="card_right">
          <div class="study_name">
            <span>스터디 이름</span>
            <input type="text" v-model="study_name">
          </div>
          <div class="hash_tag">
            <span>해시태그</span>
            <input type="text" placeholder="#어떤 종류의 스터디 인가요? 🔍" v-model="hash_tag" @keyup.enter="onEnter">
          </div>
          <div class="hash_tag_content">
            <div class="hash_tag_item" v-for="hash in hash_tag_list_new" :key="hash">{{ hash }}</div>
          </div>
          <div class="study_content">
            <span>스터디 소개</span>
            <br>
            <textarea cols="30" rows="10" type="text" placeholder="스터디를 멋지게 표현해주세요 👏🏻" v-model="study_content"></textarea>
          </div>
        </article>
      </section>

      <button class="make_study_btn" @click="onClickEditStudy"><p>수정 완료</p></button>
    </div>
  </div>
</template>

<script>
import { useStore } from 'vuex'
import { ref, computed, reactive} from 'vue'
import $axios from 'axios'

export default {
  name: 'StudyInfoEdit',
  props: {
    studyId: {
      type: String,
      required: true,
    }
  },

  setup(props){
    const store = useStore()
    const state = reactive({
      info: computed(() => {
        return store.state.studyInfo
      }),
      profile_image : ''
    })

    const study_security = ref(state.info.security)
    const study_name = ref(state.info.studyName)
    const hash_tag = ref('')
    const hash_tag_list_old = state.info.themes
    const hash_tag_list_new = ref([])

    Array.prototype.push.apply(hash_tag_list_new.value, hash_tag_list_old)

    const study_content = ref(state.info.studyIntro)

    const server_url = store.state.server_url
    const study_profile_url = server_url + 'profile/study?studyId=' + props.studyId

    const onClickSecurity = function() {
      if (study_security.value === 'public') {
        study_security.value = 'private'
      } else {
        study_security.value = 'public'
      }
    }

    function upload(e) {
      const file = e.target.files;
      const url = URL.createObjectURL(file[0])
      state.profile_image = url
    }

    const onEnter = function() {
      hash_tag_list_new.value.push('#' + hash_tag.value)
      hash_tag.value = ''
    }

    // const data = {
    //   studyId: props.studyId,
    //   studyName: study_name.value,
    //   studyIntro: study_content.value,
    //   security: study_security.value,
    //   themes: hash_tag_list_new.value
    // }

    const onClickEditStudy = function(){
      const frm = new FormData()
      const photoFile = document.getElementById("edit_file")
      frm.append('files', photoFile.files[0])
      frm.append('jsonData', JSON.stringify({ studyId: props.studyId, studyName: study_name.value, studyIntro: study_content.value, security: study_security.value, themes: hash_tag_list_new.value }))
      console.log(frm)
      $axios({
        method: 'patch',
        url: server_url + 'study',
        data: frm,
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log({ studyId: props.studyId, studyName: study_name.value, studyIntro: study_content.value, security: study_security.value, themes: hash_tag_list_new.value })
        console.log(err)
      })

      
    }
// store.dispatch('editStudyInfo', frm)

    return {
      state,
      study_profile_url,
      study_security,
      study_name,
      hash_tag,
      hash_tag_list_new,
      study_content,

      onClickSecurity,
      upload,
      onEnter,
      onClickEditStudy,
    }
  }
}
</script>

<style>

</style>