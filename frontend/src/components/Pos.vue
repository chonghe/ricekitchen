<template>
  <div class="pos">
    <div>
      <el-row>
        <el-col :span="7" class="pos-order" id="order-list">
          <el-tabs>
            <!-- <dinein :tableData="tableData" 
                  :totlaMoney="totlaMoney" 
                  :totalCount="totalCount"  
                  @delAllGoods="childTableData" 
                  @delSingleGoods="childTableData"
                  @getAllMoney="childTotalData"></dinein> -->
            <el-tab-pane label="Dine In">
              <orderlist
                :tableData="tableData"
                :totlaMoney="totlaMoney"
                :totalCount="totalCount"
                @delAllGoods="childDelAllGoods"
                @delSingleGoods="childDelAllGoods"
                @getAllMoney="childGetAllMoney"
              ></orderlist>
            </el-tab-pane>
            <el-tab-pane label="Pick Up">
              <el-card>
                <el-input
                  placeholder="Phone Number"
                  prefix-icon="el-icon-phone"
                  v-model="pickup.mobile"
                >
                </el-input>
                <el-input
                  placeholder="Customer Name"
                  prefix-icon="el-icon-user"
                  v-model="pickup.username"
                >
                </el-input>
                <el-input
                  placeholder="Remark"
                  prefix-icon="el-icon-collection-tag"
                  v-model="pickup.remark"
                >
                </el-input>
                <el-input
                  placeholder="Desc"
                  prefix-icon="el-icon-notebook-2"
                  v-model="pickup.desc"
                >
                </el-input>
              </el-card>
            </el-tab-pane>
            <el-tab-pane label="Delivery"> Delivery </el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="17">
          <!-- popular goods -->
          <div class="often-goods">
            <div class="title">Popular Food</div>
            <div class="often-goods-list">
              <ul>
                <li
                  v-for="goods in oftenGoods"
                  :key="goods.id"
                  @click="addOrderList(goods)"
                >
                  <small>{{ goods.code }}-</small>
                  <span>{{ goods.title }}</span>
                  <span class="o-price"
                    >&nbsp;${{ goods.price | numFilter }}</span
                  >
                </li>
              </ul>
            </div>
          </div>
          <!-- menulist -->
          <div class="goods-type">
            <el-tabs v-model="activeName">
              <el-tab-pane label="Soup-App-Drink" name="type0">
                <ul class="cookList">
                  <li
                    v-for="goods in type0Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp;${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="Veg-Diet-Indian" name="type1">
                <ul class="cookList">
                  <li
                    v-for="goods in type1Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp;${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="Lunch" name="type2">
                <ul class="cookList">
                  <li
                    v-for="goods in type2Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp;${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="Chicken-Pork" name="type3">
                <ul class="cookList">
                  <li
                    v-for="goods in type3Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp;${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="Beef-Shrimp-Chef" name="type4">
                <ul class="cookList">
                  <li
                    v-for="goods in type4Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp;${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
              <el-tab-pane label="Fried Rice-Lomein" name="type5">
                <ul class="cookList">
                  <li
                    v-for="goods in type5Goods"
                    :key="goods.id"
                    @click="addOrderList(goods)"
                  >
                    <small>{{ goods.code }}-</small><br />
                    <span>{{ goods.title }}</span>
                    <span
                      >&nbsp;&nbsp;&nbsp; ${{ goods.price | numFilter }}</span
                    >
                  </li>
                </ul>
              </el-tab-pane>
            </el-tabs>
            <!-- <el-tabs v-model="activeName">
              <el-tab-pane v-for="(type,index) in types" :key="type.id" 
              :label="type.title" :name="type.title" @click="handleTab(index)" :class="{active:type.id==num}">
                <div v-for="type in types" :key="type.id">
                  <ul class="cookList">
                    <li v-for="goods in type.mList" :key="goods.id"  v-show="index==num" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
                </div>
              </el-tab-pane>
            </el-tabs> -->
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import OrderList from "@/components/common/OrderList";
// import OftenGoods from "@/components/rightside/OftenGoods";
// import GoodType from "@/components/rightside/GoodType";
export default {
  components: {
    orderlist: OrderList,
    // often: OftenGoods,
    // type: GoodType,
  },
  name: "Pos",
  data() {
    return {
      pickup: {
        username: "",
        mobile: "",
        remark: "",
        desc: "",
      },
      totlaMoney: 0,
      totalCount: 0,
      tableData: [],
      oftenGoods: [],
      types: [],
      type0Goods: [],
      type1Goods: [],
      type2Goods: [],
      type3Goods: [],
      type4Goods: [],
      type5Goods: [],
      num: 0,
      activeName: "type0",
    };
  },
  created() {
    this.getCategory();
    this.getOftenGoods();
    this.getType0Goods();
    this.getType1Goods();
    this.getType2Goods();
    this.getType3Goods();
    this.getType4Goods();
    this.getType5Goods();
    //console.log(this.types[0]);
    //this.activeName = 'type0'
  },
  mounted() {
    var orderHeight = document.body.clientHeight;
    document.getElementById("order-list").style.height = orderHeight + "px";
  },
  methods: {
    handleTab(index) {
      console.log(index);
      alert(type.title);
    },
    async getCategory() {
      const { data: res } = await this.$http.get("typemenu");
      //console.log(res);
      this.types = res;
      //console.log(this.types[0].mList);
    },
    async getOftenGoods() {
      const { data: res } = await this.$http.get("oftengood");
      this.oftenGoods = res;
      //this.type0Goods = res
    },
    async getType0Goods() {
      const { data: res } = await this.$http.get("type0");
      this.type0Goods = res;
    },
    async getType1Goods() {
      const { data: res } = await this.$http.get("type1");
      this.type1Goods = res;
    },
    async getType2Goods() {
      const { data: res } = await this.$http.get("type2");
      this.type2Goods = res;
    },
    async getType3Goods() {
      const { data: res } = await this.$http.get("type3");
      this.type3Goods = res;
    },
    async getType4Goods() {
      const { data: res } = await this.$http.get("type4");
      this.type4Goods = res;
    },
    async getType5Goods() {
      const { data: res } = await this.$http.get("type5");
      this.type5Goods = res;
    },
    addOrderList(goods) {
      //每次添加前清空
      this.totlaMoney = 0;
      this.totalCount = 0;
      //商品是否存在
      let isHave = false;
      for (let i = 0; i < this.tableData.length; i++) {
        if (this.tableData[i].id == goods.id) {
          isHave = true;
        }
      }
      //逻辑
      if (isHave) {
        //改变列表中商品数量
        let arr = this.tableData.filter((o) => o.id == goods.id);
        arr[0].count++;
      } else {
        let newGoods = {
          id: goods.id,
          title: goods.title,
          price: goods.price,
          count: 1,
        };
        this.tableData.push(newGoods);
      }
      //计算汇总金额价格
      this.getAllMoney();
    },
    getAllMoney() {
      this.totlaMoney = 0;
      this.totalCount = 0;
      this.tableData.forEach((element) => {
        this.totalCount += element.count;
        this.totlaMoney = this.totlaMoney + element.price * element.count;
      });
    },
    childDelAllGoods(childValue, childValue1, childValue2) {
      this.tableData = childValue;
      this.totlaMoney = childValue1;
      this.totalCount = childValue2;
    },
    childGetAllMoney(childValue1, childValue2) {
      this.totlaMoney = childValue1;
      this.totalCount = childValue2;
    },
  },
  filters: {
    numFilter(value) {
      // 截取当前数据到小数点后两位
      let realVal = parseFloat(value).toFixed(2);
      return realVal;
    },
  },
};
</script>

<style scoped>
</style>
