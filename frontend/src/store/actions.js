import $axios from 'axios'
import router from '@/router'

export function hideNav (context) {
  context.commit('SHOW_NAV', false)
}

export function showNav (context) {
  context.commit('SHOW_NAV', true)
}

export function hideTomato (context) {
  context.commit('SHOW_TOMATO', false)
}

export function showTomato (context) {
  context.commit('SHOW_TOMATO', true)
}


export function checkLogin (context) {
  const accessToken = localStorage.getItem('jwt')
  context.commit('CHANGE_ISLOGIN')

  if (accessToken) {
    $axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`
  } else {
    $axios.defaults.headers.common['Authorization'] = null
  }
}

export function login (context, credentials) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'auth/login',
    data: credentials
  })
  .then(res => {
    localStorage.setItem('jwt', res.data.data.token)
    this.state.myInfo = res.data.data.member
    context.commit('CHANGE_ISLOGIN')
    console.log(res.data.data.member)
    router.push({ name : 'Home'})
  })
  .catch(err => {
    alert('로그인 오류입니다')
    console.log(err)
  })
}

export function logout(context) {
  localStorage.removeItem('jwt')
  context.commit('CHANGE_ISLOGIN')
  router.push({ name : 'Home'})
  alert('로그아웃 되었습니다.')
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

export function getStudyInfo (context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'study/detail',
    params : {
      studyId : studyId
    }
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_STUDY_INFO', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function editStudyInfo (context, frm) {
  console.log(frm)
  $axios({
    method: 'patch',
    url: this.state.server_url + 'study',
    data: frm,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
  .then(res => {
    console.log(res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function studyApply (context, studyId) {
  $axios({
    method: 'post',
    url: this.state.server_url + 'study/join',
    data: {
      studyId: studyId
    }
  })
  .then(res => {
    console.log(res.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function studyResign (context, studyId) {
  $axios({
    method: 'delete',
    url: this.state.server_url + 'study/withdraw',
    data: {
      studyId: studyId
    }
  })
  .then(res => {
    console.log(res.data)
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
    console.log(res.data.data)
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
      studyId: studyId
    }
  })
  .then(res => {
    context.commit('GET_COMMENTS', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getData (context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'dataroom',
    params: {
      studyId : studyId
    }
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_DATA', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getDataSpeci (context, dataId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'dataroom/detail/' + dataId
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_DATA_SPECI', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getStudyTomato (context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'tomato/study/' + studyId,
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_TOMATO', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getMyTomato ({ commit }) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'tomato'
  })
  .then(res => {
    console.log('내 토마토 가져옴')
    console.log(res.data.data)
    commit('GET_MY_TOMATO', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getMyStudyTime({ commit }) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'member/time'
  })
  .then(res => {
    console.log('스터디타임 가져옴')
    console.log(res.data.data)
    commit('GET_MY_STUDY_TIME', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getRecentStudy({ commit }) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'study/recently'
  })
  .then(res => {
    console.log('최근 스터디 가져옴')
    console.log(res.data.data)
    // console.log(res)
    commit('GET_RECENT_STUDY', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function searchStudy({ commit }, hashtag) {
  this.state.studyHashtag = hashtag.themes
  
  $axios({
    method: 'post',
    url: this.state.server_url + 'study/search',
    data: hashtag
  })
  .then(res => {
    console.log(res)
    commit('SEARCH_STUDY', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function getPomodoroState(context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'tomato/today/study/' + studyId
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_POMODORO_STATE', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}


export function getPomodoroGoal(context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'tomato/goal/' + studyId
  })
  .then(res => {
    console.log(res.data.data)
    context.commit('GET_POMODORO_GOAL', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })

}

export function setPomodoro(context, data) {
  const {goal, time, studyId} = data
  
  $axios({
    method: 'post',
    url: this.state.server_url + 'tomato/goal',
    data: {
      goalTomato: goal,
      goalTime : time,
      studyId : studyId
    }
  })
  .then(res => {
    console.log(res.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function patchPomodoro(context, data) {
  const {goal, time, studyId, tomatoPlanId} = data

  $axios({
    method: 'patch',
    url: this.state.server_url + 'tomato/goal',
    data: {
      goalTomato: goal,
      goalTime : time,
      studyId : studyId,
      tomatoPlanId: tomatoPlanId
    }
  })
  .then(res => {
    console.log(res.data);
  })
  .catch(err => {
    console.log(err)
  })
}

export function addTomato(context, studyId) {

  $axios({
    method: 'post',
    url: this.state.server_url + 'tomato',
    data : {
      studyId : studyId
    }
  })
  .then(() => {
  })
  .catch(err => {
    console.log(err)
  })
}

export function getParticipants(context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'study/connection/' + studyId
  })
  .then(res => {
    console.log(res.data)
    context.commit('GET_PARTICIPANTS', res.data.data)
  })
  .catch(err => {
    console.log(err)
  })
}

export function addParticipant(context, data) {
  const {nickname, studyId} = data
  $axios({
    method: 'post',
    url: this.state.server_url + 'study/connect',
    data: {
      studyId : studyId,
      nickname : nickname
    }
  })
  .then(res => {
    console.log(res.data)
  })
  .catch(err => {
    console.log(err)
  })

}