<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">
      <div class="modal_refer_header">
        <p class="modal_font">{{ state.study_data_speci.subject }}</p>
        <p class="modal_refer_font modal_refer_writer">작성자 넣기</p>
        <p class="modal_refer_font">{{ state.study_data_speci.files[0].regTime.split('T')[0] }}</p>
        <hr>
      </div>
      

      <div class="modal_refer_file">
        <p class="modal_font">첨부파일</p>
        <a :href="`${download_url}`" class="modal_refer_font">{{ state.study_data_speci.files[0].orgName}}</a>
        <hr>
      </div>
      

      <div class="modal_refer_content">
        <div class="modal_refer_font">{{ state.study_data_speci.content }}</div>
        <hr>
      </div>
      

      <button @click="$emit('close')" class="modal_refer_close_btn">닫기</button>
    </div>
  </div>
</template>

<script>
import '@/assets/style/DetailStudy/study_modal_refer.scss'
import { useStore } from 'vuex'
import { computed, reactive } from 'vue'

export default {
  name: "StudyModalRefer",

  setup(){
    const store = useStore()

    const state = reactive({
      study_data_speci : computed(() => {
        return store.state.studyDataSpeci
      })
    })

    const server_url = store.state.server_url
    const download_url = server_url + 'file/download/' + state.study_data_speci.files[0].id

    function onClickDownload() {
      store.dispatch('getDownloadFile', state.study_data_speci.files[0].id)
    }

    return {
      state,
      download_url,
      onClickDownload

    }
  }

}
</script>

<style>

</style>