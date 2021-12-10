<template v-slot:activator="{ on: editsCamper }">
  <!-- <div class="attendeeDetail">
    <h1>Detail for id {{ id }}</h1>
     <attendee
      v-for="attendee in attendeeList"
      v-bind:key="attendee.attendeeId"
      v-bind:attendee="attendee"
    /> 
    <h2>{{ attendeeList }}</h2> 
    <v-dialog v-model="dialog" width="700" :camper="camper"> 
      <template v-slot:activator="{ on: editsCamper }">
        <v-btn
          text
          color="red lighten-2"
          dark
          small
          v-on="editsCamper"
          @click="editCamper(camper)"
          >Edit Camper</v-btn
        >
      </template>-->
  <v-card>
    <v-card-title class="headline blue lighten-2">Edit Attendee</v-card-title>
    <v-card-text>
      <v-form class="px-3">
        <v-row>
          <v-text-field
            v-model="attendee.attendeeName"
            v-on:change="(event) => changeHandler(0, 'attendeeName', event)"
            label="Attendee Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.dateOfBirth"
            v-on:change="(event) => changeHandler(1, 'dateOfBirth', event)"
            label="Date of Birth"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.gender"
            v-on:change="(event) => changeHandler(2, 'gender', event)"
            label="Gender"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.ageGroup"
            v-on:change="(event) => changeHandler(3, 'ageGroup', event)"
            label="Age Group"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.registrar"
            v-on:change="(event) => changeHandler(4, 'registrar', event)"
            label="Registrar"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-if="attendee.paymentStatus"
            v-model="paid"
            v-on:change="(event) => changeHandler(5, 'paymentStatus', event)"
            label="Payment Status"
          ></v-text-field>
          <v-text-field
            v-if="!attendee.paymentStatus"
            v-model="unpaid"
            v-on:change="(event) => changeHandler(5, 'paymentStatus', event)"
            label="Payment Status"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.guardianName"
            v-on:change="(event) => changeHandler(6, 'guardianName', event)"
            label="Guardian Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.guardianPhone"
            v-on:change="(event) => changeHandler(7, 'guardianPhone', event)"
            label="Guardian Phone"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.email"
            v-on:change="(event) => changeHandler(8, 'email', event)"
            label="Email"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.address"
            v-on:change="(event) => changeHandler(9, 'address', event)"
            label="Address"
          ></v-text-field>
        </v-row>

        <v-row>
          &nbsp;
          <v-text-field
            v-model="attendee.emgcyName"
            v-on:change="(event) => changeHandler(10, 'emgcyName', event)"
            label="Emgcy Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.emgcyPhone"
            v-on:change="(event) => changeHandler(11, 'emgcyPhone', event)"
            label="Emgcy Phone"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.notes"
            v-on:change="(event) => changeHandler(12, 'notes', event)"
            label="Notes"
          ></v-text-field>
        </v-row>

        <v-row justify="center">
          <v-btn
            class="success my-4"
            @click="submit(), changesToCamper()"
            >SUBMIT</v-btn
          >
        </v-row>
      </v-form>
    </v-card-text>
  </v-card>
  <!-- </v-dialog>
  </div> -->
</template>

<script>
//import Attendee from "../components/Attendee.vue";
import attendeeService from "@/services/AttendeeService";

export default {
  
  //components: { Attendee },
  data() {
    return {
      id: 0,
      paid: "Paid",
      unpaid: "Unpaid",
      oldAttendee: "",
      newAttendee: "",
      changesMade: [
        { attendeeName: "" },
        { dateOfBirth: "" },
        { gender: "" },
        { ageGroup: "" },
        { registrar: "" },
        { paymentStatus: "" },
        { guardianName: "" },
        { guardianPhone: "" },
        { email: "" },
        { address: "" },
        { emgcyName: "" },
        { emgcyPhone: "" },
        { notes: "" },
      ],
      attendee: {},
    };
  },
  created() {
    this.id = this.$route.params.id;
  },
  computed: {
    attendeeToEdit() {
      return this.$store.state.attendees.filter((attendee) => {
        return attendee.attendeeId === this.id;
      });
    },
  },
  methods: {
    getAttendee() {
      this.attendee = this.attendeeToEdit();
    },
    changeHandler(index, propertyName, event) {
      let propertyToBeChanged = this.changesMade[index];
      propertyToBeChanged[propertyName] = event;
    },
    paidOrUnpaid() {
      if (this.newAttendee.paymentStatus === 'paid') {
        return "Paid";
      } else {
        return "Unpaid";
      }
   },
   submit() {
     
      // Submit this editedCamper to the API using a PUT
      attendeeService.updateAttendee(this.newAttendee);
      //commit to store
      this.$store.commit("UPDATE_ATTENDEE", this.changesMade);
      //take the page back to /attendees
      this.$router.push({
        name: 'attendees'
      })
   },
  },
};
</script>

<style>
</style>