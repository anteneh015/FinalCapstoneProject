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
          Ea pri vitae antiopam theophrastus, ut sit erat putent eruditi. Qui at
          mutat adversarium. Postulant delicatissimi ei qui, an nonumy dolorem
          nam. Cu philosophia instructior pri, nec cu mutat homero saperet, cu
          paulo ridens legendos has. Cu veri oportere pri, ad integre numquam
          iudicabit mel. Nec ea ferri iudicabit dissentiet. Ex solet melius
          omittantur his, in gloriatur vulputate mel. Ad nostro repudiandae ius,
          est amet molestie te. No est modus sensibus volutpat, et putent
          dissentias has, et sea eirmod vivendum. Paulo lucilius expetenda sea
          in, cu nam mazim sanctus ponderum. Te nam mundi corpora, dicat dolore
          debitis ius in. Indoctum adversarium definitionem an pro, an eam vidit
          utinam detracto.
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
          src: "/about1.jpg",
        },
        {
          src: "/about2.jpeg",
        },
        {
          src: "/about3.jpg",
        },
        {
          src: "/about4.jpeg",
        },
      ],
      teams:[
        {
          id: 1,
          src: "/De'Amber Watson (1).jpg",
          name: "De'Amber Watson",
          title: 'Counselor'
        },
        {
          id: 2,
          src: "/anteneh.png",
          name: 'Anteneh Tekle',
          title: 'Counselor'
        },
        {
          id: 3,
          src: "/Liping Castillo.jpg",
          name: 'Liping Castillo',
          title: 'Counselor'
        }
      ] 
    };
  },
};
</script>

<style>
#img {
  border-radius: 50%;
}
</style>