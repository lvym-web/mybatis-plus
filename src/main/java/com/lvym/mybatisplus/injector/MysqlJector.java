package com.lvym.mybatisplus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MysqlJector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
       // methodList.add(new DeleteMethod());
        methodList.add(new InsertBatchSomeColumn(t->!t.isLogicDelete()&!t.getColumn().equals("age")&!t.getColumn().equals("version")));//不是逻辑删除,age的都insert
        methodList.add(new LogicDeleteByIdWithFill());
        methodList.add(new AlwaysUpdateSomeColumnById(suiyi->!suiyi.getColumn().equals("name")));//排除name字段
        return methodList;
    }
}
