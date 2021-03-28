package com.cping.ricekitchen.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cping.ricekitchen.common.Result;
import com.cping.ricekitchen.entity.Customer;
import com.cping.ricekitchen.entity.Menu;
import com.cping.ricekitchen.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@RestController
@RequestMapping("/ricekitchen/menu")
public class MenuController {

    @Autowired
    MenuMapper menuMapper;

    @GetMapping("/allMenu")
    public Result getAllMenu() {
        List<Menu> menus = menuMapper.selectList(null);
        return Result.success(menus);
    }

    @GetMapping("/byMenu/{title}")
    public Result getMenuByTitle(@PathVariable("title") String title) {
        List<Map<String, Object>> list = menuMapper.selectMaps(new QueryWrapper<Menu>().like("title", title));
        return Result.success(list);
    }

    @PostMapping("/insertMenu")
    public Result insertMenu(@RequestBody Menu menu) {
        int insert = menuMapper.insert(menu);
        if (insert == 0) {
            return Result.fail("Add menu failed");
        }
        return null;
    }

    @PutMapping("/updateMenu")
    public Result updateMenu(@RequestBody Menu menu) {
        int i = menuMapper.updateById(menu);
        if (i == 0) {
            return Result.fail("Update menu failed");
        }
        return null;
    }

    @DeleteMapping("/deleteMenu/{id}")
    public Result deleteMenu(@PathVariable("id") Integer id) {
        int i = menuMapper.deleteById(id);
        if (i == 0) {
            return Result.fail("Delete menu failed");
        }
        return null;
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        int i = menuMapper.updateState(id, state);
        return i > 0 ? "success" : "error";
    }
    /*右上部*/
    @GetMapping("/oftengood")
    public Result getOftenGoods() {
        List<Menu> oftenGoods = menuMapper.selectList(new QueryWrapper<Menu>().eq("state", 1));
        return Result.success(oftenGoods);
    }

    /*右下部*/
    @GetMapping("/type0")
    public Result getType0() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",101,102,105));
        return Result.success(type0Goods);
    }

    @GetMapping("/type1")
    public Result getType1() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",103,104,107));
        return Result.success(type0Goods);
    }

    @GetMapping("/type2")
    public Result getType2() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",106));
        return Result.success(type0Goods);
    }

    @GetMapping("/type3")
    public Result getType3() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",108,109));
        return Result.success(type0Goods);
    }

    @GetMapping("/type4")
    public Result getType4() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",110,111,113));
        return Result.success(type0Goods);
    }

    @GetMapping("/type5")
    public Result getType5() {
        List<Menu> type0Goods = menuMapper.selectList(new QueryWrapper<Menu>().in("cid",112));
        return Result.success(type0Goods);
    }
}

