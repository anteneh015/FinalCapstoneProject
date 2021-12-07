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
    <div class="trello-list">
        <h2>Module 1 Week 1</h2>
        <ol class="cards">
          <li class="card">
            <div class="labels">
              <span class="label pathway"></span>
            </div>
            PATHWAY: INTRODUCTION
          </li>
          <li class="card">
            <div class="labels">
              <span class="label individual"></span>
            </div>
            Introduction to Tools
          </li>
          <li class="card">
            <div class="labels">
              <span class="label individual"></span>
            </div>
            Variables and Datatypes
          </li>
          <li class="card">
            <div class="labels">
              <span class="label individual"></span>
            </div>
            Expressions, Statements, Blocks, and Logical Branching
          </li>
          <li class="card">
            <div class="labels">
              <span class="label individual"></span>
            </div>
            Loops and Arrays
          </li>
          <li class="card">
            <div class="labels">
              <span class="label individual"></span>
              <span class="label pair"></span>
            </div>
            Command-Line Programs
          </li>
        </ol>
        <a href="#">Add another card</a>
      </div>
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