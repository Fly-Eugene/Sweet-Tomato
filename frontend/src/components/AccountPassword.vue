<template>
  <div class="findPassword" v-if="forgotPassword === true">
    <div><h3>Did you forget the Password?</h3></div>
    <!-- 인증번호 전송 email -->
    <div>
      <input placeholder="Email을 입력해주세요" type="text" v-model="email_validate" />
    </div>
    <!-- 인증번호 전송 버튼 -->
    <div><button @click="onClickSendValidate"> <p>인증번호 전송</p> </button></div>
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