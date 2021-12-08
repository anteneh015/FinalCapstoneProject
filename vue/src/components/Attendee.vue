<template>
  <div class="attendee">
   
    <ol class="cards">
      
      <li>ID: {{ attendee.attendeeId }}</li>
      <li>Name: {{ attendee.attendeeName }}</li>
      <li>DOB: {{ attendee.dateOfBirth }}</li>
      <li>Gender: {{ attendee.gender }}</li>
      <li>Group: {{ attendee.ageGroup }}</li>
      <li>
         <div class="labels">
              <span class="paymentStatus"></span>
          </div>
          Pay Status: {{ attendee.paymentStatus }}
      </li>
      <li>Notes: {{ attendee.notes }}</li>
      <li>Registrar: {{ attendee.registrar }}</li>
      <li>Guardian Name: {{ attendee.guardianName }}</li>
      <li>Email: {{ attendee.email }}</li>
      <li>Address: {{ attendee.address }}</li>
      <li>Phone: {{ attendee.guardianPhone }}</li>
      <li>Emgcy Contact: {{ attendee.emgcyName }}  {{ attendee.emgcyPhone }}</li>
     </ol>
    
  </div>
</template>

<script>
export default {
    name: 'attendee',
    props: ['attendee']
    

}
</script>

<style>
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