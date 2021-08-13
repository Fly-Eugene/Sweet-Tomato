<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">
      <p class="modal_font" >제목</p>
      <input type="text" class="modal_header_input" v-model="data_subject">

      <!-- 기본 파일 유지 어떻게 하지?? -->
      <p class="modal_font">첨부파일</p>
      <input type="file" class="modal_file_input" id="file">

      <p class="modal_font">내용</p>
      <textarea name="" id="" cols="30" rows="10" class="modal_content_input" v-model="data_content" ></textarea>

      <button @click="onSubmitData" class="modal_refer_edit_btn">수정 버튼</button>
      <button @click="$emit('close')" class="modal_refer_close_btn">닫기</button>
    </div>
  </div>
</template>

<script>
import { computed, reactive, ref } from 'vue'
import { useStore } from 'vuex'
import $axios from 'axios'


export default {
  name: 'StudyReferenceEdit',

  setup(){
    const store = useStore()
    const state = reactive({
      study_data_speci : computed(() => {
        return store.state.studyDataSpeci
      })
    })

    const data_subject = ref(state.study_data_speci.subject)
    const data_content = ref(state.study_data_speci.content)

    const onSubmitData = function(){
      const frm = new FormData()
      const studyData = document.getElementById("file")

      frm.append('files', studyData.files[0])
      frm.append('jsonData', JSON.stringify({ id: state.study_data_speci.id ,subject: data_subject.value, content: data_content.value, studyId: state.study_data_speci.studyId }))
      $axios({
        method: 'patch',
        url: store.state.server_url + 'dataroom',
        data: frm,
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then(res => {
        console.log(res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }



    return {
      state,
      data_subject,
      data_content,

      onSubmitData
    }
  }

}
</script>

<style>

</style>