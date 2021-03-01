<template>
  <div class="pos">
    <div>
      <el-row>
        <el-col :span="7" class="pos-order" id="order-list">
          <el-tabs>
            <el-tab-pane label="Dine In">
              <el-table
                :data="tableData"
                border
                style="width: 100%"
              >
                <el-table-column
                  prop="title"
                  label="Good"
                ></el-table-column>
                <el-table-column
                  prop="count"
                  label="Qty"
                  width="70"
                ></el-table-column>
                <el-table-column
                  prop="price"
                  label="Price"
                  width="70"
                ></el-table-column>
                <el-table-column label="Opration" width="100" fixed="right">
                  <template slot-scope="scope">
                    <el-button type="text" size="small" @click="delSingleGoods(scope.row)">Delete</el-button>
                    <el-button type="text" size="small" @click="addOrderList(scope.row)">Add</el-button>
                  </template>
                </el-table-column>
              </el-table>
              <div><small>Tax:</small> {{totlaMoney*0.0825 | numFilter}}</div>
            <div class="totalDiv">
                <small>Count:</small> {{totalCount}} &nbsp;&nbsp;&nbsp;&nbsp; 
                <small>Total:</small> {{totlaMoney+(totlaMoney*0.0825) | numFilter}}
            </div>
                

              <div class="div-btn">
                <!-- <el-button type="warning" >挂单</el-button> -->
                <el-button type="danger" @click="delAllGoods()">Cancel</el-button>
                <el-button type="success" @click="checkout">Submit</el-button>
              </div>
            </el-tab-pane>
            <el-tab-pane label="Pick Up"> Pick Up </el-tab-pane>
            <el-tab-pane label="Delivery"> Delivery </el-tab-pane>
          </el-tabs>
        </el-col>
        <el-col :span="17">
          <div class="often-goods">
            <div class="title">Popular Food</div>
            <div class="often-goods-list">
              <ul>
                <li v-for="goods in oftenGoods" :key="goods.id" @click="addOrderList(goods)">
                    <small>{{goods.code}}-</small>
                    <span>{{goods.title}}</span>
                    <span class="o-price">{{goods.price | numFilter}}</span>
                </li>
              </ul>
            </div>
          </div>

          <div class="goods-type">
            <el-tabs v-model="activeName">
              <el-tab-pane label="Soup-App-Drink" name="type0">
                <ul class="cookList">
                    <li v-for="goods in type0Goods" :key="goods.id" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
              </el-tab-pane>
              <el-tab-pane label="Veg-Diet-Indian" name="type1">
                <ul class="cookList">
                    <li v-for="goods in type1Goods" :key="goods.id" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
              </el-tab-pane>
              <el-tab-pane label="Lunch" name="type2">
                <ul class="cookList">
                    <li v-for="goods in type2Goods" :key="goods.id" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
              </el-tab-pane>
              <el-tab-pane label="Chicken-Pork" name="type3">
                <ul class="cookList">
                    <li v-for="goods in type3Goods" :key="goods.id"  @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
              </el-tab-pane>
              <el-tab-pane label="Beef-Shrimp-Chef" name="type4">
                <ul class="cookList">
                    <li v-for="goods in type4Goods" :key="goods.id" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
                    </li>
                  </ul>
              </el-tab-pane>
              <el-tab-pane label="Fried Rice-Lomein" name="type5">
                <ul class="cookList">
                    <li v-for="goods in type5Goods" :key="goods.id" @click="addOrderList(goods)">
                        <small>{{goods.code}}-</small><br>
                        <span>{{goods.title}}</span>
                        <span>${{goods.price | numFilter}}</span>
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
export default {
  name: "Pos",
  data() {
    return {
      tableData: [],
      oftenGoods: [],
      types:[],
      type0Goods: [],
      type1Goods:[],
      type2Goods:[],
      type3Goods:[],
      type4Goods:[],
      type5Goods:[],
      num:0,
      totlaMoney:0,
      totalCount:0,
      activeName:"type0",
    };
  },
  created(){
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
    handleTab(index){
        console.log(index);
        alert(type.title);
    },
    addOrderList(goods){
        //每次添加前清空
        this.totlaMoney=0;
        this.totalCount=0;
        //商品是否存在
        let isHave = false;
        for(let i=0;i<this.tableData.length;i++){
            if(this.tableData[i].id==goods.id){
                isHave=true
            }
        }
        //逻辑
        if(isHave){
            //改变列表中商品数量
            let arr = this.tableData.filter(o => o.id == goods.id);
            arr[0].count++;
        }else{
            let newGoods={id:goods.id,title:goods.title,price:goods.price,count:1};
            this.tableData.push(newGoods)
        }
        //计算汇总金额价格
        this.getAllMoney();
    },
    delSingleGoods(goods){
        if(goods.count<=1){
            //过滤item 当的第一个goodsId不等于第二个的， 剩下的所有item重新赋值给新的tableData
            this.tableData = this.tableData.filter(o => o.id != goods.id);
        }else{
            goods.count--;
        }
        this.getAllMoney();

    },
    delAllGoods(){
        this.tableData=[];
        this.totlaMoney=0;
        this.totalCount=0;
    },
    getAllMoney(){
        this.totlaMoney=0;
        this.totalCount=0;
        this.tableData.forEach(element => {
            this.totalCount += element.count;
            this.totlaMoney = this.totlaMoney+(element.price*element.count);
        })
    },
    checkout(){
        if(this.totalCount!=0){
            this.delAllGoods();
            this.$message({
                message:'Submit Success!',
                type:'success'
            })
        }else{
            this.$message.error("List is empty!")
        }
    },
    async getCategory(){
      const {data:res} = await this.$http.get("typemenu");
      //console.log(res);
      this.types = res
      //console.log(this.types[0].mList);
    },
    async getOftenGoods(){
      const{data:res} = await this.$http.get("oftengood");
      this.oftenGoods = res
      //this.type0Goods = res
    },
    async getType0Goods(){
      const{data:res} = await this.$http.get("type0");
      this.type0Goods = res
    },
    async getType1Goods(){
      const{data:res} = await this.$http.get("type1");
      this.type1Goods = res
    },
    async getType2Goods(){
      const{data:res} = await this.$http.get("type2");
      this.type2Goods = res
    },
    async getType3Goods(){
      const{data:res} = await this.$http.get("type3");
      this.type3Goods = res
    },
    async getType4Goods(){
      const{data:res} = await this.$http.get("type4");
      this.type4Goods = res
    },
    async getType5Goods(){
      const{data:res} = await this.$http.get("type5");
      this.type5Goods = res
    },
  },
  filters: {
  numFilter (value) {
    // 截取当前数据到小数点后两位
    let realVal = parseFloat(value).toFixed(2)
    return realVal
  }
}
};
</script>

<style scoped>
.pos-order {
  background-color: #f9fafc;
  border-right: 1px solid #c0ccda;
  height: 100%;
}
.div-btn {
  margin-top: 10px;
}
.title {
  height: 20px;
  border-bottom: 1px solid #d3dce6;
  background-color: #f9fafc;
  padding: 10px;
  text-align: left;
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
.o-price{
    color: #58b7ff;
}
.goods-type {
  clear: both;
  /* height: auto;
  overflow: hidden;
  border-top: 1px solid #d3dce6; */
}
.cookList li {
  list-style: none;
  width: 23%;
  border: 1px solid #e5e9f2;
  height: 70px;
  overflow: hidden;
  background-color: #fff;
  padding: 2px;
  float: left;
  margin: 2px;
  cursor: pointer;
}
.cookList li span {
  /* padding: 2px; */
  display: block;
  height: 60px;
  float: left;
}
.foodImg {
  width: 40%;
}
.foodName {
  font-size: 18px;
  padding-left: 10px;
  color: brown;
  text-align: center;
}
.foodPrice {
  font-size: 16px;
  padding-left: 10px;
  padding-top: 10px;
}
.totalDiv{
    background-color: #fff;
    padding: 10px;
    border-bottom: 1px solid #d3dce6;
}
/* .el-table{
overflow:hidden !important;
} */
</style>
