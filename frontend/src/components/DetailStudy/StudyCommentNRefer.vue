<template>
  <section class="comment_refer_section">
    <button class="write_btn" @click="showCreateModal">글쓰기</button>
    <StudyModal :studyId='studyId' @close="closeModal" v-if="showModal === true" />


    <aside class="comment_refer_btn_sub"></aside>
    <aside class="comment_refer_btn">
      <button class="comment_btn" @click="changeToComment">댓글</button>
      <button class="study_data_btn" @click="changeToRefer">자료실</button>
    </aside>
    <StudyComment :studyId='studyId' v-if="comment_or_refer === 'comment'" />
    <StudyReference  v-if="comment_or_refer === 'refer'"/>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_comment_N_refer.scss'
import StudyComment from '@/components/DetailStudy/StudyComment.vue'
import StudyReference from '@/components/DetailStudy/StudyReference.vue'
import StudyModal from '@/components/DetailStudy/StudyModal.vue'

import {ref} from 'vue'

export default {
  name: "StudyCommnentNRefer",

  props: {
    studyId: {
      type: String,
      required: true,
    }
  },


  components: {
    StudyComment,
    StudyReference,
    StudyModal,
  },


  setup() {
    const comment_or_refer = ref('comment')
    const showModal = ref(false)

    function changeToComment() {
      comment_or_refer.value = 'comment'
    }

    function changeToRefer() {
      comment_or_refer.value = 'refer'
    }

    function showCreateModal() {
      showModal.value = true
    }

    function closeModal() {
      showModal.value = false
    }


    return {
      showModal,
      comment_or_refer,
      changeToComment,
      changeToRefer,
      showCreateModal,
      closeModal

    }

  }

}
</script>

<style>

</style>