<template>
  <section class="comment_section">
    <aside class="comment_refer_btn_sub"></aside>
    <aside class="comment_refer_btn">스터디 자료실 선택</aside>
    <article class="comment_content_sub"></article>
    <article class="comment_content"> 
      <li v-for="comment in state.comments" :key="comment.id" class="comment_box">{{ comment.content }}</li>
    </article>

    <input v-model="input_value" @keyup.enter="createComment" type="text" class="comment_input" placeholder="스터디에 대한 의견을 남겨주세요">
    <button @click="createComment" class="enter_btn">연필모양</button>
  </section>
</template>

<script>
import '@/assets/style/DetailStudy/study_comment.scss'
import { useStore } from 'vuex'
import { ref, reactive, computed } from 'vue'

export default {
  name: 'StudyComment',
  props: {
    studyId: {
      type: String,
      required: true,
    }
  },

  setup(props){
    const store = useStore()
    const input_value = ref('')
    const state = reactive({
      comments : computed(() => {
      return store.state.studyComments
      })
    })

    function createComment() {
      store.dispatch('createComment', [props.studyId, input_value.value])
      input_value.value = ''
    }

    return {
      state,
      input_value,
      createComment
    }
  }

}
</script>

<style>

</style>