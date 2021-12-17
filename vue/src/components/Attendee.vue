<template>
  <div class="attendee">
    <v-container fluid class="my-9 mx-16">
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

        <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Age Group</div>
          <div>{{ attendee.ageGroup }}</div>
        </v-col>

        <v-col cols="2" sm="4" md="2">
          <div class="caption blue--text">Payment Status</div>
          <div class="right">
            <v-chip
              small
              :color="`${
                attendee.paymentStatus == 'recieved' ? '#61A5c2' : '#9A031E'}`"
              class="white--text caption my-2"
              >{{ attendee.paymentStatus == 'unpaid' ? "unpaid" : "recieved" }}
            </v-chip>
          </div>
        </v-col>

         <v-col cols="12" sm="4" md="1">
          <div class="caption blue--text">Registrar</div>
          <div>{{ attendee.registrar }}</div>
        </v-col>

         <v-col cols="12" sm="4" md="1">
            <div class="text-center">
              <v-btn color="#61A5c2" dark router :to="{ name: 'attendee', params:{id: attendee.attendeeId}}">
                <span>Details</span>
               </v-btn>
            </div>
         </v-col>
        </v-row>

      <v-divider></v-divider>
    </v-container>
  </div>
</template>

<script>

export default {
  name: "attendee",
  props: ["attendee"],
};
</script>

<style scoped>
</style>