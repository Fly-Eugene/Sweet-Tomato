<template>
  <section class="comment_section">
    <aside class="comment_refer_btn_sub"></aside>
    <aside class="comment_refer_btn">스터디 자료실 선택</aside>
    <article class="comment_content_sub"></article>
    <article class="comment_content"> 
      <input v-model="input_value" @keyup.enter="createComment" type="text" class="comment_input" placeholder="스터디에 대한 의견을 남겨주세요">
      <button @click="createComment" class="enter_btn">연필모양</button>

    </article>

  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_comment.scss'
import { useStore } from 'vuex'
import { ref } from 'vue'

export default {
  name: 'StudyComment',
  props: {
    // studyId: {
    //   type: String,
    //   required: true,
    // }
  },

  setup(props){
    const store = useStore()
    const input_value = ref('')

    console.log(store.state.server_url)

    function createComment() {
      store.dispatch('createComment', props.studyId, input_value.value)
    }



    return {
      input_value,
      createComment
    }
  }

}
</script>

<style>

</style>