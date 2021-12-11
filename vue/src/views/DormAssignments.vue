<template>
  <h1>{{attendees}}</h1>




</template>


<script>

//import the card and board



export default {
  name: "dorm",
    data() {
    return {
      attendees: [],
    //   dorm1: [],
    //   dorm2: [],
    //   dorm3: [],
    //   snackbar: false
    };
  },
  created() {
    this.attendees = this.$store.state.attendees;
  },
};
</script>



<style scoped>
</style>