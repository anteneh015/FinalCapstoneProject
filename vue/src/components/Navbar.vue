<template>
  <nav>
    <!-- -->
    <v-app-bar flat>
      <v-app-bar-nav-icon
        class="grey--text"
        @click="drawer = !drawer"
      ></v-app-bar-nav-icon>
       <v-avatar size="50">
          <v-img
        class="mx-2"
        src="/logocrop.jpg"
        max-height="50"
        max-width="50"
        contain
      ></v-img>
      </v-avatar>
      <v-toolbar-title class="text-uppercase grey--text">
     
        <span>Robotic Echo</span>
        <span class="font-weight-light">&nbsp;Portal</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-btn text color="grey" router :to="{ name: 'logout' }">
        <span>Log Out</span>
        <v-icon right>mdi-exit-to-app</v-icon>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer app v-model="drawer" temporary class="primary">
      <v-row justify="center">
        <v-col cols="5">
          <v-avatar size="100">
            <img src="/cute-robot-face-icon-vector.jpg" />
          </v-avatar>
          <p
            class="white--text subheading mt-1 mx-1 text-center text-capitalize"
          >
            {{ userName }}
          </p>
        </v-col>
      </v-row>
      <v-list>
        <v-list-item
          v-show="
            (userRole == 'ROLE_USER' && link.role == 'ROLE_USER') ||
            userRole == 'ROLE_ADMIN'
          "
          v-for="link in links"
          :key="link.text"
          router
          :to="link.route"
        >
          <v-list-item-action
            v-if="
              (userRole == 'ROLE_USER' && link.role == 'ROLE_USER') ||
              userRole == 'ROLE_ADMIN'
            "
          >
            <v-icon class="white--text">{{ link.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content
            v-if="
              (userRole == 'ROLE_USER' && link.role == 'ROLE_USER') ||
              userRole == 'ROLE_ADMIN'
            "
          >
            <v-list-item-title class="white--text">{{
              link.text
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      userRole: "",
      userName: "",
      drawer: false,
      links: [
        {
          icon: "mdi-robot-outline",
          text: "Attendees",
          route: "/attendees",
          role: "ROLE_USER",
        },
        // {
        //   icon: "mdi-folder",
        //   text: "Team",
        //   route: "/team",
        //   role: "ROLE_USER"
        // },
        //{
        //   icon: "mdi-upload",
        //   text: "Add Campers",
        //   route: "/upload",
        //   role: ""
        // },
         {
          icon: "mdi-home-group",
          text: "Dorm Assignment",
          route: "/dormAssignments",
          role: "ROLE_USER"
        },
        // {
        //   icon: "mdi-email",
        //   text: "Send Emails",
        //   route: "/emails",
        //   role: "ROLE_USER"
        // },
        // {
        //   icon: "mdi-history",
        //   text: "Change History",
        //   route: "/history",
        //   role: "ROLE_USER"
        // },

        // {
        //   icon: "mdi-account-plus",
        //   text: "User Registration",
        //   route: "/register",
        //   role: ""
        // }
      ],
    };
  },
  methods: {
    getRole() {
      this.userRole = this.$store.state.user.authorities[0].name;
      this.userName = this.$store.state.user.username;
    },
  },
  created() {
    this.getRole();
  },
  computed: {
    activeLinks() {
      return this.links.filter((link) => {
        return link.admin;
      });
    },
  },
};
</script>

<style>
</style>