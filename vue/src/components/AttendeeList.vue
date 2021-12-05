<template>
  <div class="attendeeList">
  <attendee 
  v-for="attendee in attendees"
  v-bind:key="attendee.id"
  v-bind:attendee="attendee"
  />

  </div>
</template>

<script>
import attendeeService from '@/services/AttendeeService'
import Attendee from './Attendee.vue'

export default {
    name: 'attendee-list',
    data(){
        return{
          errorMsg: ''  
        }
    },
    components: {
        Attendee
    },
    created() {

        attendeeService.getAllAttendees()
        .then( response => {
            this.$store.commit("SET_ATTENDEES", response.data)
        })
        .catch( error => {
            // TODO: Inform the user there was an error
              if (error.response) {
            this.errorMsg = "Error creating new board " 
                + error.response.status + " " 
                + error.response.statusText
          }
          // Handle connection errors
          else if (error.request) {
            this.errorMsg = "Error connecting to Server";
          }
          // Handle JS runtime errors
          else {
            this.errorMsg = "Some JavaScript error occurred";
          }
        })
    }

}
</script>

<style>

</style>