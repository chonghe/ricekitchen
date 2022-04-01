<template>
  <div class="left-nav">
    <ul>
      <li @click="foodClick">
        <i class="icon iconfont icon-goumai"></i>
        <div>Sale</div>
      </li>
      <li @click="manageClick">
        <i class="icon iconfont icon-dianpu"></i>
        <div>Store</div>
      </li>
      <li>
        <i class="icon iconfont icon-shipin"></i>
        <div>Food</div>
      </li>
    </ul>
  </div>
</template>
<!-- <i class="icon iconfont icon-dianpu"></i>
    <i class="icon iconfont icon-shipin"></i>
    <i class="icon iconfont icon-gouwuche"></i>
    <i class="icon iconfont icon-shipinyinliao"></i>
    <i class="icon iconfont icon-gouwuche2"></i>
    <i class="icon iconfont icon-goumai"></i> -->
<script>
export default {
  name: "LeftNav",
  data() {
    return {};
  },
  methods: {
    foodClick() {
      this.$router.push({ path: "/" });
    },
    manageClick() {
      this.$router.push({ path: "/login" });
    },
  },
};
</script>

<style scoped>
.left-nav {
  color: #fff;
  font-size: 10px;
  height: 100%;
  background-color: #1d8ce0;
  float: left;
  width: 5%;
}
.iconfont {
  font-size: 24px;
}
.left-nav ul {
  padding: 0px;
  margin: 0px;
}
.left-nav li {
  list-style: none;
  text-align: center;
  border-bottom: 1px solid #20a0ff;
  padding: 10px;
  cursor: pointer;
}
</style>
