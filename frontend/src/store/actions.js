import $axios from 'axios'
import router from '@/router'

export function requestSignup (context, payload) {
  console.log(payload)
  const url = 'https://localhost:5000/member/join'
  let body = payload
  return $axios.post(url, body, {
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function login (context, credentials) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'auth/login',
    data: credentials
  })
  .then(res => {
    console.log(res.data)
    localStorage.setItem('jwt', res.data.data.token)
    // const accessToken = localStorage.getItem('jwt')
    // $axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`
    
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

export function createComment (context, arr) {
  const [studyId, input_value] = arr
  $axios({
    method: 'post',
    url: this.state.server_url + 'comment',
    data : {
      "content" : input_value,
      "studyId" : studyId
    }
  })
  .then(res => {
    context.commit('CREATE_COMMENT', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getComments (context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'comment',
    params: {
      id: studyId
    }
  })
  .then(res => {
    context.commit('GET_COMMENTS', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}