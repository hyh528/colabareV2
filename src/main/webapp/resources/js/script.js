//Create an account on Firebase, and use the credentials they give you in place of the following
var firebaseConfig = {
  apiKey: 'AIzaSyA4jZaDh8SpWzgYUnLnEeKrbcSuyeVh-sE',
  authDomain: 'cottrang-2bc85.firebaseapp.com',
  databaseURL: 'https://cottrang-2bc85.firebaseio.com',
  projectId: 'cottrang-2bc85',
  storageBucket: 'cottrang-2bc85.appspot.com',
  messagingSenderId: '705248494993',
  appId: '1:705248494993:web:56d7e424c0562a94b38630',
  measurementId: 'G-C6ZMDWES31'
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

var database = firebase.database().ref();
var yourVideo = document.getElementById('yourVideo');
var friendsVideo = document.getElementById('friendsVideo');
var yourId = Math.floor(Math.random() * 1000000000);
//Create an account on Viagenie (http://numb.viagenie.ca/), and replace {'urls': 'turn:numb.viagenie.ca','credential': 'websitebeaver','username': 'websitebeaver@email.com'} with the information from your account
var servers = {
  iceServers: [
    { urls: 'stun:stun.services.mozilla.com' },
    { urls: 'stun:stun.l.google.com:19302' },
    {
      urls: 'turn:numb.viagenie.ca',
      credential: 'dudgus12',
      username: 'hah_528@naver.com'
    }
  ]
};
var pc = new RTCPeerConnection(servers);
pc.onicecandidate = event =>
  event.candidate
    ? sendMessage(yourId, JSON.stringify({ ice: event.candidate }))
    : console.log('Sent All Ice');
pc.onaddstream = event => (friendsVideo.srcObject = event.stream);

function sendMessage(senderId, data) {
  var msg = database.push({ sender: senderId, message: data });
  msg.remove();
}

function readMessage(data) {
  var msg = JSON.parse(data.val().message);
  var sender = data.val().sender;
  if (sender != yourId) {
    if (msg.ice != undefined) pc.addIceCandidate(new RTCIceCandidate(msg.ice));
    else if (msg.sdp.type == 'offer')
      pc.setRemoteDescription(new RTCSessionDescription(msg.sdp))
        .then(() => pc.createAnswer())
        .then(answer => pc.setLocalDescription(answer))
        .then(() =>
          sendMessage(yourId, JSON.stringify({ sdp: pc.localDescription }))
        );
    else if (msg.sdp.type == 'answer')
      pc.setRemoteDescription(new RTCSessionDescription(msg.sdp));
  }
}

database.on('child_added', readMessage);

function showMyFace() {
  navigator.mediaDevices
    .getUserMedia({ audio: true, video: true })
    .then(stream => (yourVideo.srcObject = stream))
    .then(stream => pc.addStream(stream));
}

function showFriendsFace() {
  pc.createOffer()
    .then(offer => pc.setLocalDescription(offer))
    .then(() =>
      sendMessage(yourId, JSON.stringify({ sdp: pc.localDescription }))
    );
}