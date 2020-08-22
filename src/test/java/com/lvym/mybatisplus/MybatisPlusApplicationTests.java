package com.lvym.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lvym.mybatisplus.config.MybatisPlusPage;
import com.lvym.mybatisplus.dao.UserMapper;
import com.lvym.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void insert() {

        User user = new User();
        user.setEmail("fdffff@32156");
        user.setAge(24);
        user.setName("5454");
        user.setManagerId(1094592041087729666L);
        User user2 = new User();
        user2.setEmail("fdffff@32156");
        user2.setAge(27);
        user2.setName("666666666666");
        user2.setManagerId(1094592041087729666L);
        int i = userMapper.insertBatchSomeColumn(Arrays.asList(user, user2));
        System.out.println(i);


    }
    @Test
    public void deleteByid() {
        int deleteById = userMapper.deleteById(1279318799065030657L);
        System.out.println(deleteById);
    }
    @Test
    public void updatetby() {


        User user = new User();
        user.setId(1279337093717409794L);
        user.setAge(22);

        int updateById = userMapper.updateById(user);
        System.out.println(updateById);
    }
    @Test
    public void queryby() {
        MybatisPlusPage.myTableName.set("user_....");
        User user = new User();
        user.setId(1279337093717409794L);
        User user1 = user.selectById();
        System.out.println(user1);
    }
    @Test
    public void queryby02() {

        List<User> list = userMapper.getall();
        System.out.println(list);
    }

    @Test
    public void delete() {

        User user = new User();
        user.setId(1279606104346595329L);
        user.setAge(25);
        user.setName("0000000");// 没有加 @TableField(fill = FieldFill.UPDATE)   //  update 时  填充无效

        userMapper.deleteByIdWithFill(user);
    }

    @Test
    public void update() {

        User user = new User();
        user.setId(1094590409767661570L);
        user.setAge(23);
        user.setName("0000000");// 排除了，不会修改成功,，没有赋予值的字段自动填充null值，所以最好都赋予值

        userMapper.alwaysUpdateSomeColumnById(user);
    }


}
