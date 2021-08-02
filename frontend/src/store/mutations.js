
export function CHANGE_ISLOGIN (state) {
  const check_jwt = localStorage.getItem('jwt')
  if (check_jwt) {
    state.isLogin = true
  }
  else {
    state.isLogin = false
  }
}