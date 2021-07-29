<template>
  <div></div>
  <!-- <li>{{ hash }}</li> -->
</template>

<script>
export default {
  name: "MakeStudyHashTag",
  props : {
    hash : {
      type : Array
    }
  },

  setup(props) {
    console.log(props.hash)
    console.log(typeof 'props.hash')
  }
}
</script>

<style>

</style>