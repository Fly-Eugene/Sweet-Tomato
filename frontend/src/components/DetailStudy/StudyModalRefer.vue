<template>
  <div class="study_modal_mask">
    <div class="study_modal_container">
      <div class="modal_refer_header">
        <p id="refer_title">{{ state.study_data_speci.subject }}</p>
        <p id="refer_writer">{{ state.study_data_speci.member['username']}}</p>
        <p v-if="state.study_data_speci.files[0]" id="refer_time">{{ state.study_data_speci.files[0].regTime.split('T')[0] }}</p>
        <p v-else id="refer_time"></p>
      </div>
      

      <div class="modal_refer_file">
        <hr>
        <p id="refer_file">첨부파일</p>
        <a v-if="state.study_data_speci.files[0]" :href="`${download_url}`" id="refer_file_name">{{ state.study_data_speci.files[0].orgName}}</a>
        <a v-else id="refer_file_name">파일이 존재하지 않습니다.</a>      
      </div>
      

      <div class="modal_refer_content">
        <hr>
        <div id="refer_content">{{ state.study_data_speci.content }}</div>
      </div>
      
      <button @click="$emit('clickEdit')" class="modal_refer_edit_btn">수정</button>
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
    let download_url
    
    if (state.study_data_speci.files[0]) {
      download_url = server_url + 'file/download/' + state.study_data_speci.files[0].id
    }
    
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