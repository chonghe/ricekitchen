<template>
  <div>
    Order List
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Order manage</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- main part -->
    <el-card>
      <el-row :gutter="25">
        <div class="container">
          <div class="block">
            <span class="demonstration">Day</span>
            <el-date-picker
              v-model="value1"
              type="date"
              placeholder="search by the day"
              format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              @change="getDay"
            >
            </el-date-picker>
            <span class="demonstration">Month</span>
            <el-date-picker
              v-model="value3"
              type="month"
              placeholder="search by the month"
              @change="getMonth"
            >
            </el-date-picker>
            <span class="demonstration">Year</span>
            <el-date-picker
              v-model="value4"
              type="year"
              placeholder="search by the year"
              @change="getYear"
            >
            </el-date-picker>

            <div class="block" style="margin-top:10px;float:right">
              <span style="font-size:30px;color:red"
                ><small style="color:black">Total Sales:</small>${{
                  getTotal
                }}</span
              >
            </div>
          </div>
        </div>
      </el-row>
    </el-card>
    <!-- dish table-->
    <el-card style="margin-top:20px">
      <div class="often-goods-list">
        <ul>
          <li
            v-for="(goods, index) in orderListShow"
            :key="index"
            @click="getDetailList(goods.gmt_create)"
          >
            <small>{{ goods.gmt_create | formatDate }}</small
            ><br />
            <span>{{ goods.quantity }} <small>items</small></span
            ><br />
            <span style="color:red">&nbsp;${{ goods.total }}</span>
          </li>
        </ul>
      </div>
    </el-card>
    <el-dialog
      title="Order Detail"
      :visible.sync="dialogVisible"
      width="30%"
      @close="dialogClosed"
    >
      <el-table :data="detailList" style="width: 100%">
        <el-table-column prop="item" label="Item" width="180">
        </el-table-column>
        <el-table-column prop="item_count" label="Count" width="180">
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  created() {
    this.getOrderList();
  },
  data() {
    return {
      value1: "",
      value3: "",
      value4: "",
      orderList: [],
      dialogVisible: false,
      detailList: [],
      orderListShow: [],
    };
  },
  methods: {
    getDay() {
      let currentDay = this.orderList.filter(
        (ele) => this.formatDateBySearch(ele.gmt_create) === this.value1
      );
      this.orderListShow = this.filterFormatDate(currentDay);
      this.value3 = "";
      this.value4 = "";
      if (!this.value1) {
        location.reload();
      }
    },
    getMonth() {
      let currentMonth = this.orderListShow.filter(
        (ele) =>
          new Date(ele.gmt_create).getMonth() ===
          new Date(this.value3).getMonth()
      );
      this.orderListShow = currentMonth;
      this.value1 = "";
      this.value4 = "";
      if (!this.value3) {
        location.reload();
      }
    },
    getYear() {
      console.log(new Date(this.value4).getYear());
      let currentYear = this.orderListShow.filter(
        (ele) =>
          new Date(ele.gmt_create).getYear() === new Date(this.value4).getYear()
      );
      this.orderListShow = currentYear;
      this.value1 = "";
      this.value3 = "";
      if (!this.value4) {
        location.reload();
      }
    },
    getDetailList(time) {
      this.detailList = this.orderList.filter((ele) => ele.gmt_create === time);
      this.dialogVisible = true;
    },
    async getOrderList() {
      const res = await this.$http.get("/getorderList");
      this.orderList = res.data;
      this.orderListShow = this.filterFormatDate(this.orderList);
    },
    filterFormatDate(arr) {
      var obj = {};
      const newArr = arr.reduce((prev, cur) => {
        obj[cur.gmt_create]
          ? ""
          : (obj[cur.gmt_create] = true && prev.push(cur));
        return prev;
      }, []);
      return newArr;
    },
    formatDateBySearch(value) {
      var date = new Date(value);
      var y = date.getFullYear(); // 年份
      var m = date.getMonth() + 1; // 月份，注意：js里的月要加1
      if (m < 10) {
        m = "0" + m;
      }
      var d = date.getDate(); // 日
      if (d < 10) {
        d = "0" + d;
      }
      var h = date.getHours(); // 小时
      if (h < 10) {
        h = "0" + h;
      }
      var min = date.getMinutes(); // 分钟
      if (min < 10) {
        min = "0" + min;
      }
      // 返回值，根据自己需求调整，现在已经拿到了年月日时分秒了
      return y + "-" + m + "-" + d;
    },
    dialogClosed() {},
  },
  computed: {
    getTotal() {
      // return this.orderListShow.reduce((prev, cur) => prev + cur);
      let total = 0;
      this.orderListShow.map((item) => (total += item.total));
      return total.toFixed(2);
    },
  },
  filters: {
    formatDate(value) {
      var date = new Date(value);
      var y = date.getFullYear(); // 年份
      var m = date.getMonth() + 1; // 月份，注意：js里的月要加1
      if (m < 10) {
        m = "0" + m;
      }
      var d = date.getDate(); // 日
      if (d < 10) {
        d = "0" + d;
      }
      var h = date.getHours(); // 小时
      if (h < 10) {
        h = "0" + h;
      }
      var min = date.getMinutes(); // 分钟
      if (min < 10) {
        min = "0" + min;
      }
      // 返回值，根据自己需求调整，现在已经拿到了年月日时分秒了
      return y + "-" + m + "-" + d + " " + h + ":" + min;
    },
  },
};
</script>

<style lang="less" scoped>
// 面包屑样式
.el-breadcrumb {
  margin-bottom: 15px;
  font-size: 17px;
}
.often-goods-list ul li {
  list-style: none;
  float: left;
  border: 1px solid #e5e9f2;
  padding: 10px;
  margin: 10px;
  background-color: #fff;
  cursor: pointer;
}
</style>
