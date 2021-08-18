<template>
  <section class="login_body">
    <div class="circle"></div>
    <div class="rectangle"></div>
    
    <article class="login_card">
      <AccountPassword :forgotPassword="forgotPassword" @closeDialog="onCloseDialog"/>
      <aside class="login_left">
        <article class="login_left_content">          
          <img src="@/assets/img/tomato1.svg" alt="">
          <div> 
            <h2>Sweet</h2> 
            <h2>Tomato</h2>
          </div>
        </article>        
      </aside>
      
      <aside class="login_right">
        <article class="login_right_content">
          <h2>로그인</h2>
          <span class="sub_head">
            토마토와 함께 공부하세요
            <br>
            보다 효율적이고 즐거운 스터디 시간
          </span>
          <form @submit="onLoginSubmit">
            <!-- 로그인 ID 입력 div -->
            <div>
              <input placeholder="이메일" class="accountInput" type="text" name="ID" v-model="ID" />
              <p>{{ IDError }}</p>
            </div>
            <!-- 로그인 비밀번호 div -->
            <div>
              <input placeholder="비밀번호" class="accountInput" type="password" name="Password" v-model="Password">
              <p>{{ PasswordError }}</p>
            </div>
            <!-- 비밀번호 찾기 -->
            <div id="forgotPassword" @click="onClickForgotPassword">
              <span>비밀번호를 잊으셨나요 ?</span>
            </div>
            <!-- 로그인 버튼 -->
            <button class="loginBtn">로그인</button>
            <br>
            <!-- 회원가입 찾기 이동 -->
            <div class="signup_footer">
              <span>계정이 없으신가요 ?   </span>
              <a id="goSignup" @click="onClickSignup">회원가입</a>
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

import { computed, onUnmounted } from '@vue/runtime-core'
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

    const onCloseDialog = function() {
      forgotPassword.value = false
    }

    onMounted( function() {
      forgotPassword.value = false
    })
    onUnmounted(() => {
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
      onCloseDialog
    }

  }
  
}
</script>

<style>

</style>