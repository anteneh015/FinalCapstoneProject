<template>
  <v-content>
    <div class="carousel">
      <v-carousel>
        <v-carousel-item
          v-for="(item, i) in items"
          :key="i"
          :src="item.src"
          reverse-transition="fade-transition"
          transition="fade-transition"
        ></v-carousel-item>
      </v-carousel>
    </div>
    <div class="block">
      <v-container>
        <p>
          Your aspiring coder, game developer, techie, and computer scientist's
          face will explode with happiness when they attend one of the 2-week;
          4-week; or 6-week Robotic Echo summer camps.
        </p>
        <p>
          Depending on the length selected, your little gear will learn
          JavaScript, HTML, and/or CSS. JavaScript is a kid friendly programming
          language. At Robotic Echo campers learn how create a set of
          instructions to tell a computer how to complete a task. Programming
          empowers kids - whether they want to learn robotics, design a game, or
          build an app. Code is everywhere!
        </p>
        <p>
          The earlier kids start, the more natural programming becomes. Robotic
          Echo is designed to help kids and teens learn front-end web
          development. Everything that you see on a website, like buttons,
          links, animations, and more, were created by a front-end web
          developer.
        </p>
        <p>
          Robotic Echo summer camps help students learn the idea of programming
          through hands-on fun programming projects.
        </p>
      </v-container>
    </div>
    <div class="block">
      <v-container>
        <h2 class="text-center">Our Teams</h2>
        <v-row>
          <v-col
            v-for="team in teams"
            :key="team.id"
            class="d-flex child-flex"
            cols="12"
            sm="4"
          >
            <v-card flat tile class="mx-auto">
              <v-img
                id="img"
                :src="team.src"
                aspect-ratio="1"
                class="grey lighten-2"
              ></v-img>
              <v-card-text class="text--primary text-center">
                <div class="title">{{ team.name }}</div>
                <p>{{ team.title }}</p>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </v-content>
</template>

<script>
export default {
  name: "About",

  data() {
    return {
      items: [
        {
          src: "/about6.png",
        },
        {
          src: "/about2.jpeg",
        },
        {
          src: "/about8.jpg",
        },
        {
          src: "/about7.png",
        },
      ],
      teams: [
        {
          id: 1,
          src: "/De'Amber Watson (1).jpg",
          name: "De'Amber Watson",
          title: "Counselor",
        },
        {
          id: 2,
          src: "/anteneh.png",
          name: "Anteneh Tekle",
          title: "Counselor",
        },
        {
          id: 3,
          src: "/Liping Castillo.jpg",
          name: "Liping Castillo",
          title: "Counselor",
        },
      ],
    };
  },
};
</script>

<style>
#img {
  border-radius: 50%;
}
</style>