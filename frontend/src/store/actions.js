import $axios from 'axios'
import router from '@/router'
// import state from './state'

// export function checkNav (context) {
//   if(document.location.pathname === '/openvidu'){
//     context.commit('CHECK_NAV', false)
//   } else {
//     context.commit('CHECK_NAV', true)
//   }
// }

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
    console.log(res.data.data.member)
    localStorage.setItem('jwt', res.data.data.token)
    this.state.myInfo = res.data.data.member
    context.commit('CHANGE_ISLOGIN')
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

export function getStudyImg (context, studyId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'profile/study',
    params: {
      StudyId: studyId
    }
  })
  .then(res => {
    // console.log(res.data)
    context.commit('GET_STUDY_IMG', res.data)
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

export function getDownloadFile (context, fileId) {
  $axios({
    method: 'get',
    url: this.state.server_url + 'file/download/' + fileId,
    responseType : 'arraybuffer',
  })
  .then(res => {
    console.log(res.data)
    console.log(res.headers)
    const url = window.URL.createObjectURL(new Blob([res.data]), {type: res.headers['content-type']})
    const link = document.createElement('a')
    const contentDisposition = res.headers['content-disposition']    // 파일 이름이라고 한다

    let fileName = 'unkown'
    if (contentDisposition) {
      const [fileNameMatch] = contentDisposition.split(';').filter(str => str.includes('filename'));
      if (fileNameMatch) {
        [, fileName] = fileNameMatch.split('=')
      }
    }

    link.href = url
    link.setAttribute('download', `${fileName}`)
    document.body.appendChild(link)
    link.click()
    link.remove()

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


