<template>
  <div class="dormContainer">

    <v-snackbar v-model="snackbar" :timeout="4000" top color="success">
      <span class="font-weight-bold">Attendees Successfully Assigned!</span>
      <v-btn class="mx-4" text color="white" @click="snackbar=false">Exit</v-btn>
    </v-snackbar>

    <span class="text-uppercase grey--text text-h4 dormTitle">Dorm Assignment</span>
    <img src="/dorm-background.png" style="width:100%;" class="dormImage" />
    <DormBoard id="board-0" class="dormCampers board" @camperDropped="change">
      <CamperCard
        :id="`${attendee.attendeeId}`"
        class="dormCard"
        v-for="attendee in attendees"
        :key="attendee.attendeeId"
        draggable="true"
      >
        <p class="text-button dormCamperName">{{attendee.attendeeName}} </p>
      </CamperCard>
    </DormBoard>
    <div class="dormName1">
      <span class="text-uppercase grey--text text-h4">Wall-E</span>
    </div>
    <div class="dormName2">
      <span class="text-uppercase grey--text text-h4">Eve</span>
    </div>
    <v-btn color="success" class="submitButton" @click.prevent="snackbarSubmit">SAVE ASSIGNMENTS</v-btn>

    <DormBoard id="board-1" class="dorm1 board" draggable="true" @camperDropped="change"></DormBoard>
    <DormBoard id="board-2" class="dorm2 board" draggable="true" @camperDropped="change"></DormBoard>
    <div class="walle">
      <v-img src="Wall-E-Dorm.png" max-width="170"></v-img>
    </div>
    <div class="eve">
      <v-img src="EVE.png" max-width="120"></v-img>
    </div>
  </div>
</template>

<script>
import DormBoard from "@/components/DormBoard.vue";
import CamperCard from "@/components/CamperCard.vue";

export default {
  data() {
    return {
      snackbar: false
    };
  },
  components: {
    DormBoard,
    CamperCard
  },
  methods: {
    snackbarSubmit() {
      //send info to database
      //get 200 .then
      this.snackbar = true;
      setTimeout(() => {
        this.snackbar = false;
        this.$router.push({ name: "attendees" });
      }, 4000);
    },
    change(){
      //reactive, everytime dropped, database is updated
    },
    
  },
  created() {
    this.attendees = this.$store.state.attendees;
  }
};
</script>

<style>
.dormImage {
  border-radius: 25px;
}
.dormContainer {
  margin-left: 100px;
  position: relative;
  text-align: center;
}
.walle {
  transform:translate(15%, -670%);
}

.eve {
  transform: translate(75%, -730%);
}

.submitButton {
  transform: translate(0%, -200%);
} 

.dormName1 {
  background: rgb(243, 243, 243);
  transform: translate(60%, -1330%);
  max-width: 301px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.dormName2 {
  background: rgb(243, 243, 243);
  transform: translate(385%, -1425%);
  max-width: 301px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.dormTitle {
  position: absolute;
  transform: translate(210%, 70%);
  opacity: 0.7;
}

.dormCampersName {
  text-align: center;
  justify-self: center;
}

.dormCampers {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -90%);
  border-radius: 10px;
}

.dormCard {
  border-radius: 10px;
  padding: 2px 2px 2px 2px;
  background: rgb(243, 243, 243);
  box-shadow: 0 0 0 2pt #346a82;
  height: 50%;
  cursor: pointer;
  margin-bottom: 2px;
}

.dorm1 {
  position: absolute;
  top: 8px;
  left: 16px;
  transform: translate(55%, 50%);
  border-radius: 10px;
}

.dorm2 {
  position: absolute;
  top: 8px;
  right: 16px;
  transform: translate(-62%, 50%);
  border-radius: 10px;
}

.boardContainer {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.flexbox {
  display: flex;
  justify-content: space-between;

  width: 100%;
  max-width: 100vw;
  height: 60vh;

  overflow: hidden;

  margin: 0 auto;
  padding: 15px;
}

.board {
  display: flex;
  flex-direction: column;

  width: 100%;
  max-width: 300px;
  min-height: 400px;

  background: rgba(255, 255, 255, 0.2);

  padding: 15px;
}

.drop-zone {
  background-color: #eee;
  margin-bottom: 10px;
  padding: 10px;
}

.drag-el {
  background-color: #fff;
  margin-bottom: 10px;
  padding: 5px;
}
</style>