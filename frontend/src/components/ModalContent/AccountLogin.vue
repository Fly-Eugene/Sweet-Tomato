<template>
  <section class="login_body">
    <div class="circle"></div>
    <div class="rectangle"></div>
    <img class="tomato1" src="@/assets/img/tomato.png" alt="">
    <img class="tomato2" src="@/assets/img/tomato.png" alt="">
    
    <article class="login_card">
      <AccountPassword :forgotPassword="forgotPassword"/>
      <aside class="login_left">
        <article class="login_left_content">              
          <h2>Sweet Tomato</h2>
        </article>
      </aside>
      
      <aside class="login_right">
        <article class="login_right_content">
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
            <!-- 로그인 버튼 -->
            <button> <p>Log in</p> </button>
            <br>
            <!-- 회원가입 찾기 이동 -->
            <div>
              <span>Don't you have account? </span>
              <a id="goSignup" @click="onClickSignup" href="">Sign up</a>
            </div>
          </form>
        </article>
      </aside>
    </article>
  </section>
</template>

<script>
// scss 스타일 적용
import '@/assets/style/login.scss'
// vee-validate 으로 로그인 form validate
import { useForm, useField } from 'vee-validate'
import * as yup from 'yup'

import { computed } from '@vue/runtime-core'
import { onMounted, ref } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'

import AccountPassword from '@/components/ModalContent/AccountPassword.vue'

export default {
  name: "AccountLogin",

  components: {
    AccountPassword
  },

  setup() {
    const store = useStore()
    const router = useRouter()
    const forgotPassword = ref(false)

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


    onMounted( function() {
      forgotPassword.value = false
    })
    
    return {
      ID,
      Password,
      IDError,
      PasswordError,
      forgotPassword,

      onClickSignup,
      onClickForgotPassword,
      onLoginSubmit,
    }

  }
  
}
</script>

<style>

</style>