<template>
  
  <div id="container">
		<div id="wrapper">
			<div id="join" class="animate join">
				<h1>Join a Room</h1>
				<form @submit.prevent="register" accept-charset="UTF-8">
					<p>
						<input type="text" name="name" value="" id="name"
							placeholder="Username" required>
					</p>
					<p>
						<input type="text" name="room" value="" id="roomName"
							placeholder="Room" required>
					</p>
					<p class="submit">
						<input type="submit" name="commit" value="Join!">
					</p>
				</form>
			</div>
			<div id="room" style="display: none;">
				<h2 id="room-header"></h2>
				<div id="participants"></div>
				<input type="button" id="button-leave" @mouseup="leaveRoom"
					value="Leave room">
			</div>
		</div>
	</div>
    
    <!-- <div id="app">
    유저이름: 
    <input
      v-model="userName"
      type="text"
    >
    내용: <input
      v-model="message"
      type="text"
      @keyup="sendMessage"
    >
    <div
      v-for="(item, idx) in recvList"
      :key="idx"
    >
      <h3>유저이름: {{ item.userName }}</h3>
      <h3>내용: {{ item.content }}</h3>
    </div>
  </div> -->
</template>

<script>
// import { kurentoUtils } from '../../node_modules/kurento-utils' 
// import Stomp from 'webstomp-client'
//  import SockJS from 'sockjs-client'
// export default {
//   name: 'RoomTest',
//   data() {
//     return {
//       userName: "",
//       message: "",
//       recvList: []
//     }
//   },
//   created() {
//     // App.vue가 생성되면 소켓 연결을 시도합니다.
//     this.connect()
//   },
//   methods: {
//     sendMessage (e) {
//       if(e.keyCode === 13 && this.userName !== '' && this.message !== ''){
//         this.send()
//         this.message = ''
//       }
//     },    
//     send() {
//       console.log("Send message:" + this.message);
//       if (this.stompClient && this.stompClient.connected) {
//         const msg = { 
//           userName: this.userName,
//           content: this.message 
//         };
//         this.stompClient.send("/receive", JSON.stringify(msg), {});
//       }
//     },    
//     connect() {
//       const serverURL = "https://localhost:5000/test"
//       let socket = new SockJS(serverURL);
//       this.stompClient = Stomp.over(socket);
//       console.log(`소켓 연결을 시도합니다. 서버 주소: ${serverURL}`)
//       this.stompClient.connect(
//         {},
//         frame => {
//           // 소켓 연결 성공
//           this.connected = true;
//           console.log('소켓 연결 성공', frame);
//           // 서버의 메시지 전송 endpoint를 구독합니다.
//           // 이런형태를 pub sub 구조라고 합니다.
//           this.stompClient.subscribe("/send", res => {
//             console.log('구독으로 받은 메시지 입니다.', res.body);

//             // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
//             this.recvList.push(JSON.parse(res.body))
//           });
//         },
//         error => {
//           // 소켓 연결 실패
//           console.log('소켓 연결 실패', error);
//           this.connected = false;
//         }
//       );        
//     }
//   }
// }

var kurentoUtils = require('kurento-utils');

var ws = new WebSocket('wss://localhost:5000/groupcall')
var name = ''
var participants = []

ws.onmessage = function(message) {
    var parsedMessage = JSON.parse(message.data);
    console.info('Received message: ' + message.data);

    switch (parsedMessage.id) {
        case 'existingParticipants':
            onExistingParticipants(parsedMessage);
            break;
        case 'newParticipantArrived':
            onNewParticipant(parsedMessage);
            break;
        case 'participantLeft':
            onParticipantLeft(parsedMessage);
            break;
        case 'receiveVideoAnswer':
            receiveVideoResponse(parsedMessage);
            break;
        case 'iceCandidate':
            participants[parsedMessage.name].rtcPeer.addIceCandidate(parsedMessage.candidate, function (error) {
                if (error) {
                console.error("Error adding candidate: " + error);
                return;
                }
            });
            break;
        default:
            console.error('Unrecognized message', parsedMessage);
    }
}
function onExistingParticipants(msg) {
    var constraints = {
        audio : true,
        video : {
            mandatory : {
                maxWidth : 320,
                maxFrameRate : 15,
                minFrameRate : 15
            }
        }
    }
    var participant = new Participant(name);
    participants[name] = participant;
    var video = participant.getVideoElement();

    var options = {
        localVideo: video,
        mediaConstraints: constraints,
        onicecandidate: participant.onIceCandidate.bind(participant)
        }
    participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerSendonly(options,
        function (error) {
        if(error) {
            return console.error(error);
        }
        this.generateOffer (participant.offerToReceiveVideo.bind(participant));
    });

    msg.data.forEach(receiveVideo);
}
function Participant(param) {
    name = param;
    var container = document.createElement('div');
    container.className = isPresentMainParticipant() ? PARTICIPANT_CLASS : PARTICIPANT_MAIN_CLASS;
    container.id = name;
    var span = document.createElement('span');
    var video = document.createElement('video');
    var rtcPeer; // eslint-disable-line no-unused-vars

    container.appendChild(video);
    container.appendChild(span);
    container.onclick = switchContainerClass;
    document.getElementById('participants').appendChild(container);

    span.appendChild(document.createTextNode(name));

    video.id = 'video-' + name;
    video.autoplay = true;
    video.controls = false;


    this.getElement = function() {
        return container;
    }

    this.getVideoElement = function() {
        return video;
    }

    function switchContainerClass() {
        if (container.className === PARTICIPANT_CLASS) {
            var elements = Array.prototype.slice.call(document.getElementsByClassName(PARTICIPANT_MAIN_CLASS));
            elements.forEach(function(item) {
                    item.className = PARTICIPANT_CLASS;
                });

                container.className = PARTICIPANT_MAIN_CLASS;
            } else {
            container.className = PARTICIPANT_CLASS;
        }
    }

    function isPresentMainParticipant() {
        return ((document.getElementsByClassName(PARTICIPANT_MAIN_CLASS)).length != 0);
    }

    this.offerToReceiveVideo = function(error, offerSdp, wp){// eslint-disable-line no-unused-vars
        if (error) return console.error ("sdp offer error")
        console.log('Invoking SDP offer callback function');
        var msg =  { id : "receiveVideoFrom",
                sender : name,
                sdpOffer : offerSdp
            };
        sendMessage(msg);
    }


    this.onIceCandidate = function (candidate, wp) {// eslint-disable-line no-unused-vars
        console.log("Local candidate" + JSON.stringify(candidate));

        var message = {
            id: 'onIceCandidate',
            candidate: candidate,
            name: name
        };
        sendMessage(message);
    }

    Object.defineProperty(this, 'rtcPeer', { writable: true});

    this.dispose = function() {
        console.log('Disposing participant ' + this.name);
        this.rtcPeer.dispose();
        container.parentNode.removeChild(container);
    };
}
       

function receiveVideo(sender) {
    var participant = new Participant(sender);
    participants[sender] = participant;
    var video = participant.getVideoElement();

    var options = {
    remoteVideo: video,
    onicecandidate: participant.onIceCandidate.bind(participant)
    }

    participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerRecvonly(options,
            function (error) {
            if(error) {
                return console.error(error);
            }
            this.generateOffer (participant.offerToReceiveVideo.bind(participant));
    });
}
function onParticipantLeft(request) {
    console.log('Participant ' + request.name + ' left');
    var participant = participants[request.name];
    participant.dispose();
    delete participants[request.name];
}

function sendMessage(message) {
    var jsonMessage = JSON.stringify(message);
    console.log('Sending message: ' + jsonMessage);
    ws.send(jsonMessage);
}
function onNewParticipant(request) {
    receiveVideo(request.name);
}

function receiveVideoResponse(result) {
    participants[result.name].rtcPeer.processAnswer (result.sdpAnswer, function (error) {
        if (error) return console.error (error);
    });
}
// function callResponse(message) {
//     if (message.response != 'accepted') {
//         console.info('Call not accepted by peer. Closing call');
//         stop();
//     } else {
//         webRtcPeer.processAnswer(message.sdpAnswer, function (error) {
//             if (error) return console.error (error);
//         });
//     }
// }
const PARTICIPANT_MAIN_CLASS = 'participant main';
const PARTICIPANT_CLASS = 'participant';

export default { 
    name: "RoomTest",
    setup(){
       
    },
    mounted(){
        window.addEventListener('beforeunload', this.unLoadEvent);
        
    },
    methods: {
        unLoadEvent: function(){
            //ws.close;
        },
        register: function(){
            name = document.getElementById('name').value;
            var room = document.getElementById('roomName').value;

            document.getElementById('room-header').innerText = 'ROOM ' + room;
            document.getElementById('join').style.display = 'none';
            document.getElementById('room').style.display = 'block';

            var message = {
                id : 'joinRoom',
                name : name,
                room : room,
            }
            sendMessage(message);
        },
        leaveRoom: function() {
            sendMessage({
                id : 'leaveRoom'
            });

            for ( var key in participants) {
                participants[key].dispose();
            }

            document.getElementById('join').style.display = 'block';
            document.getElementById('room').style.display = 'none';

            ws.close();
        },
        
    }
}
</script>

<style>

</style>