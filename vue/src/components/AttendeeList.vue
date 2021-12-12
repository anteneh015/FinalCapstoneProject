<template>
  <div class="attendeeList">
    <form id= "searchMenu">
     <div id = "paymentOption">
      <label for="payment">Payment Status: </label>
      <select id="payment" v-model="filter.paymentStatus">
        <option value="">All</option>
        <option>paid</option>
        <option>unpaid</option>
      </select>
     </div>
     <div id = "registrarOption">
      <label for="registrar">Assigned Registrar: </label>
      <select id="registrar" v-model="filter.registrar">
        <option value="">All</option>
        <option>Dora</option>
        <option>Mike</option>
      </select>
     </div>
     <div id= "nameOption">
      <label for="attendeeName">Attendee Name: </label> 
      <input type="text" name="attendeeName" v-model.trim="filter.attendeeName"  />
     </div>
     <div id = "groupOption">
      <label for="ageGroup">Age Group: </label>
      <select id="ageGroup" v-model="filter.ageGroup">
        <option value="">All</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
     </div>
    </form>

    <attendee
      v-for="attendee in filteredList"
      v-bind:key="attendee.attendeeId"
      v-bind:attendee="attendee"
    />
  </div>
</template>

<script>

import Attendee from "@/components/Attendee.vue";

export default {
  name: "attendee-list",
  data() {
    return {
      errorMsg: "",
      filter: {
        paymentStatus: "",
        registrar: "",
        attendeeName: "",
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
         return attendee.paymentStatus == (this.filter.paymentStatus);
        });
      }
      if (this.filter.registrar != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => { 
         return attendee.registrar == (this.filter.registrar);
        });
      }
      if (this.filter.attendeeName != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
         return attendee.attendeeName
            .toLowerCase()
            .includes(this.filter.attendeeName.toLowerCase());
        });
      }
      if (this.filter.ageGroup != "") {
        filteredAttendees = filteredAttendees.filter((attendee) => {
         return attendee.ageGroup == (this.filter.ageGroup);
        });
      }
      return filteredAttendees;
    }
  },
};
</script>

<style>
#searchMenu{
  display: flex;
  justify-content: space-around
}

</style>