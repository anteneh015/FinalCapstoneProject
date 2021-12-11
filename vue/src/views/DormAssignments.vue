<template>
  <div class="dormContainer">
    {{attendees}}
    <v-snackbar v-model="snackbar" :timeout="4000" top color="success">
      <span class="font-weight-bold">Attendees Successfully Assigned!</span>
      <v-btn class="mx-4" text color="white" @click="snackbar=false">Close</v-btn>
    </v-snackbar>


    <span class="text-uppercase grey--text text-h4 dormTitle">Dorm Assignment</span>

    <!-- background image 
    <img src="/dorm-page-background.png" style="width:100%;" class="dormImage" />-->


    <DormBoard id="board-0" class="dormAttendees board" @attendeeDropped="change">
      <CamperCard
        :id="`${attendee.attendeeId}`"
        class="dormCard"
        v-for="attendee in attendees"
        :key="attendee.attendeeId"
        draggable="true"
      >
        <p class="text-button dormAttendeeName">{{attendee.attendeeName}}</p>
      </CamperCard>
    </DormBoard>

    
    <div class="dormName1">
      <span class="text-uppercase grey--text text-h4">DeAmber</span>
    </div>
    <div class="dormName2">
      <span class="text-uppercase grey--text text-h4">Anteneh</span>
    </div>
    <v-btn color="success" class="dormButton" @click="snackbarSubmit">SAVE ASSIGNMENTS</v-btn>

    <DormBoard id="board-1" class="dorm1 board" @attendeeDropped="change"></DormBoard>
    <DormBoard id="board-2" class="dorm2 board" @attendeeDropped="change"></DormBoard>
    <div class="otterspace">
      <v-img src="src\assets\cute-robot-face-icon-vector.jpg" max-width="150"></v-img>
    </div>
    <div class="aquaotter">
      <v-img src="src\assets\cute-robot-face-icon-vector.jpg" max-width="120"></v-img>
    </div>
  </div>
</template>

<script>
import DormBoard from "@/components/DormBoard.vue";
import CamperCard from "@/components/CamperCard.vue";

export default {
  data() {
    return {
      attendees: [],
      dorm1: [],
      dorm2: [],
      dorm3: [],
      snackbar: false
    };
  },
  components: {
    DormBoard,
    CamperCard
  },
  methods: {
    snackbarSubmit() {
      this.snackbar = true;
      setTimeout(() => {
        this.snackbar = false;
        this.$router.push({ name: "attendees" });
      }, 4000);
    },
    change(card_id, board_id) {
      console.log("change");
      console.log(card_id);
      console.log(board_id);
      this.filteredDorm(card_id, board_id);
      //   this.filteredCampers(card_id);
    },
    filteredDorm(card_id, board_id) {
      if (board_id == "board-0") {
        for (let i = 0; i < this.dorm1.length; i++) {
          if (this.dorm1[i].attendeeId == card_id) {
            this.dorm1.splice(i, 1);
          }
        }
        for (let i = 0; i < this.dorm2.length; i++) {
          if (this.dorm2[i].attendeeId == card_id) {
            this.dorm2.splice(i, 1);
          }
        }
        for (let i = 0; i < this.dorm3.length; i++) {
          if (this.dorm3[i].attendeeId == card_id) {
            this.dorm3.splice(i, 1);
          }
        }
      }
      if (board_id == "board-1") {
        for (let i = 0; i < this.attendees.length; i++) {
          if (this.attendees[i].attendeeId == card_id) {
            this.dorm1.push(this.attendees[i]);
          }
        }
        for (let i = 0; i < this.dorm2.length; i++) {
          if (this.dorm2[i].attendeeId == card_id) {
            this.dorm2.splice(i, 1);
          }
        }
        for (let i = 0; i < this.dorm3.length; i++) {
          if (this.dorm3[i].attendeeId == card_id) {
            this.dorm3.splice(i, 1);
          }
        }
      }
      if (board_id == "board-2") {
        for (let i = 0; i < this.attendees.length; i++) {
          if (this.attendees[i].attendeeId == card_id) {
            this.dorm2.push(this.attendees[i]);
          }
        }
        for (let i = 0; i < this.dorm1.length; i++) {
          if (this.dorm1[i].attendeeId == card_id) {
            this.dorm1.splice(i, 1);
          }
        }
        for (let i = 0; i < this.dorm3.length; i++) {
          if (this.dorm3[i].attendeeId == card_id) {
            this.dorm3.splice(i, 1);
          }
        }
      }
      if (board_id == "board-3") {
        for (let i = 0; i < this.attendees.length; i++) {
          if (this.attendees[i].attendeeId == card_id) {
            this.dorm3.push(this.attendees[i]);
          }
        }
        for (let i = 0; i < this.dorm1.length; i++) {
          if (this.dorm1[i].attendeeId == card_id) {
            this.dorm1.splice(i, 1);
          }
        }
        for (let i = 0; i < this.dorm3.length; i++) {
          if (this.dorm2[i].attendeeId == card_id) {
            this.dorm2.splice(i, 1);
          }
        }
      }
    }
  },
  created() {
    this.attendees = this.$store.state.attendees;
  }
};
</script>
 
<style>
/** .dormContainer {
  margin-left: 100px;
}

.dormImage {
  border-radius: 25px;
}
.dormContainer {
  position: relative;
  text-align: center;
}

.otterspace {
  transform: translate(76%, -940%);
}

.aquaotter {
  transform: translate(15%, -995%);
}

.dormButton {
  transform: translate(0, -1650%);
}

.dormName1 {
  background: rgb(243, 243, 243);
  transform: translate(55%, -2350%);
  max-width: 301px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.dormName2 {
  background: rgb(243, 243, 243);
  transform: translate(397%, -2440%);
  max-width: 301px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.dormTitle {
  position: absolute;
  transform: translate(212%, 100%);
  opacity: 0.7;
}

.dormAttendeeName {
  text-align: center;
  justify-self: center;
}

.dormAttendees {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -150%);
  border-radius: 10px;
}

.dormCard {
  border-radius: 10px;
  padding: 5px 5px -10px 5px;
  background: rgb(243, 243, 243);
  box-shadow: 0 0 0 2pt #346a82;

  cursor: pointer;
  margin-bottom: 15px;
}

.dorm1 {
  position: absolute;
  top: 8px;
  left: 16px;
  transform: translate(50%, 50%);
  border-radius: 10px;
}


.dorm2 {
  position: absolute;
  top: 8px;
  right: 16px;
  transform: translate(-50%, 50%);
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
}*/
</style>
