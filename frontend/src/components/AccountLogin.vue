<template>
  <section id="loginSection">
    <form @submit="onLoginSubmit">
      <h1 class="accountLogo">Log in</h1>
      <p class="accountContent">
        Check your time with a Tomato.
        <br>
        It makes you to spend a time more effeciently.
      </p>
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
      <div id="forgotPassword">
        <span>Forget Password?</span>
      </div>
      <!-- 로그인 버튼 -->
      <button class="accountBtn" id="loginbtn">로그인</button>
      <br>
      <!-- 회원가입 찾기 이동 -->
      <div id="goSignup">
        <span>Don't you have account? </span>
        <span>Sign up</span>
      </div>
    </form>
  </section>

</template>

<script>
// import { ref } from 'vue'
import { useForm, useField } from 'vee-validate'
import * as yup from 'yup'
import { computed } from '@vue/runtime-core'
import { useStore } from 'vuex'

export default {
  name: "AccountLogin",

  setup() {
    const store = useStore()

    const schema = computed(() => {
      return yup.object({
          ID: yup.string().required(),
          Password: yup.string().required().min(8)
      });
    })

    const { handleSubmit } = useForm({ validationSchema: schema });


    const { value: ID, errorMessage: IDError } = useField('ID')
    const { value: Password, errorMessage: PasswordError } = useField('Password')

      const credentials = {
        email: ID._value,
        password: Password._value
      }

      // console.log(credentials)

    const onLoginSubmit = handleSubmit(() => {

      console.log(ID._value, Password._value)
      store.dispatch('login', { email: ID._value, password: Password._value
      }) 

    })
    

    return {
      ID,
      Password,
      credentials,
      IDError,
      PasswordError,

      onLoginSubmit,
    }

  }
  
}
</script>

<style>
  body {
    background-color: #FFD0BB;
  }

  .accountLogo {
    font-size: 64px;
  }
  .accountContent {
    font-size: 20px;
  }

  .accountInput {
    font-size: 25px;

    width: 378px;
    height: 48px;
    background: #EDD9D9;
    border-radius: 50px;
  }

  .accountBtn {
    margin-top: 45px;

    font-size: 25px;
    color: white;

    width: 254px;
    height: 47px;

    background: #AE1A1F;
    border-radius: 50px;
  }

  #forgotPassword {
    text-align: right;
    margin-right: 60px;
  }
  
  #loginSection {
    position: absolute;
    width: 1273px;
    height: 889px;
    left: 83px; 
    top: 68px;

    background: #FFFFFF;
    border-radius: 50px;
  }

  #goSignup {
    margin-top: 10px;
  }


</style>