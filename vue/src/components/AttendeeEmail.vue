<template>
  <div class="attendee" v-bind:attendeeEmail="attendeeEmail">
    <v-container fluid>
      <v-row no-gutters>
        <v-col cols="12" sm="4" md="3">
          <div class="caption blue--text">Name</div>
          <div>{{ attendee.attendeeName }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="3">
          <div class="caption blue--text">Guardian Name</div>
          <div>{{ attendee.guardianName }}</div>
        </v-col>

        <v-col cols="12" sm="4" md="4">
          <div class="caption blue--text">Email</div>
          <div>{{ attendee.email }}</div>
        </v-col>

        <v-col cols="2" sm="4" md="2">
          <div class="caption blue--text">Payment Status</div>
          <div class="right">
            <v-chip
              small
              :color="`${
                attendee.paymentStatus == 'recieved' ? '#61A5c2' : '#9A031E'
              }`"
              class="white--text caption my-2"
              >{{ attendee.paymentStatus == "unpaid" ? "unpaid" : "recieved" }}
            </v-chip>
          </div>
        </v-col>
      </v-row>
      <v-divider></v-divider>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "attendeeEmail",
  props: ["attendee"],
};
</script>

<style scoped>
.attendee {
  border: cornflowerblue;
  border-radius: 10px;
}
</style>