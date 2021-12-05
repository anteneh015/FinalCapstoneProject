<template>
  <div class="camp">
      <h1>{{$store.state.campName}}</h1>
      <main>
        <attendee-list />
        


      </main>

  </div>
</template>

<script>
import AttendeeList from '@/components/AttendeeList'

export default {
  name: "attendees",
   components: {
    AttendeeList,
  },
};
</script>

<style>

</style>