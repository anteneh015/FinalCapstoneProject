<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div><router-link v-bind:to="{ name: 'attendees' }">Click here to see attendees</router-link></div>

  </div>
</template>

<script>
export default {
  name: "home"
};
</script>