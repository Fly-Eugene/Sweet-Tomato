<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">
      <p class="modal_font" >제목</p>
      <div>{{ state.study_data_speci.subject }}</div>

      <p class="modal_font">첨부파일</p>
      <div>{{ state.study_data_speci.files[0].orgName}}</div>
      <button @click="onClickDownload">다운로드</button>

      <p class="modal_font">내용</p>
      <div>{{ state.study_data_speci.content }}</div>

      <button @click="$emit('close')">닫기</button>
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

    function onClickDownload() {
      store.dispatch('getDownloadFile', state.study_data_speci.files[0].id)
    }

    return {
      state,
      onClickDownload

    }
  }

}
</script>

<style>

</style>