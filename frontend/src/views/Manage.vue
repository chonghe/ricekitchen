<template>
  <el-container class="home-container">
    <el-header>
      <div>
        <img src="../assets/logo.png" alt />
        <span>Ordering management System</span>
      </div>
      <el-button type="info" @click="logout">logout</el-button>
    </el-header>
    <el-container>
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <el-menu
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#409eff"
          unique-opened
          :collapse="isCollapse"
          :collapse-transition="false"
          :router="true"
          :default-active="activePath"
        >
          <!-- unique-opened="" -->

          <!-- 一级菜单 -->
          <el-submenu
            :index="item.id + ''"
            v-for="item in menuList"
            :key="item.id"
            @click="saveNavState(it.path)"
          >
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{ item.title }}</span>
            </template>
            <!-- 二级菜单 -->
            <!-- 路由跳转根据index，而且it.path本身就是字符串 -->
            <el-menu-item
              :index="it.path"
              v-for="it in item.sList"
              :key="it.id"
            >
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>{{ it.title }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
export default {
  data() {
    return {
      // 菜单列表
      menuList: [],
      isCollapse: false, //伸缩
      activePath: "/welcome", //默认路径
    };
  },
  created() {
    this.getMenuList();
    window.sessionStorage.getItem("activePath"); //取出session里的path 动态修改activePath
  },
  methods: {
    // 安全退出
    logout() {
      window.sessionStorage.clear(); //清除session
      this.$router.push("/login"); //回到首页
    },
    // 获取导航菜单方法
    async getMenuList() {
      //console.log("导航菜单");
      const { data: res } = await this.$http.get("manage");
      console.log(res);
      if (res.flag != 200) return this.$message.error("List failed");
      this.menuList = res.manages;
    },
    // 控制伸缩
    toggleCollapse() {
      //取反 显示or隐藏
      this.isCollapse = !this.isCollapse;
    },
    //保存路径
    saveNavState(activePath) {
      window.sessionStorage.setItem("activePath", activePath); //存放在session里
      this.activePath = activePath;
    },
  },
};
</script>
<style lang="less" scoped>
//布局器样式
.home-container {
  height: 100%;
}
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between; //左右贴边
  padding-left: 0%; //左边界
  align-items: center; //全部居中
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}
.el-aside {
  background-color: #333744;
  .el-menu {
    border-right: none;
  }
}
.el-main {
  background-color: #eaedf1;
}
img {
  width: 55px;
  height: 55px;
}
// |||
.toggle-button {
  background-color: #4a5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer; // 显示小手
}
</style>
