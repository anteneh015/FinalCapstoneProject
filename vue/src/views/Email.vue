<template>
  <v-container bg fill-height grid-list-md text-xs-center>
    <v-row align="center" justify="center">
      <v-card class="elevation-12">
        <v-card-text>
          <v-form>
            <v-text-field
              label="Search for attendee:"
              name="login"
              prepend-icon="mdi-robot-outline"
              type="text"
              v-model.trim="attendeeName"
            ></v-text-field>
          </v-form>
          <v-spacer></v-spacer>
          <form class="emailForm" ref="form" @submit.prevent="sendEmail">
            <label>Guardian Name:</label>
            <input class="input" type="text" name="to_name" />
            <label>Email: </label>
            <input class="input" type="text" name="email" />
            <label>Message: </label>
            <textarea name="message"></textarea>
            <input class="input" type="submit" value="Send" />
          </form>
          <v-spacer></v-spacer>
          <v-form>
            <attendee-email
              v-for="attendee in listOfAttendees"
              v-bind:key="attendee.attendeeName"
              v-bind:attendee="attendee"
            />
          </v-form>
        </v-card-text>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
import emailjs from "emailjs-com";
import attendeeService from "@/services/AttendeeService";
import AttendeeEmail from "../components/AttendeeEmail.vue";
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
    },
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
.emailForm,
.input {
  border-radius: 10px;
  padding: 2px 2px 2px 2px;
  background: rgb(243, 243, 243);
  box-shadow: 0 0 0 2pt #346a82;
  height: 50%;
  cursor: pointer;
  margin-bottom: 2px;
}
</style>