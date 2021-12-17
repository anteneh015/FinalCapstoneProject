<template>
  <form class="attendeeList">
    <form id="searchMenu">
      <div id="nameOption">
        <label for="attendeeName">Attendee Name: </label>
        <input
          type="text"
          id="attendeeName"
          v-model.trim="filter.attendeeName"
          style="border: 2px solid #61a5c2"
        />
      </div>

      <div id="groupOption">
        <label for="ageGroup">Age Group: </label>
        <select
          id="ageGroup"
          v-model="filter.ageGroup"
          style="border: 2px solid #61a5c2"
        >
          <option value="">All</option>
          <option>1</option>
          <option>2</option>
          <option>3</option>
        </select>
      </div>
      <div id="paymentOption">
        <label for="payment">Payment Status: </label>
        <select
          id="payment"
          v-model="filter.paymentStatus"
          style="border: 2px solid #61a5c2"
        >
          <option value="">All</option>
          <option>recieved</option>
          <option>unpaid</option>
        </select>
      </div>

      <div id="registrarOption">
        <label for="registrar">Assigned Registrar: </label>
        <select
          id="registrar"
          v-model="filter.registrar"
          style="border: 2px solid #61a5c2"
        >
          <option value="">All</option>
          <option>Dora</option>
          <option>Mike</option>
        </select>
      </div>
    </form>

    <form class="list">
      <attendee
        v-for="attendee in listOfAttendees"
        v-bind:key="attendee.attendeeId"
        v-bind:attendee="attendee"
      />
    </form>
  </form>
</template>

<script>
import Attendee from "@/components/Attendee.vue";
import attendeeService from "@/services/AttendeeService";
export default {
  name: "attendee-list",
  data() {
    return {
      errorMsg: "",
      attendees: [],
      filter: {
        paymentStatus: "",
        registrar: "",
        attendeeName: "",
        ageGroup: "",
      },
    };
  },
  components: {
    Attendee,
  },
  computed: {
    listOfAttendees() {
      return this.filteredList();
    },
  },
  methods: {
    filteredList() {
      return this.attendees.filter((attendee) => {
        if (this.filter.ageGroup) {
          return (
            attendee.paymentStatus
              .toLowerCase()
              .includes(this.filter.paymentStatus.toLowerCase()) &&
            attendee.registrar
              .toLowerCase()
              .includes(this.filter.registrar.toLowerCase()) &&
            attendee.attendeeName
              .toLowerCase()
              .includes(this.filter.attendeeName.toLowerCase()) &&
            attendee.ageGroup == this.filter.ageGroup
          );
        } else {
          return (
            attendee.paymentStatus
              .toLowerCase()
              .includes(this.filter.paymentStatus.toLowerCase()) &&
            attendee.registrar
              .toLowerCase()
              .includes(this.filter.registrar.toLowerCase()) &&
            attendee.attendeeName
              .toLowerCase()
              .includes(this.filter.attendeeName.toLowerCase())
          );
        }
      });
    },
  },

  created() {
    attendeeService
      .getAllAttendees()
      .then((response) => {
        this.attendees = response.data;
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
#searchMenu {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
#payment,
#registrar,
#attendeeName,
#ageGroup {
  border-radius: 7px;
}

/* .attendeeList {
  border: solid 2px #0f1457!important;
  border-radius: 15px;
} */
</style>