package com.lvym.mybatisplus.config;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisPlusPage {

   public static ThreadLocal<String> myTableName=new ThreadLocal<>();
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        ArrayList<ISqlParser> iSqlParsers = new ArrayList<>();
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        Map<String, ITableNameHandler> handlerHashMap = new HashMap<>();
        handlerHashMap.put("user", new ITableNameHandler() {
            @Override
            public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                return myTableName.get();
            }
        });
        dynamicTableNameParser.setTableNameHandlerMap(handlerHashMap);

        iSqlParsers.add(dynamicTableNameParser);

        paginationInterceptor.setSqlParserList(iSqlParsers);



        return paginationInterceptor;
    }



   @Bean
   public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
   }
   //性能分析插件
   @Bean
   @Profile({"dev","test"})//在dev和test环境开启
   public PerformanceInterceptor performanceInterceptor(){
       PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
       //performanceInterceptor.setFormat(true);  //格式化SQL语句
       //performanceInterceptor.setMaxTime(5L);   //设置最大执行时间  超过5毫秒就报错
       return performanceInterceptor;
   }
}
