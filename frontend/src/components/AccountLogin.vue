<template>
  <section class="loginSection">
    <div class="circle"></div>
    <div class="rectangle"></div>
    <img class="tomato1" src="../assets/img/tomato.png" alt="">
    <img class="tomato2" src="../assets/img/tomato.png" alt="">

    <section class="login_body">
      <section class="login_card">

        <article class="login_left">
          <div class="login_left_content">              
            <h2>Sweet Tomato</h2>
          </div>
        </article>
        
        <article class="login_right">
          <div class="login_right_content">
            <h2>Log in</h2>
            <span>
              Check your time with a Tomato.
              <br>
              It makes you to spend a time more effeciently.
            </span>
            <form @submit="onLoginSubmit">
              <!-- 로그인 ID 입력 div -->
              <div>
                <input placeholder="ID" class="accountInput" type="text" name="ID" v-model="ID" />
                <p>{{ IDError }}</p>
              </div>
              <!-- 로그인 비밀번호 div -->
              <div>
                <input placeholder="Password" class="accountInput" type="password" name="Password" v-model="Password">
                <p>{{ PasswordError }}</p>
              </div>
              <!-- 비밀번호 찾기 -->
              <div id="forgotPassword" @click="onClickForgotPassword">
                <span>Forget Password?</span>
              </div>
              <div class="findPassword" v-if="forgotPassword === true">
                <h3>Did you forget the Password?</h3>
                <!-- 인증번호 전송 email -->
                <div>
                  <input placeholder="Email을 입력해주세요" type="text" v-model="email_validate" />
                </div>
                <!-- 인증번호 전송 버튼 -->
                <button @click="onClickSendValidate"> <p>인증번호 전송</p> </button>
              </div>
              <!-- 로그인 버튼 -->
              <button> <p>Log in</p> </button>
              <br>
              <!-- 회원가입 찾기 이동 -->
              <div>
                <span>Don't you have account? </span>
                <a id="goSignup" @click="onClickSignup" href="">Sign up</a>
                <!-- <span id="goSignup">Sign up</span> -->
              </div>
            </form>


          </div>
        </article>


      </section>
    </section>
  </section>

</template>

<script>
// scss 스타일 적용
import '../assets/style/login.scss'
// vee-validate 으로 로그인 form validate
import { useForm, useField } from 'vee-validate'
import * as yup from 'yup'

import { computed } from '@vue/runtime-core'
import { onMounted, ref } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'

export default {
  name: "AccountLogin",

  setup() {
    const store = useStore()
    const router = useRouter()
    const forgotPassword = ref(false)
    const email_validate = ref('')

    const schema = computed(() => {
      return yup.object({
          ID: yup.string().required(),
          Password: yup.string().required().min(8)
      });
    })

    const { handleSubmit } = useForm({ validationSchema: schema });

    const { value: ID, errorMessage: IDError } = useField('ID')
    const { value: Password, errorMessage: PasswordError } = useField('Password')

    const onLoginSubmit = handleSubmit(() => {
      store.dispatch('login', { email: ID._value, password: Password._value
      }) 
    })

    const onClickSignup = function() {
      router.push({ name : 'AccountSignup'})
    }
    
    const onClickForgotPassword = function() {
      forgotPassword.value = true
    }

    const onClickSendValidate = function() {
      store.dispatch('sendValidateEmail', {email: email_validate.value})
    }

    onMounted( function() {
      forgotPassword.value = false
    })
    
    return {
      ID,
      Password,
      IDError,
      PasswordError,
      forgotPassword,
      email_validate,

      onClickSignup,
      onClickForgotPassword,
      onLoginSubmit,
      onClickSendValidate,
    }

  }
  
}
</script>

<style>

</style>