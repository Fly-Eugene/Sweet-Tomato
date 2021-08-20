import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import AccountLogin from '@/components/ModalContent/AccountLogin.vue'
import AccountSignup from '@/components/ModalContent/AccountSignup'
import StudyMain from '@/views/StudyMain'
import Mypage from '@/views/Mypage'
import ErrorPage from '@/views/ErrorPage.vue'
import Modal from '@/views/Modal'
import DetailStudy from '@/views/DetailStudy'
import OpenVidu from '@/views/Openvidu'
import Room from '@/views/Room'

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
  {
    path: '/openvidu',
    name: 'OpenVidu',
    component: OpenVidu,
    props: true
  },
  {
    path: '/Room',
    name: 'Room',
    component: Room,
    props: true
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
