/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.zjs.conf;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 为了代替手工使用 SqlSessionDaoSupport 或 SqlSessionTemplate 编写数据访问对象 (DAO)的代码,
 * MyBatis-Spring 提供了一个动态代理的实现:MapperFactoryBean。
 * 这个类 可以让你直接注入数据映射器接口到你的 service 层 bean 中。
 * 当使用映射器时,你仅仅如调 用你的 DAO 一样调用它们就可以了,
 * 但是你不需要编写任何 DAO 实现的代码,因为 MyBatis-Spring 将会为你创建代理。
 *
 * @author liuzh
 * @since 2015-12-19 14:46
 */
@Configuration
//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1() {
    	
    	/**
    	 * 一般用过的最多也就是这3个属性，实际情况下最常用的只有basePackage。
    	 * 1,basePackage属性 可以写多个，可以用,;\t\n进行分割。
    	 * 2,annotationClass 该属性实际上就是起到一个过滤的作用，如果设置了该属性，那么MyBatis的接口只有包含该注解，才会被扫描进去。
    	 * 3,sqlSessionFactoryBeanName 这个属性一般都用不到，只有当你配置多数据源的时候，这是会有多个sqlSessionFactory，你就需要通过该属性来指定哪一个sqlSessionFactory
    	 */
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("busiSqlSessionFactory");
        System.out.println("busiSqlSessionFactory 数据源");
        mapperScannerConfigurer.setBasePackage("com.zjs.mapper.busi");
        return mapperScannerConfigurer;
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer2() {
    	
    	/**
    	 * 一般用过的最多也就是这3个属性，实际情况下最常用的只有basePackage。
    	 * 1,basePackage属性 可以写多个，可以用,;\t\n进行分割。
    	 * 2,annotationClass 该属性实际上就是起到一个过滤的作用，如果设置了该属性，那么MyBatis的接口只有包含该注解，才会被扫描进去。
    	 * 3,sqlSessionFactoryBeanName 这个属性一般都用不到，只有当你配置多数据源的时候，这是会有多个sqlSessionFactory，你就需要通过该属性来指定哪一个sqlSessionFactory
    	 */
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("workerSqlSessionFactory");
        System.out.println("workerSqlSessionFactory 数据源");
        mapperScannerConfigurer.setBasePackage("com.zjs.mapper.task");
        return mapperScannerConfigurer;
    }
    /**
     * Ant通配符
     * ? 匹配任何单字符
     * 匹配0或者任意数量的字符
     * 匹配0或者更多的目录
     * 举例
     * /project/*.a 匹配项目根路径下所有在project路径下的.a文件
     * /project/p?ttern 匹配项目根路径下 /project/pattern 和 /app/pXttern,但是不包括/app/pttern
     * "/**\/ example 匹配项目根路径下 /project/example, /project/foow/example, 和 /example
     * /project/**\/dir/file.* 匹配项目根路径下/project/dir/file.jsp, /project/foow/dir/file.html
     * /**\/*.jsp 匹配项目根路径下任何的.jsp 文件
     */
}
