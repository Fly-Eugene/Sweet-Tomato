<template>
  <div class="findPassword" v-if="forgotPassword === true">
    <div>X</div>
    <div class="content_wrapper">
      <p>비밀번호를 잊어버리셨나요 ?</p>
          <!-- 인증번호 전송 email -->
      <input placeholder="이메일을 입력해주세요" type="text" v-model="email_validate" />
      <button @click="onClickSendValidate">임시 비밀번호 전송</button>
      <!-- 인증번호 전송 버튼 -->
    </div>
  </div>
</template>

<script>
import '@/assets/style/account_password.scss'
import { ref } from 'vue'
import { useStore } from 'vuex'


export default {
  name: "AccountPassword",
  props: {
    forgotPassword : {
      type: Boolean,
      required: true,
    }
  },

  setup() {
    const store = useStore()
    const email_validate = ref('')

    const onClickSendValidate = function() {
      store.dispatch('sendValidateEmail', {email: email_validate.value})
    }

    return {
      email_validate,
      onClickSendValidate
    }
  }

}
</script>

<style>

</style>