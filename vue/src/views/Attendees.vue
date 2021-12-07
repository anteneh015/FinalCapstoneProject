<template>
  <div class="camp">
    <h1>{{ $store.state.campName }}</h1>
    <main>
      <div class="trello-list">
        <ol class="cards">
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
      </div>

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
#labels {
  display: flex;
  justify-content: space-between;
}

#labels li {
  list-style-type: none;
}

h1 {
  align-self: center;
}

div.trello-list {


    /* Layout */
    display: inline-block;
    width: 300px;
    margin-right: 10px;
    vertical-align: top; 

    /* Look & Feel */
    background-color: #DDD;
    
    border-radius: 2px 3px;
}
</style>