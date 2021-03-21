import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import './assets/fonts/iconfont.css'
import './assets/css/global.css'

import axios from 'axios'
//挂载axios
Vue.prototype.$http = axios
//设置访问根路径
//axios.defaults.baseURL = "/api"
axios.defaults.baseURL = "http://localhost:9000/api"

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
