<template>
  <div class="attendeeList">
     <section for="payment"> Paymnet Status
          <input type="checkbox" id="unpaid" name="payment" value="false" >
          <label for="unpaid"> unpaid</label>
          <input type="checkbox" id="paid" name="payment" value="true">
          <label for="paid"> paid</label>
        </section> 
  <attendee 
  v-for="attendee in attendees"
  v-bind:key="attendee.attendeeId"
  v-bind:attendee="attendee"
  />
  

  </div>
</template>

<script>
import attendeeService from '@/services/AttendeeService'
import Attendee from '@/components/Attendee.vue'

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
    computed: {
   
        attendees() {
            const attendees = this.$store.state.attendees;
            //const searchWords = this.$store.state.searchWords;
          //  return attendees;
            return attendees.filter(attendee => {
               return attendee.gender === 'Female';
            })
            //return attendees;
          

           // if (searchWord === 'All') {
            //    return attendees;
           // }
         //   if(searchWord === "Payment status"){
         // return attendees.filter( attendee => {
              

              
              
            // })
         // } 
        }
    },
    methods:{
      testfunction(){

      } 
    },
    created() {

        attendeeService.getAllAttendees()
        .then( response => {
            this.$store.commit("SET_ATTENDEES", response.data);
            
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