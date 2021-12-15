<template>
  <v-container class="fill-height" fluid>
    <div
      class="alert alert-danger"
      role="alert"
      v-if="registrationErrors"
    >{{ registrationErrorMsg }}</div>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card class="elevation-12">
          <v-toolbar color="#61A5c2" dark flat>
            <v-toolbar-title>Create Account</v-toolbar-title>
            <v-spacer></v-spacer>
            <span>Let's get you on board</span>
          </v-toolbar>
      
          <v-card-text>
            <v-form>
              <v-text-field
                label="User Name"
                name="login"
                id="username"
                prepend-icon="mdi-robot-love-outline"
                type="text"
                v-model="user.username"
              ></v-text-field>
              <v-text-field
                id="Email"
                name="email"
                prepend-icon="mdi-email-send-outline"
           
                label="E-mail"
                type="email"
                required
                v-model="user.email"
              ></v-text-field>


               <v-text-field
                id="password"
                label="Password"
                name="password"
                prepend-icon="mdi-lock-question"
                type="password"
                required
                v-model="user.password"
              ></v-text-field>
              <v-text-field
                id="confirmPassword"
                label="Confirm Password"
                name="password"
                prepend-icon="mdi-lock"
                type="password"
                required
                v-model="user.confirmPassword"
              ></v-text-field>
              </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
             <v-btn color="#61A5c2" dark flat router :to="{ name: 'login' }">Back to login</v-btn>
            
            <v-btn @click="registerUser()" color="#61A5c2" dark flat>Create Account</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style></style>

