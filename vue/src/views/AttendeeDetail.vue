<template>
  <div class="attendeeDetail">
    <h1>Detail for id {{ id }}</h1>
    <attendee
      v-for="attendee in attendeeList"
      v-bind:key="attendee.attendeeId"
      v-bind:attendee="attendee"
    />
  </div>
</template>

<script>
import Attendee from "../components/Attendee.vue";

export default {
  components: { Attendee },
  data() {
    return {
      id: 0,
    };
  },
  created() {
    this.id = this.$route.params.id;
  },
  computed: {
    attendeeList() {
      return this.$store.state.attendees.filter(attendee =>{
          return attendee.attendeeId === this.id;
      });
    },
  },
};
</script>

<style>
</style>