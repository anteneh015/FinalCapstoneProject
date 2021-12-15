<template>
  <v-app class="app">
    <v-main :class="this.$route.meta.homePage ? 'homepage' : 'grey lighten-4'">
      <Navbar v-if="!this.$route.meta.hideNavigation" class="mx-4" />
      <v-container :class="{ 'mx-5': !this.$route.meta.homePage }">
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import attendeeService from "@/services/AttendeeService";

export default {
  name: "App",
  components: {
    Navbar,
  },
  computed: {
    isAuthenticated() {
      return this.$store.state.user != "currentUser";
    },
  },

  created() {

  attendeeService
    .getAllAttendees()
    .then((response) => {
       this.$store.commit("SET_ATTENDEES", response.data);
    })
    .catch((error) => {
      if (error.response) {
        this.errorMsg =
          "Error creating new board " +
          error.response.status +
          " " +
          error.response.statusText;
      }
      else if (error.request) {
        this.errorMsg = "Error connecting to Server";
      }
      else {
        this.errorMsg = "Some JavaScript error occurred";
      }
    });
  },
};
</script>

<style scoped>
/* html {
    height: 100%; 
    width: 100%;
    position: relative;
    background-image: url("/background3.jpg");
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
} */
</style>
