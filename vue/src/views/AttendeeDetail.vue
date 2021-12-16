<template>

  <v-card class="fill-height" fluid>
    <!-- <v-snackbar v-model="snackbar" :timeout="4000" top color="success">
      <span class="font-weight-bold">Edit successfully</span>
      <v-btn class="mx-4" text color="white" @click="snackbar=false">Exit</v-btn>
    </v-snackbar> -->

    <v-card-title class="headline blue lighten-2">Edit Attendee</v-card-title><br>

    <v-card-text  justify="center" >
      <v-img v-bind:src="attendee.imgURL" max-height="250" max-width="150"> </v-img><br>
      <v-form class="px-3" >
        <v-row>
          <v-text-field v-model="attendee.attendeeName" label="Attendee Name"></v-text-field>&nbsp;
          <v-text-field v-model="attendee.dateOfBirth" label="Date of Birth"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.gender" label="Gender"></v-text-field>&nbsp;
          <v-text-field v-model="attendee.ageGroup" label="Age Group"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.registrar" label="Registrar"></v-text-field>&nbsp;
          <v-text-field v-if="attendee.paymentStatus" v-model="paid" label="Payment Status"></v-text-field>
          <v-text-field v-if="!attendee.paymentStatus" v-model="unpaid" label="Payment Status"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.guardianName" label="Guardian Name"></v-text-field>&nbsp;
          <v-text-field v-model="attendee.guardianPhone" label="Guardian Phone"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.email" label="Email"></v-text-field>&nbsp;
          <v-text-field v-model="attendee.dormName" label="Dorm Name"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.address" label="Address"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.emgcyName" label="Emgcy Name"></v-text-field>&nbsp;
          <v-text-field v-model="attendee.emgcyPhone" label="Emgcy Phone"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.notes" label="Notes"></v-text-field>
        </v-row>

         <v-row justify="center">
        
          <v-file-input v-model="file" label="Load Attendee Picture Here" accept=".jpg"></v-file-input>&nbsp;
          <v-btn color="primary" @click="uploadImage">Upload Image</v-btn>
        
      </v-row>

      

        <v-row justify="center">
          <v-btn class="success mx-4" @click="submit">SUBMIT</v-btn>&nbsp;
          <v-btn class="blue mx-4" @click="cancel">CANCEL</v-btn>
        </v-row>

      </v-form>
    </v-card-text>

  </v-card>
</template>

<script>
 import attendeeService from "@/services/AttendeeService";

import { initializeApp } from "firebase/app";
import { getStorage, ref, uploadBytes, getDownloadURL} from "firebase/storage";

const firebaseConfig = {
apiKey: "AIzaSyDxqaJhYgSwVa23CFLTK547oKV0JHjA4s8",
authDomain: "robotic-echo-portal.firebaseapp.com",
projectId: "robotic-echo-portal",
storageBucket: "robotic-echo-portal.appspot.com",
messagingSenderId: "607406800952",
appId: "1:607406800952:web:98c4ff5033790aacdaa6cd",
measurementId: "G-NJ73GLB58Z"
};
const app = initializeApp(firebaseConfig);
const storage = getStorage(app);

export default {
  // props:["attendee"],
  data() {
    return {
      id: 0,
      paid: "Paid",
      unpaid: "Unpaid",
      errorMsg: '',
      file: ""
    };
  },
  created() {
    this.id = this.$route.params.id;
  },
  computed: {
    attendee() {
      const attendeeArr = this.$store.state.attendees.filter((attendee) => {
        return attendee.attendeeId === this.id;
      });
      return attendeeArr[0];
    },
  },
  methods: {
    paidOrUnpaid() {
      if (this.newAttendee.paymentStatus === "paid") {
        return "Paid";
      } else {
        return "Unpaid";
      }
    },
    uploadImage(){
  
        const storageRef = ref(storage, this.file.name)
        console.log(this.file.name)
        uploadBytes(storageRef, this.file)
        .then(snapshot =>{
            console.log(snapshot)

          getDownloadURL(ref(storage, this.file.name))
            .then((url) =>{
              this.attendee.imgURL = url;
              console.log("DONE" + url)
            })
        })
    },
    cancel() {
      this.$router.push({
        name: "attendees",
      });
    },
    submit() {
      attendeeService
        .updateAttendee(this.attendee)
        .then((response) => {
          if (response.status === 200) {
            alert("Your update was successful");
            this.$store.commit("UPDATE_ATTENDEE", this.attendee);
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error creating new board " +
              error.response.status +
              " " +
              error.response.statusText;
          }
          else if (error.request) {
            this.errorMsg = "Error connecting to Server";
          }
          else {
            this.errorMsg = "Some JavaScript error occurred";
          }
        });
      this.$router.push({
        name: "attendees",
      });
    },
    // snackbarSubmit() {
    //   this.snackbar = true;
    //   setTimeout(() => {
    //     this.snackbar = false;
    //     this.$router.push({ name: "attendees" });
    //   }, 4000);
    // },
  },
};
</script>

<style>
</style>