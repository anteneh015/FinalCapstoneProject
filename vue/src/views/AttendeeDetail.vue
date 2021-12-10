<template v-slot:activator="{ on: editsCamper }">
  <!-- <div class="attendeeDetail">
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
                v-on:change="(event) => changeHandler(0, 'attendeeName', event)"
                  v-on:change="(event) => changeHandler(1, 'dateOfBirth', event)"
                    v-on:change="(event) => changeHandler(2, 'gender', event)"
                         v-on:change="(event) => changeHandler(3, 'ageGroup', event)"
                            v-on:change="(event) => changeHandler(4, 'registrar', event)"
                                    v-on:change="(event) => changeHandler(5, 'paymentStatus', event)"
                                        v-on:change="(event) => changeHandler(5, 'paymentStatus', event)"
                                               v-on:change="(event) => changeHandler(6, 'guardianName', event)"
                                                   v-on:change="(event) => changeHandler(7, 'guardianPhone', event)"
                                                          v-on:change="(event) => changeHandler(8, 'email', event)"
                                                              v-on:change="(event) => changeHandler(9, 'address', event)"
                                                                    v-on:change="(event) => changeHandler(10, 'emgcyName', event)"
                                                                          v-on:change="(event) => changeHandler(11, 'emgcyPhone', event)"
                                                                           v-on:change="(event) => changeHandler(12, 'notes', event)"
       :rules="rules"
            counter="25"
            </template>-->

  <v-card>
    <v-card-title class="headline blue lighten-2">Edit Attendee</v-card-title>
    <v-card-text>
      <v-form class="px-3">
        <v-row>
          <v-text-field
            v-model="attendee.attendeeName"
            label="Attendee Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.dateOfBirth"
            label="Date of Birth"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.gender" label="Gender"></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.ageGroup"
            label="Age Group"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.registrar"
            label="Registrar"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-if="attendee.paymentStatus"
            v-model="paid"
            label="Payment Status"
          ></v-text-field>
          <v-text-field
            v-if="!attendee.paymentStatus"
            v-model="unpaid"
            label="Payment Status"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.guardianName"
            label="Guardian Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.guardianPhone"
            label="Guardian Phone"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.email" label="Email"></v-text-field>
        </v-row>

        <v-row>
          <v-text-field
            v-model="attendee.address"
            label="Address"
          ></v-text-field>
        </v-row>

        <v-row>
          &nbsp;
          <v-text-field
            v-model="attendee.emgcyName"
            label="Emgcy Name"
          ></v-text-field
          >&nbsp;
          <v-text-field
            v-model="attendee.emgcyPhone"
            label="Emgcy Phone"
          ></v-text-field>
        </v-row>

        <v-row>
          <v-text-field v-model="attendee.notes" label="Notes"></v-text-field>
        </v-row>

        <v-row justify="center">
          <v-btn class="success my-4" @click="submit">SUBMIT</v-btn>
          &nbsp;<v-btn class="success my-4" @click="cancel">CANCEL</v-btn>
        </v-row>
      </v-form>
    </v-card-text>
  </v-card>
  <!-- </v-dialog>
  </div> -->
</template>

<script>
import attendeeService from "@/services/AttendeeService";

export default {
  data() {
    return {
      id: 0,
      paid: "Paid",
      unpaid: "Unpaid",
      errorMsg: ''
      // oldAttendee: "",
      // newAttendee: "",
      // editInfo: [
      //   { attendeeName: "" },
      //   { dateOfBirth: "" },
      //   { gender: "" },
      //   { ageGroup: "" },
      //   { registrar: "" },
      //   { paymentStatus: "" },
      //   { guardianName: "" },
      //   { guardianPhone: "" },
      //   { email: "" },
      //   { address: "" },
      //   { emgcyName: "" },
      //   { emgcyPhone: "" },
      //   { notes: "" },
      // ],
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
    //   changeHandler(index, propertyName, event) {
    //     let propertyToBeChanged = this.editInfo[index];
    //     propertyToBeChanged[propertyName] = event;
    //   },
    paidOrUnpaid() {
      if (this.newAttendee.paymentStatus === "paid") {
        return "Paid";
      } else {
        return "Unpaid";
      }
    },
    cancel() {
      this.$router.push({
        name: "attendees",
      });
    },
    submit() {
      // Submit this editedCamper to the API using a PUT
      attendeeService
        .updateAttendee(this.attendee)
        .then((response) => {
          if (response.status === 200) {
            alert("Your update was successful");
            this.$store.commit("UPDATE_ATTENDEE", this.attendee);
          }
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

      this.$router.push({
        name: "attendees",
      });
    },
  },
};
</script>

<style>
</style>