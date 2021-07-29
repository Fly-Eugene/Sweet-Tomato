import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import AccountLogin from '@/components/AccountLogin.vue'
import AccountSignup from '@/components/AccountSignup'
import AccountProfile from '@/components/AccountProfile'
import StudyMain from '@/views/StudyMain'
import MakeStudy from '@/views/MakeStudy'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/account/login',
    name: 'AccountLogin',
    component: AccountLogin
  },
  {
    path: '/account/signup',
    name: 'AccountSignup',
    component: AccountSignup
  },
  {
    path: '/account/profile',
    name: 'AccountProfile',
    component: AccountProfile
  },
  {
    path: '/study/main',
    name: 'StudyMain',
    component: StudyMain
  },
  {
    path: '/study',
    name: 'MakeStudy',
    component: MakeStudy
  },
 
  // {
  //   path: '/account',
  //   name: 'Account',
  //   component: Account,

  //   children: [
  //     { path: 'logintemp',
  //       component: LoginTemp,  
  //     },
  //     { path: 'signuptemp',
  //       component: SignupTemp
  //     }
  //   ]
  // }


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
