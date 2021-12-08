<template>
  <div class="filter">
      <div>
        <section for="payment"> Paymnet Status
          <input type="checkbox" id="unpaid" name="payment" value="false" v-on:click="testMethod">
          <label for="unpaid"> unpaid</label>
          <input type="checkbox" id="paid" name="payment" value="true">
          <label for="paid"> paid</label>
        </section>  

          <label for="search">Search:</label>
          <select id="search" 
            v-model="searchWord"
            v-on:change="setSearchWord">
              <option v-for="word in $store.state.searchWords" 
                v-bind:key="word"
                v-bind:value="word">{{ word }} 
              <select>

            </select>
                    <!-- 
                        1. user click sth, can be more than one,event
                        2. handle it(searchwords[]), whenever click->push []
                        3. in store [unpaid]
                        {
                            payment: true,
                            registar: abc,
                            name: name,
                            group: 1,
                        }
                    -->
                </option>
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
        },
        testMethod(event){
            this.$store.commit("SET_PAYMENT_STATUS", event )
        }
    }
}
</script>

<style>

</style>