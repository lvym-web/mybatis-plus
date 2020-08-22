package com.lvym.mybatisplus.commonts;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 填充处理器
 */

@Component
public class MybatisPlusHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
                                           //判断实体类有没有setCreateTime方法，有才进入
        boolean createTime = metaObject.hasSetter("createTime");
        if (createTime){
                       setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
                               //判断参加update语句中有没有设置 user.setUpdateTime(LocalDateTime.now());, 没有就进入
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime==null){
            System.out.println("****************************************");
                       setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }

    }
}
