<template>
  <div class="attendee">
    <ul id= "camper"> 
      <li>{{ attendee.attendeeId }}</li>
      <li>{{ attendee.firstName }} {{ attendee.lastName }}</li>
      <li>{{ attendee.ageGroup }}</li>
      <li>{{ attendee.dateOfBirth }}</li>
      <li>{{ attendee.gender }}</li>
      <li>{{ attendee.paymentStatus }}</li>
      <li>{{ attendee.additionalInfo }}</li>
      <li>{{ attendee.assignedRegistrar }}</li>
      <li>{{ attendee.parentFirstName }} {{ attendee.parentLastName }}</li>
      <li>{{ attendee.parentEmail }}</li>
      <li>{{ attendee.address }}</li>
      <li>{{ attendee.parentPhone }}</li>
      <li>{{ attendee.emgcyFirstName }} {{ attendee.emgcyLastName }} {{ attendee.emgcyPhone }}</li>
      <li></li>
    
    </ul> 

  </div>
</template>

<script>
export default {
    name: 'attendee',
    props: ['attendee']
    

}
</script>

<style>
#camper li {
    list-style-type: none;
}

#camper {
  display: flex;
  justify-content: space-between
}

</style>