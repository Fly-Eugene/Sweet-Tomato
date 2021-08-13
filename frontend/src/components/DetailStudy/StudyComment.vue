<template>
  <article class="comment_content_sub"></article>
  <article class="comment_content"> 
    <div v-for="comment in state.comments" :key="comment.id" >
      <li :class="[{comment_box_me : state.myInfo.id == comment.memberId}, {comment_box: state.myInfo.id != comment.memberId} ]">{{ comment.content }}</li>
    </div>
  </article>

  <input v-model="input_value" @keyup.enter="createComment" type="text" class="comment_input" placeholder="스터디에 대한 의견을 남겨주세요">
  <button @click="createComment" class="enter_btn"><img style="width: 40px; height:40px" src="@/assets/img/pencil.png" alt=""></button>
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
      }),
      myInfo: computed(() => {
        console.log(store.state.myInfo)
        return store.state.myInfo;
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