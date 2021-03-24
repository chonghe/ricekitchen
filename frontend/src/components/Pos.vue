<template>
  <div class="pos">
    <div>
      <el-row>
        <el-col :span="7" class="pos-order" id="order-list">
          <el-tabs v-model="leftActiveName" @tab-click="test">
            <!-- Dine In -->
            <el-tab-pane label="Dine In" name="dinein" id="1">
              <!-- Order List  -->
              <orderlist
                :tableData="tableData"
                :totlaMoney="totlaMoney"
                :totalCount="totalCount"
                @delAllGoods="childDelAllGoods"
                @delSingleGoods="childDelAllGoods"
                @getAllMoney="childGetAllMoney"
              ></orderlist>
            </el-tab-pane>
            <!-- Pick Up Tabs -->
            <el-tab-pane label="Pick Up" name="pickup">
              <el-form ref="pickup" :model="pickup" label-width="80px">
                <el-form-item label="Phone">
                  <el-input
                  placeholder="Phone Number"
                  prefix-icon="el-icon-phone"
                  v-model="pickup.mobile"
                  >
                  </el-input>
                </el-form-item>
                <el-form-item label="Name">
                  <el-input
                  placeholder="Customer Name"
                  prefix-icon="el-icon-user"
                  v-model="pickup.username"
                >
                </el-input>
                </el-form-item>
                <el-form-item label="Remark">
                  <el-input
                  placeholder="Remark"
                  prefix-icon="el-icon-collection-tag"
                  v-model="pickup.remark"
                >
                </el-input>
                </el-form-item>
                <el-form-item label="Desc">
                  <el-input
                  type="textarea"
                  :rows="2"
                  placeholder="Description"
                  prefix-icon="el-icon-s-comment"
                  v-model="pickup.desc"
                >
                </el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="danger">Cancel</el-button
                  >
                  <el-button type="success" @click="toDinein">Submit</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
            <!-- Delivery Tab -->
            <el-tab-pane label="Delivery" name="delivery">
              <el-form ref="delivery" :model="delivery" label-width="80px">
                <el-form-item label="Phone">
                  <el-input
                  placeholder="Phone Number"
                  prefix-icon="el-icon-phone"
                  v-model="delivery.mobile"
                  >
                  </el-input>
                </el-form-item>
                <el-form-item label="Address">
                  <el-input
                  placeholder="Address"
                  prefix-icon="el-icon-s-home"
                  v-model="delivery.address"
                  >
                  </el-input>
                </el-form-item>
                <el-form-item label="Name">
                  <el-input
                  placeholder="Customer Name"
                  prefix-icon="el-icon-user"
                  v-model="delivery.username"
                >
                </el-input>
                </el-form-item>
                <el-form-item label="Remark">
                  <el-input
                  placeholder="Remark"
                  prefix-icon="el-icon-collection-tag"
                  v-model="delivery.remark"
                >
                </el-input>
                </el-form-item>
                <el-form-item label="Desc">
                  <el-input
                  type="textarea"
                  :rows="2"
                  placeholder="Description"
                  prefix-icon="el-icon-s-comment"
                  v-model="delivery.desc"
                >
                </el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="danger">Cancel</el-button
                  >
                  <el-button type="success" @click="toDinein">Submit</el-button>
                </el-form-item>
              </el-form>
            </el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col v-show="leftActiveName=='dinein'" :span="17">
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
            <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
              <el-form :model="form">
                <el-form-item label="活动名称" :label-width="formLabelWidth">
                  <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="活动区域" :label-width="formLabelWidth">
                  <el-select v-model="form.region" placeholder="请选择活动区域">
                    <el-option label="区域一" value="shanghai"></el-option>
                    <el-option label="区域二" value="beijing"></el-option>
                  </el-select>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false"
                  >确 定</el-button
                >
              </div>
            </el-dialog>
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
      delivery:{
        mobile:'',
        address:'',
        username:'',
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
      leftActiveName:"dinein",

      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px'
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
    toDinein(){
      this.leftActiveName = "dinein"
    },
    test(tab,event){
      console.log(tab.$attrs['id'])
    }
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
