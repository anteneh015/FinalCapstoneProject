<template>
  <div class="attendeeDetail">
     <p>abc</p> <h1>Detail for id {{ attendeeId}}</h1><p>123</p>
    <!-- <attendee v-for="attendee in attendeeList" v-bind:key="attendee.attendeeId"
        v-bind:attendee="attendee" /> -->
  </div>
</template>

<script>
//import Attendee from '../components/Attendee.vue';
//import AttendeeList from '../components/AttendeeList.vue';
export default {
 // components: { Attendee},
   //props: ['attendee'],
   data() {
        return {
            attendeeId: 0
        }
    },
    created() {
        this.attendeeId = this.$route.params.attendeeId;
    },
    computed:{
        attendeeList(){return this.$store.state.attendees;}
    }
}
</script>

<style>

</style>