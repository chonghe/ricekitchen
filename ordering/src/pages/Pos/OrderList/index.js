import React from "react";
import { Table, Tag, Space, Button } from "antd";
import orderList from "./index.module.css";

export default function OrderList(props) {
  const columns = [
    {
      title: "Good",
      dataIndex: "title",
      key: "title",
      render: (text) => <a>{text}</a>,
    },
    {
      title: "Qty",
      dataIndex: "count",
      key: "count",
    },
    {
      title: "Price",
      dataIndex: "price",
      key: "price",
    },
    {
      title: "Opration",
      key: "opration",
      render: (text, record) => (
        <Space size="middle">
          <a onClick={() => delGood(record)}>Delete</a>
          <a onClick={() => addOrderList(record)}>Add</a>
        </Space>
      ),
    },
  ];
  const addOrderList = (record) => {
    props.addOrderList(record);
  };
  const delAllGoods = () => {
    props.delAllGoods();
  };
  const delGood = (record) => {
    // console.log(id);
    props.delGood(record);
  };
  const onSubmit = () => {
    props.onSubmit();
  };
  return (
    <div>
      <Table
        columns={columns}
        dataSource={props.orderList}
        rowKey={(record) => {
          return record.id + Date.now();
        }}
      />
      <div>
        <small>Tax:</small>
        {(props.totalMoney * 0.0825).toFixed(2)}
      </div>
      <div className={orderList.totalDiv}>
        <small>Count:</small>
        {props.totalCount} &nbsp;&nbsp;&nbsp;&nbsp;
        <small>Total:</small>
        {(props.totalMoney + props.totalMoney * 0.0825).toFixed(2)}
      </div>

      <div className={orderList.divBtn}>
        <Button type="primary" danger onClick={delAllGoods}>
          Cancel
        </Button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <Button type="primary" onClick={onSubmit}>
          Submit
        </Button>
      </div>
    </div>
  );
}
