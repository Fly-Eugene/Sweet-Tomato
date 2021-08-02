export default {  
  checkId (id) {
    if (id === '') {
      return false
    }
    else {
      return true
    }
  },
  checkUsername (name) {
    if (name === '') {
      return false
    }
    else {
      return true
    }
  },
  checkPassword (password) {
    if (password === '') {
      return false
    }
    else {
      return true
    }
  },
  checkPasswordConfirmation (form) {
    if (form['password'] !== form['passwordConfirmation']) {
      return false
    }
    if (form['password'] === form['passwordConfirmation']) {
      return true
    }
  },
  checkEmail (email) {
    if (email === '') {
      return 'asdfasdf'
    }
    else {
      return 'hi'
    }
  },
  checkAge (age) {
    if (age === '') {
      return false
    }
    else {
      return true
    }
  },
  checkGroup (group) {
    if (group === '') {
      return false
    }
    else {
      return true
    }
  },
}
