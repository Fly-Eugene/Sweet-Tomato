<template>
  <div class="login_right_content">
    <h2>Find Password</h2>
    <span>
      Check your time with a Tomato.
      <br>
      It makes you to spend a time more effeciently.
    </span>
    <form>
      <!-- 인증번호 전송 email -->
      <div>
        <input placeholder="Email을 입력해주세요" type="text" v-model="email" />
      </div>
      <!-- 인증번호 전송 버튼 -->
      <button @click="onClickSendValidate" id="loginbtn"> <p>인증번호 전송</p> </button>

    </form>
  </div>

</template>

<script>
import '../assets/style/login.scss'
import { ref } from 'vue'
import { useStore } from 'vuex'


export default {
  name: "AccountPassword",

  setup() {
    const store = useStore()
    const email = ref('')
    const validateNumber = ref('')

    const onClickSendValidate = function() {
      store.dispatch('sendValidateEmail', {email: email})
    }


    return {
      email,
      validateNumber,

      onClickSendValidate
    }
  }




}
</script>

<style>

</style>