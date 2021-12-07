<template>
  <div class="attendee">
   
    <ol class="cards">
      <li>{{ attendee.attendeeId }}</li>
      <li>{{ attendee.attendeeName }}</li>
      <li>{{ attendee.dateOfBirth }}</li>
      <li>{{ attendee.gender }}</li>
      <li>{{ attendee.ageGroup }}</li>
      <li>
         <div class="labels">
              <span class="paymentStatus"></span>
          </div>
            {{ attendee.paymentStatus }}
      </li>
      <li>{{ attendee.notes }}</li>
      <li>{{ attendee.registrar }}</li>
      <li>{{ attendee.guardianName }}</li>
      <li>{{ attendee.email }}</li>
      <li>{{ attendee.address }}</li>
      <li>{{ attendee.guardianPhone }}</li>
      <li>{{ attendee.emgcyName }}  {{ attendee.emgcyPhone }}</li>
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