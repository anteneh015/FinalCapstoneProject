<template>
  <v-container bg fill-height grid-list-md text-xs-center>
    <v-row align="center" justify="center">
      <v-card class="elevation-12">
        <v-card-text>
          <form id="searchMenu">
            <div id="paymentOption">
              <label for="payment">Payment Status: </label>
              <select
                id="payment"
                v-model="filter.paymentStatus"
                style="border: 2px solid #61a5c2"
              >
                <option value="">All</option>
                <option>received</option>
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
          </form>

          <form class="list">
            <attendee
              v-for="attendee in listOfAttendees"
              v-bind:key="attendee.attendeeId"
              v-bind:attendee="attendee"
            />
          </form>
        </v-card-text>
      </v-card>
    </v-row>
  </v-container>
</template>