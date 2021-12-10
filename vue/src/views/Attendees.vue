<template>
  <div class="camp">
    <h1>{{ $store.state.campName }}</h1>
   
    <main>
      <attendee-list />
    </main>
  </div>
</template>

<script>
import AttendeeList from "@/components/AttendeeList";

export default {
  name: "attendees",
  components: {
    AttendeeList,
  },
  computed: {
    showAttendees() {
      return this.$store.state.attendees;
    },
  },
};
</script>

<style>
.camp {
  display: flex;
  flex-direction: column;
}

h1 {
  align-self: center;
}
</style>