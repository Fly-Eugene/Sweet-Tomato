<template>
	<video style="width:95%;" autoplay/>
</template>

<script>
export default {
	name: 'OvVideo',
	props: {
		streamManager: Object,
	},
	mounted () {
		this.streamManager.addVideoElement(this.$el);
	},
};
</script>