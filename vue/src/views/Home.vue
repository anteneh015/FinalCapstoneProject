<template class="abc">
  <div class="home">
   
    <img src="/background3.jpg" style="width:125%;" class="dormImage" />
     <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div><router-link v-bind:to="{ name: 'attendees' }">Attendees</router-link></div>

  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style scoped>
#abc {
  background: url('/background3.jpg') no-repeat center center fixed !important;
  background-size: cover;
}
</style>