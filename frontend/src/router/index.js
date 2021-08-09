import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import AccountLogin from '@/components/ModalContent/AccountLogin.vue'
import AccountSignup from '@/components/ModalContent/AccountSignup'
import StudyMain from '@/views/StudyMain'
// import Room from '@/views/Room'
import Modal from '@/views/Modal'
import DetailStudy from '@/views/DetailStudy'
import Mypage from '@/views/Mypage'

import ErrorPage from '@/views/ErrorPage.vue'

const routes = [
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage
  },
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
    path: '/study/main',
    name: 'StudyMain',
    component: StudyMain
  },

  // {
  //   path: '/room',
  //   name: 'Room',
  //   component: Room
  // },
  {
    path: '/modaltest',
    name: 'Modal',
    component: Modal,
  },

  {
    path: '/study/:id',
    name: 'DetailStudy',
    component: DetailStudy,
    props: true
  },

  {
    path: '/error',
    name: 'ErrorPage',
    component: ErrorPage,
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
