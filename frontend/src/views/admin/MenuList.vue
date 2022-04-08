<template>
  <div>
    Menu List
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Menu manage</el-breadcrumb-item>
      <!-- <el-breadcrumb-item>User manage</el-breadcrumb-item> -->
    </el-breadcrumb>
    <!-- main part -->
    <el-card>
      <el-row :gutter="25">
        <!-- search -->
        <el-col :span="10">
          <el-input
            placeholder="search by good's title"
            v-model="queryInfo.query"
            clearable
            @clear="getMenuList"
          >
            <el-button
              slot="append"
              icon="el-icon-search"
              @click="getMenuList"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialogVisible = true"
            >Add Good</el-button
          >
        </el-col>
      </el-row>
      <!-- dish table-->
      <el-table :data="dishList" border stripe>
        <el-table-column type="index"></el-table-column>
        <el-table-column label="Code" prop="code"></el-table-column>
        <el-table-column label="Good Title" prop="title"></el-table-column>
        <el-table-column label="Price" prop="price"></el-table-column>
        <el-table-column label="Status" prop="state">
          <!-- 作用域插槽 -->
          <template slot-scope="scope">
            <!-- {{scope.row}} 每一行封存的数据-->
            <el-switch
              v-model="scope.row.state"
              @change="userStateChanged(scope.row)"
            ></el-switch>
          </template>
        </el-table-column>
        <el-table-column label="Option">
          <template slot-scope="scope">
            <!-- 修改 -->
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              @click="showEditDialog(scope.row.id)"
            ></el-button>
            <!-- 删除 -->
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              @click="deleteDish(scope.row.id)"
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页组件 size-change 每页最大变化书 current-change 当前最大变化 layout功能组件-->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNum"
        :page-sizes="[1, 2, 5, 100]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>
    </el-card>

    <!-- add dish -->
    <el-dialog
      title="Add Goods"
      :visible.sync="addDialogVisible"
      width="50%"
      @close="addDialogClosed"
    >
      <el-form :model="addForm" ref="addFormRef" label-width="70px">
        <el-form-item label="Code" prop="code">
          <el-input v-model="addForm.code"></el-input>
        </el-form-item>
        <el-form-item label="Title" prop="title">
          <el-input v-model="addForm.title"></el-input>
        </el-form-item>
        <el-form-item label="Price" prop="price">
          <el-input v-model="addForm.price"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="addDish">Confirm</el-button>
      </span>
    </el-dialog>

    <!-- modify dish -->
    <el-dialog
      title="Edit Goods"
      :visible.sync="editDialogVisible"
      width="50%"
      @close="editDialogClosed"
    >
      <el-form :model="editForm" ref="editFormRef" label-width="70px">
        <el-form-item label="Code" prop="code">
          <el-input v-model="editForm.code"></el-input>
        </el-form-item>
        <el-form-item label="Title" prop="title">
          <el-input v-model="editForm.title"></el-input>
        </el-form-item>
        <el-form-item label="Price" prop="price">
          <el-input v-model="editForm.price"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="editDish">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  created() {
    this.getMenuList();
  },
  data() {
    return {
      //查询信息实体
      queryInfo: {
        query: "", //查询信息
        pageNum: 1, //当前页
        pageSize: 5, //每页最大数
      },
      dishList: [], //用户列表
      total: 0, //总记录数
      addDialogVisible: false, //对话框状态
      addForm: {
        title: "",
        code: "",
        price: "",
      },
      editForm: {},
      editDialogVisible: false,
    };
  },
  methods: {
    async getMenuList() {
      const { data: res } = await this.$http.get("allmenu", {
        params: this.queryInfo,
      });
      this.dishList = res.data;
      this.total = res.numbers;
    },
    //最大数
    handleSizeChange(newSize) {
      this.queryInfo.pageSize = newSize;
      this.getMenuList();
    },
    //pageNum的触发动作
    handleCurrentChange(newPage) {
      this.queryInfo.pageNum = newPage;
      this.getMenuList();
    },
    async userStateChanged(userInfo) {
      const { data: res } = await this.$http.put(
        `userstate?id=${userInfo.id}&state=${userInfo.state}`
      );
      if (res != "success") {
        userInfo.id = !userInfo.id;
        return this.$message.error("Failed !!!");
      }
      this.$message.success("success !!!");
    },
    addDialogClosed() {
      this.$refs.addFormRef.resetFields();
    },
    addDish() {
      this.$refs.addFormRef.validate(async (valid) => {
        if (!valid) return;
        const { data: res } = await this.$http.post("adddish", this.addForm);
        if (res != "success") {
          return this.$message.error("Failed !!!");
        }
        this.$message.success("Success !!!");
        this.addDialogVisible = false;
        this.getMenuList();
      });
    },
    async deleteDish(id) {
      const confirmResult = await this.$confirm("Are you sure?", "warning", {
        confirmButtonText: "confirm",
        cancelButtonText: "cancel",
        type: "warning",
      }).catch((err) => err);
      if (confirmResult != "confirm") {
        //取消
        return this.$message.info("canceled");
      }
      const { data: res } = await this.$http.delete("deletedish?id=" + id);
      if (res != "success") {
        return this.$message.error("Failed !!!");
      }
      this.$message.success("Success !!!");
      this.getMenuList();
    },
    //修改操作
    //显示对话框
    async showEditDialog(id) {
      const { data: res } = await this.$http.get("getupdate?id=" + id);
      this.editForm = res;
      this.editDialogVisible = true;
    },
    //关闭窗口
    editDialogClosed() {
      this.$refs.editFormRef.resetFields(); //重置信息
    },
    //确认修改
    editDish() {
      this.$refs.editFormRef.validate(async (valid) => {
        if (!valid) return;
        const { data: res } = await this.$http.put("editdish", this.editForm);
        if (res != "success") {
          return this.$message.error("Failed !!!");
        }
        this.$message.success("Success !!!");
        //隐藏对话框
        this.editDialogVisible = false;
        this.getMenuList();
      });
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
</style>
