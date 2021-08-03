import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import AccountLogin from '@/components/ModalContent/AccountLogin.vue'
import AccountSignup from '@/components/ModalContent/AccountSignup'
import Profile from '@/views/Profile'
import StudyMain from '@/views/StudyMain'
import MakeStudy from '@/components/ModalContent/MakeStudy'
import Room from '@/views/Room'
import Modal from '@/views/Modal'

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
    name: 'Profile',
    component: Profile
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
  {
    path: '/room',
    name: 'Room',
    component: Room
  },
  {
    path: '/modaltest',
    name: 'Modal',
    component: Modal
  }
 
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
