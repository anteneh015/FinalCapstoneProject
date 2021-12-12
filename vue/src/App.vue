<template>
  <!-- v-app is our root Vuetify component. It MUST be our root component -->
  <v-app class="app">
    <!-- v-app-bar is a nav-toolbar.  It is a vuetify component much like the components we create.
    This not only comes with pre-defined HTML but baked in functionality. We can see we pass the prop 'dark' here.
    If we were to change 'dark' to 'light' we would change the color scheme of the toolbar-->
    <!-- <v-app-bar app color="primary" dark> -->

    <!-- Within v-main is where we'll place all of our content for the page -->
    <!-- Using mx-4, were using margin on the x axis with a strength of 4 -->
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

</style>
