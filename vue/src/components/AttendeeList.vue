<template>
  <div class="attendeeList">
    <form id= "searchMenu">
     <div id = "paymentOption">
      <label for="payment">Payment Status: </label>
      <select id="payment" v-model="filter.paymentStatus" style="border: 2px solid #61A5c2;">
        <option value="">All</option>
        <option>paid</option>
        <option>unpaid</option>
      </select>
     </div>
     <div id = "registrarOption">
      <label for="registrar">Assigned Registrar: </label>
      <select id="registrar" v-model="filter.registrar" style="border: 2px solid #61A5c2; ">
        <option value="">All</option>
        <option>Dora</option>
        <option>Mike</option>
      </select>
     </div>
     <div id= "nameOption">
      <label for="attendeeName">Attendee Name: </label> 
      <input type="text" id="attendeeName" v-model.trim="filter.attendeeName" style="border: 2px solid #61A5c2;" />
     </div>
     <div id = "groupOption">
      <label for="ageGroup">Age Group: </label>
      <select id="ageGroup" v-model="filter.ageGroup" style="border: 2px solid #61A5c2;">
        <option value="">All</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
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
  </div>
</template>

<script>

import Attendee from "@/components/Attendee.vue";
import attendeeService from "@/services/AttendeeService";
export default {
  name: "attendee-list",
  data() {
    return {
      errorMsg: "",
      filteredAttendees: [],
      filter: {
        paymentStatus: "",
        registrar: "",
        attendeeName: "",
        ageGroup: ""
      }, 
    };
  },
  components: {
    Attendee,
  },
  methods: {
    filteredList() {
     
      if (this.filter.paymentStatus != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => {
         return attendee.paymentStatus == (this.filter.paymentStatus);
        });
      }
      if (this.filter.registrar != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => { 
         return attendee.registrar == (this.filter.registrar);
        });
      }
      if (this.filter.attendeeName != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => {
         return attendee.attendeeName
            .toLowerCase()
            .includes(this.filter.attendeeName.toLowerCase());
        });
      }
      if (this.filter.ageGroup != "") {
        this.filteredAttendees = this.filteredAttendees.filter((attendee) => {
         return attendee.ageGroup == (this.filter.ageGroup);
        });
      }
      return this.filteredAttendees;
    }
  },
  computed: {
    listOfAttendees(){
      return this.filteredList();
    }
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
      }
      else if (error.request) {
        this.errorMsg = "Error connecting to Server";
      }
      else {
        this.errorMsg = "Some JavaScript error occurred";
      }
    });
  },
};
</script>

<style scoped>
#searchMenu{
  display: flex;
  flex-direction: row;
  justify-content: space-around
  
}
#payment, #registrar, #attendeeName, #ageGroup {
border-radius: 10px;
}

</style>