<template>
  <div class="findPassword" v-if="forgotPassword === true">
    <div class="card_wrapper">
      <div class="cancel" @click="onClickCloseBtn">X</div>
      <div class="content_wrapper">
        <p>비밀번호를 잊어버리셨나요 ?</p>
            <!-- 인증번호 전송 email -->
        <input placeholder="이메일을 입력해주세요" type="text" v-model="email_validate" />
        <button @click="onClickSendValidate">임시 비밀번호 전송</button>
        <!-- 인증번호 전송 버튼 -->
      </div>
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

  setup(props, { emit }) {
    const store = useStore()
    const email_validate = ref('')
    
    const onClickCloseBtn = function() {
      // email_validate = ref('')
      emit('closeDialog')
    }

    const onClickSendValidate = function() {
      store.dispatch('sendValidateEmail', {email: email_validate.value})
      .then(function(){
        console.log('되냐아')
        onClickCloseBtn()
      })
      .catch(function (){
        console.log('왜 또 안돼')
      })
    }


    return {
      email_validate,
      onClickSendValidate,
      onClickCloseBtn
    }
  }

}
</script>

<style>

</style>