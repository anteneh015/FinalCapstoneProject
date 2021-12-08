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

ol {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-right: 10px;
    vertical-align: top; 
    background-color: #DDD;
    border-radius: 2px 3px;
}

li {
    flex-shrink: 1;
    list-style: none;
    background-color: rgb(255, 255, 255);
    font-size: .9rem;
    border-radius: 1px;
    margin-bottom: 10px;
    padding: 8px;
    white-space: normal;
}
</style>