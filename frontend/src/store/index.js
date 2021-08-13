import { createStore } from 'vuex'
import state from './state'
import createPersistedState from 'vuex-persistedstate';
import * as getters from './getters'
import * as mutations from './mutations'
import * as actions from './actions'

export default createStore({
  plugins: [
    createPersistedState()
  ],
  state,
  mutations,
  actions,
  getters,
  plugins: [ createPersistedState()],
})
