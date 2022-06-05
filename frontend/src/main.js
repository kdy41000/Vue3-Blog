import { createApp } from 'vue'
import App from './App.vue'
import http from './http/customAxios';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import router from './router'; // 라우터 추가하고 

const app = createApp(App);
app.config.globalProperties.$http = http;
app.use(router); // 사용 설정 하기

app.mount('#app');