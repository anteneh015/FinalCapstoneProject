<template>
  <div class="camp">
    <h1>{{ $store.state.campName }}</h1>
    <main>
      <attendee-list/>
<!-- 
       <section id="labels">
         <article></article>
        <article>First Name</article>
        <article>Last Name</article>
        <article>Age Group</article> -->

      <section id="labels">
  <article id="A">Attendee ID</article>
  <article id="B">First Name</article>
  <article id="C">Last Name</article>
  <article id="D">Age Group</article>

</section>
      <!-- </section> -->
      <section id="attendee">
        <article>{{ $store.state.attendees.attendeeId }}</article>
        <article>{{ $store.state.attendees.firstName }}</article>
         <article>123</article>
        <article>Harry</article>
        <article>Smith</article>
        <article>Group: C</article>
      </section>
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

#A #B #C {
  display: flex;
}

</style>