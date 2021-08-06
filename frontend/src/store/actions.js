import $axios from 'axios'
import router from '@/router'

export function login (context, credentials) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'auth/login',
    data: credentials
  })
  .then(res => {
    console.log(res.data)
    localStorage.setItem('jwt', res.data.data.token)
    
    const accessToken = localStorage.getItem('jwt')
    $axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}` 

    context.commit('CHANGE_ISLOGIN')
    router.push({ name : 'Home'})
  })
  .catch(err => {
    alert('로그인 오류입니다')
    console.log(err)
  })
}

export function sendValidateEmail (context, email) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'member/pwdSearch',
    data: email
  })
  .then(res => {
    alert(res.data.msg)
  })
  .catch(err => {
    console.log(err)
  })
}