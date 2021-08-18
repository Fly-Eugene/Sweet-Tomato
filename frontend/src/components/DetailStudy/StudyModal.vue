<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">

      <div class="study_modal_header">
        <p class="modal_title" >제목</p>
        <input type="text" class="modal_title_input" v-model="data_subject">
      </div>

      <div class="study_modal_file">
        <p class="modal_file">첨부파일</p>
        <input type="file" class="modal_file_input" id="file">
      </div>

      <div class="study_modal_content">
        <p class="modal_content">내용</p>
        <textarea name="" id="" cols="30" rows="10" class="modal_content_input" v-model="data_content" ></textarea>
      </div>


      <button class="cancle_btn" @click="$emit('close')">취소</button>
      <button class="save_btn" @click="onSubmitData">저장</button>

    </div>
  </div>
</template>

<script>
import '@/assets/style/DetailStudy/study_modal.scss'
import $axios from 'axios'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'
import {ref} from 'vue'

export default {
  name: "StudyModal",

  props: {
    studyId: {
      type: String,
      required: true,
    }
  },

  setup(props, {emit}) {

    const store = useStore()
    const router = useRouter()
    const server_url = store.state.server_url

    const data_subject = ref('')
    const data_content = ref('')

    const onSubmitData = function() {
      const frm = new FormData()
      const studyData = document.getElementById("file")
  
      frm.append('files', studyData.files[0])
      frm.append('jsonData', JSON.stringify({ subject: data_subject.value, content: data_content.value, studyId: props.studyId }))
      $axios({
        method: 'post',
        url: server_url + 'dataroom',
        data : frm,
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(() => {
        emit('close')
        router.go()
      })
      .catch(err => {
        console.log(err)
      })
    }

  return {
    data_subject,
    data_content,
    onSubmitData
  }



  }
  
}
</script>

<style>

</style>