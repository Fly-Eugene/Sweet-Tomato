import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import AccountLogin from '@/components/ModalContent/AccountLogin.vue'
import AccountSignup from '@/components/ModalContent/AccountSignup'
import Profile from '@/views/Profile'
import StudyMain from '@/views/StudyMain'
import Room from '@/views/Room'
import Modal from '@/views/Modal'
import DetailStudy from '@/views/DetailStudy'

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
    path: '/room',
    name: 'Room',
    component: Room
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
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
