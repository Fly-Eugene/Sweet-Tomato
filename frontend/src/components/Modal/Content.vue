<template>
  <div class="modal-mask">
    <div class="modal-container">

      <div class="modal-header">
        <slot name="header">
          default header
        </slot>
      </div>

      <div class="modal-body">
        <slot name="body">
          default body
        </slot>
      </div>

      <div class="modal-footer">
        <slot name="footer">
          default footer
          <button class="modal-button" @click="$emit('close')">
            OK
          </button>
        </slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ModalContent"

}
</script>

<style>

</style>