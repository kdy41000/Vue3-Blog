<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Blog</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/list">
              <a class="nav-link" href="#">Board</a>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- <blog-list/> -->
  <router-view></router-view>
</template>

<script>
//import BlogList from './components/BlogList.vue';

export default {
  name: 'App',
   /*components: {
    BlogList
  },*/
  methods: {
    onClickTest:async function() {
     // alert("test");
      //console.log("test:",this.$http);
      await this.$http.get('/api/v1/test1')
        .then(data => {
           console.log("data:",data);
        })
        .catch(err => {
            console.log(err);
        });
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
