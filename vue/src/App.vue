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
    <div>    <v-dialog v-model="dialog" max-width="500px">    <v-btn slot="activator" color="primary" dark class="mb-2">New Item</v-btn>    <v-card>        <v-card-title>        <span class="headline">{{ formTitle }}</span>        </v-card-title>        <v-card-text>        <v-container grid-list-md>            <v-layout wrap>            <v-flex xs12 sm6 md4>                <v-text-field v-model="editedItem.name" label="Dessert name"></v-text-field>            </v-flex>            <v-flex xs12 sm6 md4>                <v-text-field v-model="editedItem.calories" label="Calories"></v-text-field>            </v-flex>            <v-flex xs12 sm6 md4>                <v-text-field v-model="editedItem.fat" label="Fat (g)"></v-text-field>            </v-flex>            <v-flex xs12 sm6 md4>                <v-text-field v-model="editedItem.carbs" label="Carbs (g)"></v-text-field>            </v-flex>            <v-flex xs12 sm6 md4>                <v-text-field v-model="editedItem.protein" label="Protein (g)"></v-text-field>            </v-flex>            </v-layout>        </v-container>        </v-card-text>        <v-card-actions>        <v-spacer></v-spacer>        <v-btn color="blue darken-1" flat @click.native="close">Cancel</v-btn>        <v-btn color="blue darken-1" flat @click.native="save">Save</v-btn>        </v-card-actions>    </v-card>    </v-dialog>    <v-data-table :headers="headers" :items="desserts" hide-actions class="elevation-1">    <template slot="items" slot-scope="props">        <td>{{ props.item.name }}</td>        <td class="text-xs-right">{{ props.item.calories }}</td>        <td class="text-xs-right">{{ props.item.fat }}</td>        <td class="text-xs-right">{{ props.item.carbs }}</td>        <td class="text-xs-right">{{ props.item.protein }}</td>        <td class="justify-center layout px-0">        <v-btn icon class="mx-0" @click="editItem(props.item)">            <v-icon color="teal">edit</v-icon>        </v-btn>        <v-btn icon class="mx-0" @click="deleteItem(props.item)">            <v-icon color="pink">delete</v-icon>        </v-btn>        </td>    </template>    </v-data-table></div>
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
