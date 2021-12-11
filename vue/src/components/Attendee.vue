<template>
  <div class="attendee">
    <v-container fluid class="my-10 mx-16">
      <v-row no-gutters>
        <v-col cols="12" sm="4" md="2">
          <div class="caption blue--text">Name</div>
          <div>{{ attendee.attendeeName }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="2">
          <div class="caption blue--text">Date Of Birth</div>
          <div>{{ attendee.dateOfBirth }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="2">
          <div class="caption blue--text">Gender</div>
          <div>{{ attendee.gender }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="2">
          <div class="caption blue--text">Age Group</div>
          <div>{{ attendee.ageGroup }}</div>
        </v-col>

        <v-col cols="2" sm="4" md="2">
          <div class="caption blue--text">Payment Status</div>
          <div class="right">
            <v-chip
              small
              :color="`${
                attendee.paymentStatus == 'paid' ? '#9A031E' : '#61A5c2'}`"
              class="white--text caption my-2"
              >{{ attendee.paymentStatus == 'unpaid' ? "Paid" : "Unpaid" }}
            </v-chip>
          </div>
        </v-col>

        <!-- <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Registrar</div>
          <div>{{ attendee.registrar }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Guardian Name</div>
          <div>{{ attendee.guardianName }}</div>
        </v-col>
        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Phone Number</div>
          <div>{{ attendee.guardianPhone }}</div>
        </v-col>
        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Email</div>
          <div>{{ attendee.email }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Address</div>
          <div>{{ attendee.address }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Emgcy Name</div>
          <div>{{ attendee.emgcyName }}</div>
        </v-col>

          <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Emgcy Phone</div>
          <div>{{ attendee.emgcyPhone }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Notes</div>
          <p>
            <span v-if="!attendee.notes" class="body-2"
              >No notes added</span
            >
            <span class="body-2">{{ attendee.notes }}</span>
          </p>
        </v-col> -->
        <!-- <v-col cols="12" sm="4" md="1">
          <Popup
            :camper="camper"
            @camperEdited="snackbar = true"
            @camperUpdated="camperUpdated = true"
          />
        </v-col> -->
         <v-col cols="12" sm="4" md="1">
            <div class="text-center">
    <v-chip
      class="ma-2"
      color="#61A5c2"
      text-color="black"
    >
      <router-link :to ="{ name: 'attendee', params:{id: attendee.attendeeId}}">Details</router-link>
    </v-chip>
     </div>
           
           
         </v-col>
      </v-row>
      <v-divider></v-divider>
    </v-container>
  </div>
</template>

<script>
//import Popup from "@/components/Popup.vue";
export default {
  name: "attendee",
  props: ["attendee"],
  // components: {
  //   Popup
  // },
};
</script>

<style>
</style>