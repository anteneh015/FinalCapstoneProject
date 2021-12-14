<template class="abc">
  <div class="home">
    <h1>Home</h1>
    <img src="/dorm-background.png" style="width:100%;" class="dormImage" />
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

</style>