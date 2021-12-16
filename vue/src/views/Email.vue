<template>
  <div>
    <div id="nameOption">
      <label for="attendeeName">Attendee Name: </label>
      <input
        type="text"
        id="attendeeName"
        v-model.trim="attendeeName"
      
      />
    </div>
    <form class="list">
      <attendee-email
        v-for="attendee in listOfAttendees"
        v-bind:key="attendee.attendeeName"
        v-bind:attendee="attendee"
      />
    </form>



    <form class="emailForm" ref="form" @submit.prevent="sendEmail">
      <label>Attendee Name</label>
      <input type="text" name="to_name" />
      <label>Email</label>
      <input type="text" name="email" />
      <label>Message</label>
      <textarea name="message"></textarea>
      <input type="submit" value="Send" />
    </form>
  </div>
</template>
<script>
import emailjs from "emailjs-com";

import attendeeService from "@/services/AttendeeService";
import AttendeeEmail from '../components/AttendeeEmail.vue';
export default {
  data() {
    return {
      filteredAttendees: [],
      attendeeName: "",
     
    };
  },
  components: {
    AttendeeEmail,
  },
  computed: {
    listOfAttendees() {
      return this.filteredList();
    }
  },
  methods: {
    filteredList() {
      if (this.attendeeName != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => {
          return attendee.attendeeName
            .toLowerCase()
            .includes(this.attendeeName.toLowerCase());
        });
      }
      return this.filteredAttendees;
    },
 
    sendEmail() {
      emailjs
        .sendForm(
          "service_a7fmn4t",
          "template_sokuk4r",
          this.$refs.form,
          "user_ne4pAnNbl9FTIVznIo9rc"
        )
        .then(
          (result) => {
            console.log("SUCCESS!", result.text);
          },
          (error) => {
            console.log("FAILED...", error.text);
          }
        );
    },
  },

  created() {
    attendeeService
      .getAllAttendees()
      .then((response) => {
        this.filteredAttendees = response.data;
      })
      .catch((error) => {
        if (error.response) {
          this.errorMsg =
            "Error creating new board " +
            error.response.status +
            " " +
            error.response.statusText;
        } else if (error.request) {
          this.errorMsg = "Error connecting to Server";
        } else {
          this.errorMsg = "Some JavaScript error occurred";
        }
      });
  },
};
</script>

<style scoped>
.emailForm {
  border-radius: 10px;
  padding: 2px 2px 2px 2px;
  background: rgb(243, 243, 243);
  box-shadow: 0 0 0 2pt #346a82;
  height: 50%;
  cursor: pointer;
  margin-bottom: 2px;
}
</style>