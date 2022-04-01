package com.cping.ricekitchenpos.controller;

import com.alibaba.fastjson.JSON;
import com.cping.ricekitchenpos.dao.MenuDao;
import com.cping.ricekitchenpos.entity.Menu;
import com.cping.ricekitchenpos.entity.MenuQueryInfo;
import com.cping.ricekitchenpos.entity.TypeMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @GetMapping("/oftengood")
    public String getOftenGoods() {
        List<Menu> oftenGoods = menuDao.getOftenGoods();
        return JSON.toJSONString(oftenGoods);
    }

    @RequestMapping("/allmenu")
    public String getDishList(MenuQueryInfo queryInfo) {
        System.out.println(queryInfo);
        //获取最大列表数和当前编号
        //模糊查询 也可以在set方法中写
        int numbers = menuDao.getDishCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<Menu> users = menuDao.getAllDish("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        System.out.println("总条数：" + numbers);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/userstate")
    public String updateDishState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        int i = menuDao.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/adddish")
    public String Menu(@RequestBody Menu menu) {
        //user.setRole("user");
        menu.setState(false);
        int i = menuDao.addDish(menu);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deletedish")
    public String deleteMenu(int id) {
        int i = menuDao.deleteDish(id);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getupdate")
    public String getUpdateMenu(int id){
        Menu menu = menuDao.getUpdateDish(id);
        String string = JSON.toJSONString(menu);
        return string;
    }

    @RequestMapping("/editdish")
    public String editMenu(@RequestBody Menu menu) {
        int i = menuDao.editDish(menu);
        return i > 0 ? "success" : "error";
    }

    @GetMapping("/type0")
    public String getType0() {
        List<Menu> type0Goods = menuDao.getType0Goods();
        return JSON.toJSONString(type0Goods);
    }

    @GetMapping("/type1")
    public String getType1() {
        List<Menu> type0Goods = menuDao.getType1Goods();
        return JSON.toJSONString(type0Goods);
    }

    @GetMapping("/type2")
    public String getType2() {
        List<Menu> type0Goods = menuDao.getType2Goods();
        return JSON.toJSONString(type0Goods);
    }

    @GetMapping("/type3")
    public String getType3() {
        List<Menu> type0Goods = menuDao.getType3Goods();
        return JSON.toJSONString(type0Goods);
    }

    @GetMapping("/type4")
    public String getType4() {
        List<Menu> type0Goods = menuDao.getType4Goods();
        return JSON.toJSONString(type0Goods);
    }

    @GetMapping("/type5")
    public String getType5() {
        List<Menu> type0Goods = menuDao.getType5Goods();
        return JSON.toJSONString(type0Goods);
    }
}
