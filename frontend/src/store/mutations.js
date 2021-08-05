
export function CHANGE_ISLOGIN (state) {
  const check_jwt = localStorage.getItem('jwt')
  if (check_jwt) {
    state.isLogin = true
  }
  else {
    state.isLogin = false
  }
}

export function CREATE_COMMENT (state, res) {
  state.studyComments.push(res)
}

export function GET_COMMENTS (state, res) {
  state.studyComments = res
}