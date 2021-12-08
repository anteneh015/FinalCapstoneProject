<template>
  <div class="attendeeList">
    <form>
      <label for="payment">Payment Status</label>
      <select id="payment" v-model="filter.paymentStatus">
        <option disabled value="">Please select one</option>
        <option>paid</option>
        <option>unpaid</option>
      </select>
      <label for="registrar">Assigned Registrar</label>
      <select id="registrar" v-model="filter.registrar">
        <option disabled value="">Please select one</option>
        <option>Dora</option>
        <option>Mike</option>
      </select>
      <label for="attendeeName">Attendee Name</label>
      <input type="text" name="attendeeName" v-model="filter.attendeeName" />
      <label for="ageGroup">Age Group</label>
      <select id="ageGroup" v-model="filter.ageGroup">
        <option disabled value="">Please select one</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
    </form>

    <attendee
      v-for="attendee in filteredList"
      v-bind:key="attendee.attendeeId"
      v-bind:attendee="attendee"
    />
  </div>
</template>

<script>
import attendeeService from "@/services/AttendeeService";
import Attendee from "@/components/Attendee.vue";

export default {
  name: "attendee-list",
  data() {
    return {
      errorMsg: "",
      filter: {
        paymentStatus: "",
        registrar: "",
        atteneeName: "",
        ageGroup: ""
      }
    };
  },
  components: {
    Attendee,
  },
  computed: {
    filteredList() {
      let filteredAttendees = this.$store.state.attendees;
      if (this.filter.paymentStatus != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
          attendee.paymentStatus.includes(this.filter.paymentStatus);
        });
      }
      if (this.filter.registrar != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
          attendee.registrar.includes(this.filter.registrar);
        });
      }
      if (this.filter.atteneeName != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
          attendee.atteneeName
            .toLowerCase()
            .includes(this.filter.attendeName.toLowerCase());
        });
      }
      if (this.filter.atteneeName != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
          attendee.atteneeName
            .toLowerCase()
            .includes(this.filter.attendeName.toLowerCase());
        });
      }
      if (this.filter.ageGroup != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
          attendee.ageGroup.includes(this.filter.ageGroup);
        });
      }
      return filteredAttendees;
    }
  },

  created() {
    attendeeService
      .getAllAttendees()
      .then((response) => {
        this.$store.commit("SET_ATTENDEES", response.data);
      })
      .catch((error) => {
        // TODO: Inform the user there was an error
        if (error.response) {
          this.errorMsg =
            "Error creating new board " +
            error.response.status +
            " " +
            error.response.statusText;
        }
        // Handle connection errors
        else if (error.request) {
          this.errorMsg = "Error connecting to Server";
        }
        // Handle JS runtime errors
        else {
          this.errorMsg = "Some JavaScript error occurred";
        }
      });
  },
};
</script>

<style>
</style>