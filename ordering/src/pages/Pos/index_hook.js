import React, { useState, useEffect } from "react";
import OrderList from "./OrderList";
import { Row, Col, Tabs } from "antd";
import pos from "./index.module.css";
import axios from "axios";

export default function Pos() {
  const [type0Goods, setType0Goods] = useState([]);
  const [type1Goods, setType1Goods] = useState([]);
  const [type2Goods, setType2Goods] = useState([]);
  const [type3Goods, setType3Goods] = useState([]);
  const [type4Goods, setType4Goods] = useState([]);
  const [type5Goods, setType5Goods] = useState([]);
  const [orderList, setOrderList] = useState([]);
  const [popularList, setPopularList] = useState([]);
  const [totalMoney, setTotalMoney] = useState(0);
  const [totalCount, setTotalCount] = useState(0);
  // const [isHave, setIsHave] = useState(false);

  useEffect(() => {
    axios.get("/api/oftengood").then((res) => {
      const data = res.data;
      setPopularList(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type0").then((res) => {
      const data = res.data;
      setType0Goods(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type1").then((res) => {
      const data = res.data;
      setType1Goods(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type2").then((res) => {
      const data = res.data;
      setType2Goods(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type3").then((res) => {
      const data = res.data;
      setType3Goods(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type4").then((res) => {
      const data = res.data;
      setType4Goods(data);
    });
  }, []);
  useEffect(() => {
    axios.get("/api/type5").then((res) => {
      const data = res.data;
      setType5Goods(data);
    });
  }, []);
  const { TabPane } = Tabs;
  // function callback(key) {
  //   // console.log(key);
  // }
  const addOrderList = (item) => {
    let isHave = false;
    for (let i = 0; i < orderList.length; i++) {
      if (orderList[i].id === item.id) {
        isHave = true;
      }
    }
    if (isHave) {
      //改变列表中商品数量
      let arr = orderList.filter((o) => o.id === item.id);
      arr[0].count++;
    } else {
      let newGoods = {
        id: item.id,
        title: item.title,
        price: item.price,
        count: 1,
      };
      setOrderList([...orderList, newGoods]);
    }
    //计算汇总金额价格
    // getAllMoney();
  };
  const getAllMoney = () => {
    // this.totlaMoney = 0;
    // this.totalCount = 0;
    orderList.forEach((element) => {
      // this.totalCount += element.count;
      setTotalCount(totalCount + element.count);
      // this.totlaMoney = this.totlaMoney + element.price * element.count;
      setTotalMoney(totalMoney + element.price * element.count);
    });
  };
  return (
    <div>
      <Row>
        <Col span={7}>
          <OrderList
            orderList={orderList}
            className={pos.posOrder}
            totalCount={totalCount}
            totalMoney={totalMoney}
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
                    <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
                      <li key={item.id} onClick={() => addOrderList(item)}>
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
