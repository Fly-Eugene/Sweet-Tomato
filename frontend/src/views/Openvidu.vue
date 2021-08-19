<template>
  <div id="main-container" class="container">
    <div id="join" v-if="!session">
      <article class="join_container">
        <!-- <div id="img-div"></div> -->
        <div id="join-dialog" class="jumbotron vertical-center">
          <h1 class="join_phrase">Join Study</h1>
          <div class="form-group">
            <p>
              <!-- <label>Participant</label> -->
              <input
                placeholder="닉네임을 입력해주세요"
                v-model="state.myInfo.username"
                class="form-control participant_input"
                type="text"
                required
              />
            </p>
            <!-- <p>
              <label>Session</label>
              <input
                v-model="id"
                class="form-control session_input"
                type="text"
                required
              />
            </p> -->
            <p class="text-center">
              <button
                class="btn btn-lg btn-success join_btn"
                @click="joinSession()"
              >
                Join!
              </button>
            </p>
          </div>
        </div>
      </article>
    </div>

    <div id="session" v-if="session">
      <div id="session-header">
        <!-- <h1 id="session-title">{{ studyId }}</h1> -->
        <input
          v-model="leave"
          style="display:none"
        />
        <input
          v-model="audio"
          style="display:none"
        />
        <input
          v-model="video"
          style="display:none"
        />
        <input v-model="part" style="display:none"/>
      </div>
      <!-- <div id="main-video" class="col-md-6">
        <user-video :stream-manager="mainStreamManager" />
      </div> -->
      <div id="video-container" class="col-md-6" style="display:flex; flex-wrap:wrap; overflow-y:auto; height:73vh">
        <user-video
          :stream-manager="publisher"
          @click="updateMainVideoStreamManager(publisher)"
        />
        <user-video
          v-for="sub in subscribers"
          :key="sub.stream.connection.connectionId"
          :stream-manager="sub"
          @click="updateMainVideoStreamManager(sub)"
        />
      </div>
      <Participants :participants="participants" v-if="part" @closeBtn="$emit('closeBtn')" :studyLeader="studyLeader == state.myInfo.id" :leaderId='studyLeader' @explusion="Explusion"/>
      <SideOptions :chatContents="chatContents" v-if="chat" @closeBtn="$emit('closeBtn')"/>
      <div class="chat_box" v-if="chat" style="width: 20%; font-family:'Godo'">
        {{this.state.myInfo.username}} :
        <input type="text" v-model="chat_value" @keyup.enter="onEnterChat" id="chat_value"/>
        <img src="@/assets/img/enter.png" style="width: 7%; cursor:pointer" @click="onEnterChat"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { OpenVidu, Subscriber } from "openvidu-browser";
import UserVideo from "../components/Room/UserVideo";
import "@/assets/style/openvidu.scss";
import SideOptions from "@/components/Room/SideOptions.vue";
import { useStore } from 'vuex'
import { reactive, computed } from 'vue'
import Participants from '../components/Room/Participants.vue';

axios.defaults.headers.post["Content-Type"] = "application/json";

const OPENVIDU_SERVER_URL = "https://i5b106.p.ssafy.io:4443";
const OPENVIDU_SERVER_SECRET = "MY_SECRET";

export default {
  name: "OpenVidu",
  props : {
    studyId : {
      type: String,
    },
    leave: {
      type: Boolean
    },
    chat:{
      type: Boolean
    },
    audio: {
      type: Boolean
    },
    video: {
      type: Boolean
    },
    part: {
      type: Boolean
    },
    studyLeader: {
      type: String
    }
  },
  components: {
    UserVideo,
    SideOptions,
    Participants
  },
  data() {
    return {
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],
      chat_value: "",
      // 임시적 채팅내용
      chatContents: [],
      startTime: Date,
      publishCheck: false,
    };
  },
  setup(){
    const store = useStore()
    const state = reactive({
      myInfo: computed(() => {
        return store.state.myInfo;
      }),
      participants: computed(() => {
        return store.state.participants;
      }),
      participantsInfo: computed(() => {
        console.log(store.state.participantsInfo)
        return store.state.participantsInfo;
      })
    })
    // store.state.participantsId = []
    
    return {
      state
    }
  },
  methods: {
    Explusion(value){
      console.log(value)
      axios({
        method: 'post',
        url: 'https://localhost:5000/blacklist',
        data: {memberId: value, studyId: this.studyId}
      })
      .then(() => {
        alert("해당 멤버가 블랙리스트에 등록되었습니다.")
      })
      .catch(err => {
        console.log(err)
      })
    },
    joinSession() {
      var now = new Date();
      this.startTime = new Date(now.getFullYear(), now.getMonth()+1, now.getDate(), now.getHours(), now.getMinutes());
      // axios({
      //   method: 'post',
      //   url: 'https://localhost:5000/study/connection',
      //   data: {studyId: this.studyId}
      // })
      // .then(() => {
        
      // })
      // .catch(err => {
      //   console.log(err)
      // })
      
      console.log(this.state.myInfo)
      this.state.participants.push(this.state.myInfo.username)

      // ================ 해당 username 과 그 멤버의 memberId를 같이 짝지어서 저장한다. ==========================
      this.$store.dispatch('addParticipant', {nickname: this.state.myInfo.username, studyId: this.studyId})
      

      // --- Get an OpenVidu object ---
      this.OV = new OpenVidu();
      // --- Init a session ---
      this.session = this.OV.initSession();
      // --- Specify the actions when events take place in the session ---
      // On every new Stream received...
      this.session.on("streamCreated", ({ stream }) => {
        this.$store.dispatch('getParticipants', this.studyId)
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
        this.state.participants.push(JSON.parse(subscriber.stream.connection.data).clientData)
      });
      // On every Stream destroyed...
      this.session.on("streamDestroyed", ({ stream }) => {
        this.$store.dispatch('getParticipants', this.studyId)
        let index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
          console.log((JSON.parse(stream.connection.data).clientData))
          this.state.participants.splice(this.state.participants.indexOf((JSON.parse(stream.connection.data).clientData)), 1);
        }

        // ============= 해당 username은 일시적이었으므로 session을 나갈 때 index를 찾아서 없애준다 ==================
        const remove_idx = useStore().state.participantsId.findIndex(function(item) {return item[0] === JSON.parse(stream.connection.data).clientData})
        console.log(remove_idx, '찾았다!! remove idx')
        if (remove_idx > -1) {
          useStore().state.participantsId(remove_idx, 1)
        }

      });
      // On every asynchronous exception...
      this.session.on("exception", ({ exception }) => {
        console.warn(exception);
      });
      // --- Connect to the session with a valid user token ---
      // 'getToken' method is simulating what your server-side should do.
      // 'token' parameter should be retrieved and returned by your own backend
      this.getToken(this.studyId).then((token) => {
        this.session
          .connect(token, { clientData: this.state.myInfo.username })
          .then(() => {
            // --- Get your own camera stream with the desired properties ---
            let publisher = this.OV.initPublisher(undefined, {
              audioSource: undefined, // The source of audio. If undefined default microphone
              videoSource: undefined, // The source of video. If undefined default webcam
              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: true, // Whether you want to start publishing with your video enabled or not
              resolution: "640x480", // The resolution of your video
              frameRate: 30, // The frame rate of your video
              insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
              mirror: false, // Whether to mirror your local video or not
            });
            this.mainStreamManager = publisher;
            this.publisher = publisher;
            // --- Publish your stream ---
            this.session.publish(this.publisher);
            this.publishCheck = true;
            this.$store.dispatch('getParticipants', this.studyId)
          })
          .catch((error) => {
            console.log(
              "There was an error connecting to the session:",
              error.code,
              error.message
            );
          });
      });

      // ======================= 채팅 커스텀 시작 ==============================
      this.session.on("signal", (event) => {
        this.chatContents.push(event.data);
        console.log("event.data", event.data);
        console.log("event.from.connetctionId", event.from.connectionId); // 여기서 userId 뽑을 수 있다.
        console.log("localOptions", event.from.localOptions);
      });
      // ======================= 커스텀 끝 ==============================

      window.addEventListener("beforeunload", this.leaveSession);
    },
    audioControll(){
      this.publisher.publishAudio(this.audio);
    },
    videoControll(){
      this.publisher.publishVideo(this.video);
    },
    leaveSession() {
      this.publishCheck = false;
      // --- Leave the session by calling 'disconnect' method over the Session object ---
      var now = new Date();
      var endTime = new Date(now.getFullYear(), now.getMonth()+1, now.getDate(), now.getHours(), now.getMinutes());
      var elapsedMSec = endTime.getTime() - this.startTime.getTime();
      var elapsedMin = elapsedMSec / 1000 / 60;
      axios({
        method: 'post',
        url: 'https://localhost:5000/member/time',
        data: {studyTime: elapsedMin}
      })
      .then(() => {
      })
      .catch(err => {
        console.log(err)
      })
      axios({
        method: 'patch',
        url: 'https://localhost:5000/study/disconnect/' + this.studyId,
      })
      .then(() => {
        
      })
      .catch(err => {
        console.log(err)
      })
      if (this.session) this.session.disconnect();
      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      useStore().state.participants = [];
      this.OV = undefined;
      window.removeEventListener("beforeunload", this.leaveSession);
      this.$router.push({name: 'DetailStudy', params: {id: this.studyId}})
    },
    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },
    onEnterChat() {
      this.session
        .signal({
          data: this.state.myInfo.username + "&$" + this.chat_value + "&$" + this.currentTime(),
          to: [],
        })
        .then(() => {
          console.log("Message successfully sent");
          this.chat_value = "";
        })
        .catch((err) => {
          console.log(err);
        });
    },
    currentTime(){
      var date = new Date();
      var hours = ('0' + date.getHours()).slice(-2); 
      var minutes = ('0' + date.getMinutes()).slice(-2);

      var time = hours + ':' + minutes;
      console.log(time);
      return time;
    },
    /**
     * --------------------------
     * SERVER-SIDE RESPONSIBILITY
     * --------------------------
     * These methods retrieve the mandatory user token from OpenVidu Server.
     * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
     * the API REST, openvidu-java-client or openvidu-node-client):
     *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
     *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
     *   3) The Connection.token must be consumed in Session.connect() method
     */
    getToken(mySessionId) {
      return this.createSession(mySessionId).then((sessionId) =>
        this.createToken(sessionId)
      );
    },
    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessions
    createSession(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions`,
            JSON.stringify({
              customSessionId: sessionId,
            }),
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.id))
          .catch((error) => {
            if (error.response.status === 409) {
              resolve(sessionId);
            } else {
              console.warn(
                `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}`
              );
              if (
                window.confirm(
                  `No connection to OpenVidu Server. This may be a certificate error at ${OPENVIDU_SERVER_URL}\n\nClick OK to navigate and accept it. If no certificate warning is shown, then check that your OpenVidu Server is up and running at "${OPENVIDU_SERVER_URL}"`
                )
              ) {
                location.assign(`${OPENVIDU_SERVER_URL}/accept-certificate`);
              }
              reject(error.response);
            }
          });
      });
    },
    // See https://docs.openvidu.io/en/stable/reference-docs/REST-API/#post-openviduapisessionsltsession_idgtconnection
    createToken(sessionId) {
      return new Promise((resolve, reject) => {
        axios
          .post(
            `${OPENVIDU_SERVER_URL}/openvidu/api/sessions/${sessionId}/connection`,
            {},
            {
              auth: {
                username: "OPENVIDUAPP",
                password: OPENVIDU_SERVER_SECRET,
              },
            }
          )
          .then((response) => response.data)
          .then((data) => resolve(data.token))
          .catch((error) => reject(error.response));
      });
    },
  },
	mounted() {
		this.$store.dispatch('checkLogin')
		this.$store.dispatch('hideNav')
    // this.$store.dispatch('getParticipants', this.studyId)
	},
	unmounted() {
		this.$store.dispatch('showNav')
	},
  computed:{
    leave: function(){
      console.log(this.leave)
      if(this.leave) { 
        this.leaveSession() 
      }
    },
    audio: function(){
      if(this.publishCheck) {
        this.audioControll();
      }
    },
    video: function(){
      if(this.publishCheck) {
        this.videoControll();
      }
    },
    participants: function(){
      console.log('들어')
      console.log(useStore().state.participants)
      console.log(this.session)
    }
  },
  

};
</script>