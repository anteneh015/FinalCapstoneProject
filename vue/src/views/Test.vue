<template>
  <v-container bg fill-height grid-list-md text-xs-center>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
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
            <v-form class="emailForm" ref="form" @submit.prevent="sendEmail">
              <v-text-field
                label="Attendee Name: "
                name="to_name"
                prepend-icon="mdi-robot-outline"
                type="text"
              ></v-text-field>
              <v-text-field
                label="Email"
                name="email"
                prepend-icon="mdi-lock-question"
                type="text"
                required
              ></v-text-field>
              <v-text-field
                label="Message"
                name="message"
                prepend-icon="mdi-lock-question"
                type="text"
              ></v-text-field>
              <v-card-actions>
                <v-btn type="submit" value="Send" color="#61A5c2" dark
                  >Send</v-btn
                >
              </v-card-actions>
            </v-form>
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
      </v-col>
    </v-row>
  </v-container>
</template>