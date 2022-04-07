import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login.vue";
import Pos from "../components/Pos.vue";
import Home from "../views/Manage.vue";
import MenuList from "../views/admin/MenuList.vue";
import OrderList from "../views/admin/OrderList.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/home",
    component: Home,
    redirect: "/menu",
    children: [
      { path: "/menu", component: MenuList },
      // { path: "/order", component: OrderList },
    ],
  },
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
