<template>
  <div class="camp">
    <h1>{{ $store.state.campName }}</h1>
    <attendee-filter />
    <main>
        <ol class="label">
          <li>ID</li>
          <li>Name</li>
          <li>DOB</li>
          <li>Gender</li>
          <li>Group</li>
          <li>Pay Status</li>
          <li>Notes</li>
          <li>Registrar</li>
          <li>Guardian Name</li>
          <li>Email</li>
          <li>Address</li>
          <li>Phone</li>
          <li>Emgcy Contact</li>
        </ol>
      

      <attendee-list />
    </main>
  </div>
</template>

<script>
import AttendeeList from "@/components/AttendeeList";
import AttendeeFilter from '../components/AttendeeFilter.vue';

export default {
  name: "attendees",
  components: {
    AttendeeList,
    AttendeeFilter,
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
    list-style: none;
    background-color: rgb(255, 255, 255);
    font-size: .9rem;
    border-radius: 1px;
    margin-bottom: 10px;
    padding: 8px;
    white-space: normal;
}
</style>