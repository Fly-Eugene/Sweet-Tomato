import { createStore } from 'vuex'
import axios from 'axios'


export default createStore({
  state: {
    server_url : 'http://localhost:5000/',
    isLogin : false
  },

  mutations: {
    CHANGE_ISLOGIN: function (state) {
      const check_jwt = localStorage.getItem('jwt')
      if (check_jwt) {
        state.isLogin = true
      }
      else {
        state.isLogin = false
      }
    }
  },
  actions: {

    login: function(context, credentials) {
      axios({
        method: 'post',
        url: this.state.server_url + 'auth/login',
        data: credentials
      })
      .then(res => {
        console.log(res.data)
        localStorage.setItem('jwt', res.data.Token.token)
        context.commit('CHANGE_ISLOGIN')
      })
      .catch(err => {
        alert('로그인 오류입니다')
        console.log(err)
      })
    }
  },
  modules: {  
  }
})
