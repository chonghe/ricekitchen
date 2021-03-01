import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Pos from '../components/Pos.vue'
import Home from '../views/Manage.vue'
import MenuList from '../views/admin/MenuList.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Pos',
    component: Pos
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    redirect:'/menu',
    children:[
      {path:'/menu',component:MenuList},
    ]
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
