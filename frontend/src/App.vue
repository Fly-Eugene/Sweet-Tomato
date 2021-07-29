<template>
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link :to="{name: 'AccountLogin'}">AccountLogin</router-link> |
    <router-link :to="{name: 'AccountSignup'}">Signup</router-link> |
    <router-link :to="{name: 'AccountProfile'}">Profile</router-link> | 
    <router-link :to="{name: 'StudyMain'}">StudyMain</router-link>
  </div>
  <router-view/>
</template>

<style>

body {
  background: #FFD0BB;
  overflow: hidden;
  width: 100%;
  height: 100%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
  height: 100%;
}

#nav {
  padding: 0px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
