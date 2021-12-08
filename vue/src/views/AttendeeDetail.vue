<template>
  <div class="attendeeDetail">
      <h1>Detail for id {{ attendeeId}}</h1>
    <!--- TODO: import attendee -->

  </div>
</template>

<script>
export default {
    data() {
        return {
            attendeeId: 0
        }
    },
    created() {
        this.attendeeId = this.$route.params.attendeeId;
    }
}
</script>

<style>

</style>