<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">

      <div class="study_modal_header">
        <p class="modal_title" >제목</p>
        <input type="text" class="modal_title_input" v-model="data_subject">
      </div>

      <!-- 기본 파일 유지 어떻게 하지?? -->
      <div class="study_modal_file">
        <p class="modal_file">첨부파일</p>
        <input type="file" class="modal_file_input" id="file">
      </div>

      <div class="study_modal_content">
        <p class="modal_content">내용</p>
        <textarea name="" id="" cols="30" rows="10" class="modal_content_input" v-model="data_content" ></textarea>
      </div>

      <button @click="onSubmitData" class="modal_refer_edit_btn">수정</button>
      <button @click="$emit('editClose')" class="modal_refer_close_btn">닫기</button>
    </div>
  </div>
</template>

<script>
import { computed, reactive, ref } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'
import $axios from 'axios'


export default {
  name: 'StudyReferenceEdit',

  setup(props, {emit}){
    const store = useStore()
    const router = useRouter()
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

      if (studyData.files.length !== 0) {
        frm.append('files', studyData.files[0])
      } 
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
        emit('editClose')
        router.go()
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