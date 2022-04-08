import React, { Component } from "react";
import OrderList from "./OrderList";
import { Row, Col, Tabs } from "antd";
import pos from "./index.module.css";
import axios from "axios";

export default class Pos extends Component {
  constructor(props) {
    super(props);
    this.state = {
      type0Goods: [],
      type1Goods: [],
      type2Goods: [],
      type3Goods: [],
      type4Goods: [],
      type5Goods: [],
      orderList: [],
      popularList: [],
      totalMoney: 0,
      totalCount: 0,
    };
  }
  componentDidMount() {
    axios.get("/api/oftengood").then((res) => {
      const data = res.data;
      this.setState({ popularList: data });
    });
    axios.get("/api/type0").then((res) => {
      const data = res.data;
      this.setState({ type0Goods: data });
    });
    axios.get("/api/type1").then((res) => {
      const data = res.data;
      this.setState({ type1Goods: data });
    });
    axios.get("/api/type2").then((res) => {
      const data = res.data;
      this.setState({ type2Goods: data });
    });
    axios.get("/api/type3").then((res) => {
      const data = res.data;
      this.setState({ type3Goods: data });
    });
    axios.get("/api/type4").then((res) => {
      const data = res.data;
      this.setState({ type4Goods: data });
    });
    axios.get("/api/type5").then((res) => {
      const data = res.data;
      this.setState({ type5Goods: data });
    });
  }
  addOrderList = (item) => {
    const { orderList } = this.state;
    let isHave = false;
    for (let i = 0; i < orderList.length; i++) {
      if (orderList[i].id === item.id) {
        isHave = true;
      }
    }
    if (isHave) {
      let arr = orderList.filter((o) => o.id === item.id);
      arr[0].count++;
      this.setState({ orderList: orderList }, () => {
        this.getAllMoney();
      });
    } else {
      let newGoods = {
        id: item.id,
        title: item.title,
        price: item.price,
        count: 1,
      };
      this.setState({ orderList: [...orderList, newGoods] }, () => {
        this.getAllMoney();
      });
    }
  };
  getAllMoney = () => {
    const { orderList } = this.state;
    let list = [...orderList];
    let total = 0;
    let num = 0;

    list.forEach((item) => {
      total += item.price * item.count;
      num += item.count;
    });
    this.setState({
      totalCount: num,
      totalMoney: total,
    });
  };
  delAllGoods = () => {
    this.setState({ orderList: [] });
    this.setState({ totalCount: 0 });
    this.setState({ totalMoney: 0 });
  };
  delGood = (record) => {
    if (record.count <= 1) {
      this.setState(
        {
          orderList: this.state.orderList.filter((obj) => obj.id !== record.id),
        },
        () => this.getAllMoney()
      );
    } else {
      record.count--;
      this.setState({ orderList: this.state.orderList }, () => {
        this.getAllMoney();
      });
    }
  };
  onSubmit = () => {
    if (this.state.orderList.length !== 0) {
      axios.post("/api/insertorder", {
        quantity: this.state.totalCount,
        total: this.state.totalMoney,
        orderList: this.state.orderList,
      });
      this.delAllGoods();
    }
  };
  render() {
    const {
      popularList,
      orderList,
      type0Goods,
      type1Goods,
      type2Goods,
      type3Goods,
      type4Goods,
      type5Goods,
      totalCount,
      totalMoney,
    } = this.state;
    const { TabPane } = Tabs;
    return (
      <div>
        <Row>
          <Col span={7}>
            <OrderList
              orderList={orderList}
              className={pos.posOrder}
              totalCount={totalCount}
              totalMoney={totalMoney}
              delAllGoods={this.delAllGoods}
              delGood={this.delGood}
              addOrderList={this.addOrderList}
              onSubmit={this.onSubmit}
            />
          </Col>
          <Col span={17}>
            {/* popular list */}
            <div>
              <div className={pos.title}>Popular Food</div>
              <div className={pos.oftenGoodsList}>
                <ul>
                  {popularList.map((item, index) => {
                    return (
                      <li key={item.id} onClick={() => this.addOrderList(item)}>
                        <small>{item.code}</small>
                        <span>{item.title}</span>
                        <span className={pos.oPrice}>&nbsp;${item.price}</span>
                      </li>
                    );
                  })}
                </ul>
              </div>
            </div>
            {/* menulist */}
            <div className={pos.goodsType}>
              <Tabs defaultActiveKey="1">
                <TabPane tab="Soup-App-Drink" key="1">
                  <ul className={pos.cookList}>
                    {type0Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          {item.code === "SP1" || item.code === "SP1.1" ? (
                            <img
                              src={require(`../../assets/${item.code}.png`)}
                            />
                          ) : (
                            ""
                          )}
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
                <TabPane tab="Veg-Diet-Indian" key="2">
                  <ul className={pos.cookList}>
                    {type1Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
                <TabPane tab="Lunch" key="3">
                  <ul className={pos.cookList}>
                    {type2Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
                <TabPane tab="Chicken-Pork" key="4">
                  <ul className={pos.cookList}>
                    {type3Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
                <TabPane tab="Beef-Shrimp-Chef" key="5">
                  <ul className={pos.cookList}>
                    {type4Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
                <TabPane tab="Fried Rice-Lomein" key="6">
                  <ul className={pos.cookList}>
                    {type5Goods.map((item, index) => {
                      return (
                        <li
                          key={item.id}
                          onClick={() => this.addOrderList(item)}
                        >
                          <small>{item.code}-</small>
                          <br />
                          <span>{item.title}</span>
                          <span>&nbsp;&nbsp;&nbsp;${item.price}</span>
                        </li>
                      );
                    })}
                  </ul>
                </TabPane>
              </Tabs>
            </div>
          </Col>
        </Row>
      </div>
    );
  }
}
