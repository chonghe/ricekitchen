package com.cping.ricekitchen.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component  //一定不要忘记把处理器加到IOC容器中
public class MyHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
//        this.strictUpdateFill(metaObject, "gmtCreate", () -> LocalDateTime.now(), LocalDateTime.class);
//        this.strictUpdateFill(metaObject, "gmtModified", () -> LocalDateTime.now(), LocalDateTime.class);
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        //this.strictUpdateFill(metaObject, "gmtModified", () -> LocalDateTime.now(), LocalDateTime.class);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
