<template>
  <div id="app">
  <v-app>
    <v-container>
      <v-row>
        <v-col cols="3">
          <div style="color:red; font-weight:bold; padding-bottom:30px">Dorm Assignment</div>
          <draggable v-model="assignment" group="kanban" tag="ul">

            <li v-for="attendee in attendees" :key="attendee.attendeeId" style="font-weight:bold;">
              {{attendee.attendeeName}}
            </li>
          </draggable>
        </v-col>
        <v-col cols="3">
          <div style="color:red; font-weight:bold; padding-bottom:30px">Wall-E</div>
          <draggable v-model="walle" group="kanban" tag="ul">

            <li v-for="attendee in walleDorm" :key="attendee.attendeeId" style="font-weight:bold;">
               {{attendee.attendeeName}}
            </li>
          </draggable>
        </v-col>
        <v-col cols="3">
          <div style="color:red; font-weight:bold; padding-bottom:30px">Eve</div>
          <draggable v-model="eveDorm" group="kanban" tag="ul">

            <li v-for="attendee in eveDorm" :key="attendee.attendeeId" style="font-weight:bold;">
               {{attendee.attendeeName}}
            </li>
          </draggable>
        </v-col>
      </v-row>
    </v-container>

  </v-app>
</div>
</template>

<script>
export default {
  data() {
    return{
      walleDorm: [],
      eveDorm: []
    }
  },
  created(){
    this.attendees = this.$store.state.attendees;
  }
}
</script>

<style scoped>

</style>