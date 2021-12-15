<template>
  <div>
    <div id="nameOption">
      <label for="attendeeName">Attendee Name: </label>
      <input
        type="text"
        id="attendeeName"
        v-model.trim="filter.attendeeName"
        style="border: 2px solid #61a5c2"
      />
    </div>
    <form class="list">
      <attendeeEmail
        v-for="attendeeEmail in listOfAttendees"
        v-bind:key="attendeeEmail.attendeeName"
        v-bind:attendeeEmail="attendeeEmail"
      />
    </form>
    <form ref="form" @submit.prevent="sendEmail">
      <label>Name</label>
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
import AttendeeEmail from "@/components/AttendeeEmail.vue";
import attendeeService from "@/services/AttendeeService";
export default {
  data() {
    return {
      filteredAttendees: [],
      filter: {
        attendeeName: "",
      }, 
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
      if (this.filter.attendeeName != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => {
          return attendee.attendeeName
            .toLowerCase()
            .includes(this.filter.attendeeName.toLowerCase());
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