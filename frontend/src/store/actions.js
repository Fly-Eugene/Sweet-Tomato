import $axios from 'axios'

export function requestSignup (context, payload) {
  console.log(payload)
  const url = 'http://localhost:5000/member/join'
  let body = payload
  let headers = {"Content-Type": "multipart/form-data"}
  return $axios.post(url, body, headers)
}
