<template>
  <div class="camp">
    <h1>{{ $store.state.campName }}</h1>
    <main>

      <ul id="labels">
  <li>ID</li>
  <li>Name</li>
  <li>Group</li>
  <li>DOB</li>
  <li>Sex</li>
  <li>Pay Status</li>
  <li>Extra Info</li>
  <li>Registrar</li>
  <li>Parent Name</li>
  <li>Email</li>
  <li>Address</li>
  <li>Phone</li>
  <li>Emgcy Contact</li>
  
</ul>
    <attendee-list/>
      
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
  computed:{
    showAttendees() {
      return this.$store.state.attendees;
    }
    }
};
</script>

<style>
.camp {
  display: flex;
  flex-direction: column;
}
#labels {
  display: flex;
  justify-content: space-between
}

#labels li {
    list-style-type: none;
}

h1 {
  align-self: center;
}


</style>