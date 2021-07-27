import $axios from 'axios'

export function requestSignup (payload) {
  console.log('hi')
  const url = 'http://localhost:5000/member/join'
  let body = payload
  return $axios.post(url, body)
}

export function login (context, credentials) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'auth/login',
    data: credentials
  })
  .then(res => {
    localStorage.setItem('jwt', res.data.Token.token)
    context.commit('CHANGE_ISLOGIN')
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
    console.log(res, '이거 actions axios log인데, res 어떻게 처리하지')
  })
  .catch(err => {
    alert('인증번호 전송 실패??')
    console.log(err)
  })
}