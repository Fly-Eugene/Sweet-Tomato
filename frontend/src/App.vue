<template>
  <div>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <div v-if="state.nav_show" class="innerHeader">
      <Navbar/>
    </div>


      <!-- <div class="startPageTomato">
        <img src="@/assets/img/tomato1.svg" alt="">
        <button @click="$router.push({name: 'Home'})">시작하기</button>
      </div> -->

    <router-view/>
    <div v-if="state.nav_show" class="footer">      
    </div>
  </div>

</template>

<script>
import '@/assets/style/app.scss'
import Navbar from '@/views/Navbar.vue'
import { useStore } from 'vuex'
import { computed, onMounted, reactive} from 'vue'
import router from '@/router'

export default {
  name: 'App',

  components: {
    Navbar
  },

  setup() {
    const store = useStore()

    const state = reactive({
      nav_show : computed(()=> {
        return store.state.nav_show
      }),
    })
    function move() {
      store.dispatch('getRecentStudy')
      store.dispatch('getMyTomato')
      store.dispatch('getMyStudyTime')
      router.push({name: 'Mypage'})
    }
    onMounted(() => {
      store.dispatch('checkLogin')
    })


    
    return {
      state,
      move
    }
  }
}
</script>
