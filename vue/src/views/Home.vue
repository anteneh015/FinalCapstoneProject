<template class="abc">
  <!-- <div class="home">
   
    <img src="/background3.jpg" style="width:125%;" class="dormImage" />
     <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <div><router-link v-bind:to="{ name: 'attendees' }">Attendees</router-link></div> 
     </div>-->


  <v-content>
    <div class="staticHero">
      <v-img src="/image (5).png">
        <!-- <v-row align="end" class="lightbox white--text pa-2 fillheight">
          <v-col>
            <v-container>
            <div class="headline">Robotic Echo Summer Camp</div>
            </v-container>
          </v-col>
        </v-row> -->
      </v-img>
    </div>
  </v-content>
 
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