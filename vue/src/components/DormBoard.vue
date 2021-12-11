<template>
  <div :id="id" class="board" @dragover.prevent @drop.prevent="drop">
    <slot />
  </div>
</template>

<script>
export default {
  props: ["id"],
  methods: {
    drop: e => {
      let card_id = e.dataTransfer.getData("card_id");
      let card = document.getElementById(card_id);
      card.style.display = "block";
      e.target.appendChild(card);
      this.$emit("attendeeDropped", card_id, event.target.id);
    }
  }
};
</script>

<style>
</style>