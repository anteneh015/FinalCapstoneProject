<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <v-img alt="Logo" class="shrink mr-2" contain src="../public/camp-logo.png" transition="scale-transition" width="40"/>
        <v-img alt="Name" class="shrink mt-1 hidden-sm-and-down" contain min-width="100" src="../public/text-logo.png" width="100" />
      </div>
      <v-spacer></v-spacer>
    </v-app-bar>

    <v-main>
      <div id="nav">
        <!--hide navbar -->
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  /**TODO Navbar(import, compenents, computed) -L */
  name: 'App',

  data: () => ({
    //
  }),
};
</script>

<style scoped>
/**TODO maybe style the bakground -L */
</style>
