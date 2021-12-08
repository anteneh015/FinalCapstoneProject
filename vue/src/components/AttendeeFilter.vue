<template>
  <div class="filter">
      <div>
          <label for="search">Search:</label>
          <select id="search" 
            v-model="searchWord"
            v-on:change="setSearchWord">
              <option v-for="word in $store.state.searchWords" 
                v-bind:key="word"
                v-bind:value="word">{{ word }}</option>
          </select>
      </div>
  </div>
</template>

 <script>
export default {
    name:'attendee-filter',
    data() {
        return {
            searchWord: this.$store.state.searchWord,
            paymentStatus: true,
        }
    },
    methods: {
        setSearchWord() {
            this.$store.commit("SET_SEARCH_WORD", this.searchWord);
        }
    }
}
</script>

<style>

</style>