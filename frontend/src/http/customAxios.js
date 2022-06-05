import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080',
});

http.interceptors.request.use(
    function (config) {
      config.headers["Content-Type"] = "application/json; charset=utf-8";
      return config;
    },
    function (error) {
      console.log(error);
      return Promise.reject(error);
    }
);

http.interceptors.response.use(
    function (response) {
        console.log('response:',response);
      return response.data;
     
    },
    function (error) {
        console.log(error);
    }
);

export default http;