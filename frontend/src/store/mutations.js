export function SHOW_NAV (state, boolean) {
  state.nav_show = boolean
}

export function SHOW_TOMATO (state, boolean) {
  state.start_page_tomato_show = boolean
}

export function CHANGE_ISLOGIN (state) {
  const check_jwt = localStorage.getItem('jwt')
  if (check_jwt) {
    state.isLogin = true
  }
  else {
    state.isLogin = false
  }
}

export function GET_STUDY_INFO (state, res) {
  state.studyInfo = res
}

export function GET_STUDY_IMG(state, res) {
  state.studyImg = res
}

export function CREATE_COMMENT (state, res) {
  state.studyComments.push(res)
}

export function GET_COMMENTS (state, res) {
  state.studyComments = res
}

export function GET_DATA (state, res) {
  state.studyData = res
}

export function GET_DATA_SPECI (state, res) {
  state.studyDataSpeci = res
}

export function GET_TOMATO (state, res) {
  state.totalTomato = res.totalSum
  state.studyTomato = res.relevantSum
  state.tomatoes = res.tomatoes
}

export function GET_MY_TOMATO(state, res) {
  state.myTomato = res.relevantSum
  state.everyTomato = res.totalSum
}

export function GET_MY_STUDY_TIME(state, res) {
  state.myStudyTime = res
}

export function GET_RECENT_STUDY(state, res) {
  state.myRecentStudy = res
}

export function SEARCH_STUDY(state, res) {
  state.searchedStudies = res
}

export function GET_POMODORO_GOAL(state, res) {
  state.studyPomodoroGoals = res
}

export function GET_POMODORO_STATE(state, res) {
  state.studyPomodoroState = res.tomatoes
  console.log(state.studyPomodoroState)
}

export function ADD_PARTICIPANT_ID(state, data) {
  console.log(state.participantsId)
  console.log(data)
  state.participantsId.push(data)
  console.log('지금 mutation 실행 중')
}



