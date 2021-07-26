import $axios from 'axios'

export function requestSignup (payload) {
  console.log('hi')
  const url = 'http://localhost:5000/member/join'
  let body = payload
  return $axios.post(url, body)
}
