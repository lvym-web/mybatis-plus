package com.lvym.mybatisplus.entity;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class User extends Model<User> {


    private Long id;
    private String name;
    @TableField(fill = FieldFill.UPDATE)   //  update 时  填充
    private Integer age;
    private String email;
    private Long managerId;
    @TableField(fill = FieldFill.INSERT) //insert 时  填充
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)   //  update 时  填充
    private LocalDateTime updateTime;
    @Version
    private Integer version;
    @TableLogic
    @TableField(select=false)
    private Integer deleted;


}
