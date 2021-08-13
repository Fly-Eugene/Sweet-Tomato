<template>
<div v-if="streamManager" style="width: 33%;">
	<ov-video :stream-manager="streamManager"/>
	<div class="user_name">{{ clientData }}</div>
</div>
</template>

<script>
import OvVideo from './OvVideo';
import "@/assets/style/openvidu.scss";
export default {
	name: 'UserVideo',
	components: {
		OvVideo,
	},
	props: {
		streamManager: Object,
	},
	computed: {
		clientData () {
			const { clientData } = this.getConnectionData();
			return clientData;
		},
	},
	methods: {
		getConnectionData () {
			const { connection } = this.streamManager.stream;
			return JSON.parse(connection.data);
		},
	},
};
</script>