<template>
  <section class="signup">
    <div class="circle"></div>
    <div class="rectangle"></div>
    <img class="tomato1" src="../assets/img/tomato.png" alt="">
    <img class="tomato2" src="../assets/img/tomato.png" alt="">
    <section class="signup_body">
      <section class="signup_card">
        <article class="signup_left">
          <div class="signup_left_content">              
            <h2>Sweet Tomato</h2>
            <div class="profile_box">
              <img class="profile" src="../assets/img/basic_profile.png" alt="">
            </div>
          </div>
        </article>
        <article class="signup_right">
          <div class="signup_right_content">
            <h2>Sign Up</h2>
            <span>Please fill your information for Signup</span>
            <form class="signup_form" action="#" ref="signupForm" @submit="checkSignupForm">
              <div>
                <input type="text" v-model="state.form.id" placeholder="     ID">
              </div>      
              <div>
                <input type="text" v-model="state.form.username" placeholder="     Username">
              </div>      
              <div>
                <input type="text" v-model="state.form.password" placeholder="     Password">
              </div>
              <div>
                <input type="text" v-model="state.form.passwordConfirmation" placeholder="     Password Confirm">
              </div>
              <div>
                <input type="text" v-model="state.form.email" placeholder="     Email">
              </div>      
              <div>
                <input type="text" v-model="state.form.age" placeholder="     Age">
              </div>
              <div>
                <input type="text" v-model="state.form.group" placeholder="     Group">
              </div>
              <footer>
                <div class="checkbox"></div>
                <p class="checkword">I Agree with a policy and policy</p>
              </footer>
              <button> <p>Sign Up</p> </button>
            </form>        
          </div>          
        </article>
      </section>    
    </section>  
  </section>  
</template>

<script>
import { reactive, ref } from 'vue'
import { useStore } from 'vuex' 
import '../assets/style/signup.scss'
import signupValidation from '../assets/js/signupValidation.js'

export default {
  name: "AccountSignup",

  setup(){
    const store = useStore()
    const signupForm = ref(null)

    const state = reactive({
      form: {
        id: '',
        username: '',
        password: '',
        passwordConfirmation: '',
        email: '',
        age: '',
        group: '',
      },
    }) 
    const checkSignupForm = function(e) {
      e.preventDefault();
      if (!signupValidation.checkEmail(state.form.id)) {
        console.log(signupValidation.checkEmail(state.form.id))
      }
      else if (!signupValidation.checkId(state.form.username)) {
        alert('1')
      } else if (!signupValidation.checkPassword(state.form.password)) {
        alert('2')
      } else if (!signupValidation.checkPasswordConfirmation({ password: state.form.password, passwordConfirmation: state.form.passwordConfirmation })) {
        alert('3')
      } else {
        console.log({id: state.form.id, nickname: state.form.username, password: state.form.password, email: state.form.email, age: state.form.age, department: state.form.group })
        store.dispatch('requestSignup', { id: state.form.id, username: state.form.username, password: state.form.password, email: state.form.email, age: state.form.age, group: state.form.group })
      }
      console.log()
    }
      
    return { store, signupForm, state, checkSignupForm }
  }
}
</script>

<style>

</style>