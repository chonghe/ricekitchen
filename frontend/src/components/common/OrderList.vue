<template>
  <div>
      <el-table :data="copyFromParent" border style="width: 100%">
        <el-table-column prop="title" label="Good"></el-table-column>
        <el-table-column prop="count" label="Qty" width="70"></el-table-column>
        <el-table-column
          prop="price"
          label="Price"
          width="70"
        ></el-table-column>
        <el-table-column label="Opration" width="100" fixed="right">
          <template slot-scope="scope">
            <el-button
              type="text"
              size="small"
              @click="delSingleGoods(scope.row)"
              >Delete</el-button
            >
            <el-button type="text" size="small" @click="addOrderList(scope.row)"
              >Add</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <div><small>Tax:</small> {{ (totlaMoney * 0.0825) | numFilter }}</div>
      <div class="totalDiv">
        <small>Count:</small> {{ totalCount }} &nbsp;&nbsp;&nbsp;&nbsp;
        <small>Total:</small>
        {{ (totlaMoney + totlaMoney * 0.0825) | numFilter }}
      </div>

      <div class="div-btn">
        <!-- <el-button type="warning" >挂单</el-button> -->
        <el-button type="danger" @click="delAllGoods()">Cancel</el-button>
        <el-button type="success" @click="checkout">Submit</el-button>
      </div>
  </div>
</template>

<script>
export default {
    props:{
    tableData:Array,
    totlaMoney:Number,
    totalCount:Number
  },
  data() {
    return {
      //tableData: [],
      // totlaMoney:0,
      // totalCount:0,
      copyFromParent:this.tableData,
      totlaMoney1:this.totlaMoney,
      totalCount1:this.totalCount
    }
  },
  methods: {
    addOrderList(goods) {
      //每次添加前清空
      this.totlaMoney1 = 0;
      this.totalCount1 = 0;
      //商品是否存在
      let isHave = false;
      for (let i = 0; i < this.copyFromParent.length; i++) {
        if (this.copyFromParent[i].id == goods.id) {
          isHave = true;
        }
      }
      //逻辑
      if (isHave) {
        //改变列表中商品数量
        let arr = this.copyFromParent.filter((o) => o.id == goods.id);
        arr[0].count++;
      } else {
        let newGoods = {
          id: goods.id,
          title: goods.title,
          price: goods.price,
          count: 1,
        };
        this.copyFromParent.push(newGoods);
      }
      //计算汇总金额价格
      this.getAllMoney();
    },
    delSingleGoods(goods) {
      if (goods.count <= 1) {
        //过滤item 当的第一个goodsId不等于第二个的， 剩下的所有item重新赋值给新的tableData
        this.copyFromParent = this.copyFromParent.filter((o) => o.id != goods.id);
      } else {
        goods.count--;
      }
      this.getAllMoney();
      this.$emit('delSingleGoods',this.copyFromParent,this.totlaMoney1,this.totalCount1)
    },
    delAllGoods() {
      this.copyFromParent = [];
      this.totlaMoney1 = 0;
      this.totalCount1 = 0;
      //this.getAllMoney();
      this.$emit('delAllGoods',this.copyFromParent,this.totlaMoney1,this.totalCount1) //,this.copyFromParent,this.totlaMoney1,this.totalCount1
    },
    checkout() {
      if (this.copyFromParent.length != 0) {
        this.delAllGoods();
        this.$message({
          message: "Submit Success!",
          type: "success",
        });
      } else {
        this.$message.error("List is empty!");
      }
    },
    getAllMoney() {
      this.totlaMoney1 = 0;
      this.totalCount1 = 0;
      this.copyFromParent.forEach((element) => {
        this.totalCount1 += element.count;
        this.totlaMoney1 = this.totlaMoney1 + element.price * element.count;
      });
      this.$emit('getAllMoney',this.totlaMoney1,this.totalCount1)
    },
  },
  filters: {
    numFilter(value) {
      // 截取当前数据到小数点后两位
      let realVal = parseFloat(value).toFixed(2);
      return realVal;
    },
  },
}
</script>

<style>

</style>