<template>
  <div>
    <el-table :data="copyFromParent" border style="width: 100%">
      <el-table-column prop="title" label="Good"></el-table-column>
      <el-table-column prop="count" label="Qty" width="70"></el-table-column>
      <el-table-column prop="price" label="Price" width="70"></el-table-column>
      <el-table-column label="Opration" width="100" fixed="right">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="delSingleGoods(scope.row)"
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
      <el-button type="danger" @click="delAllGoods()">Cancel</el-button>
      <el-button type="success" @click="checkout">Submit</el-button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    tableData: Array,
    totlaMoney: Number,
    totalCount: Number,
  },
  data() {
    return {
      //tableData: [],
      // totlaMoney:0,
      // totalCount:0,
      copyFromParent: this.tableData,
      totlaMoney1: this.totlaMoney,
      totalCount1: this.totalCount,
      dishId: [],
    };
  },
  methods: {
    addOrderList(goods) {
      this.totlaMoney1 = 0;
      this.totalCount1 = 0;
      let isHave = false;
      for (let i = 0; i < this.copyFromParent.length; i++) {
        if (this.copyFromParent[i].id == goods.id) {
          isHave = true;
        }
      }
      if (isHave) {
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
      //compute total
      this.getAllMoney();
    },
    delSingleGoods(goods) {
      if (goods.count <= 1) {
        //filter item when first goodsId is not equal second， tableData
        this.copyFromParent = this.copyFromParent.filter(
          (o) => o.id != goods.id
        );
      } else {
        goods.count--;
      }
      this.getAllMoney();
      this.$emit(
        "delSingleGoods",
        this.copyFromParent,
        this.totlaMoney1,
        this.totalCount1
      );
    },
    delAllGoods() {
      this.copyFromParent = [];
      this.totlaMoney1 = 0;
      this.totalCount1 = 0;
      //this.getAllMoney();
      this.$emit(
        "delAllGoods",
        this.copyFromParent,
        this.totlaMoney1,
        this.totalCount1
      ); //,this.copyFromParent,this.totlaMoney1,this.totalCount1
    },
    async checkout() {
      console.log(this.copyFromParent);

      //console.log(this.dishId);
      if (this.copyFromParent.length != 0) {
        const { data: res } = await this.$http.post("insertOrder", {
          quantity: this.totalCount,
          total: this.totlaMoney,
          orderList: this.copyFromParent,
        });

        if (res != "success") {
          return this.$message.error("Failed !!!");
        }
        this.$message.success("Success !!!");
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
      this.$emit("getAllMoney", this.totlaMoney1, this.totalCount1);
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

<style></style>
