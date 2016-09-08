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

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
/**
 * @1
 * MyBatis基础配置 创建了一个SqlSessionFactory和一个SqlSessionTemplate，
 * 为了支持注解事务，增加了@EnableTransactionManagement注解，
 * 并且反回了一个PlatformTransactionManagerBean
 */
/**
 * @2
 * @Configuration 注释位于类的顶端。它告知 Spring 容器这个类是一个拥有 bean 定义和依赖项的配置类。
 * @Bean 注释用于定义 bean。就像 XML 一样表示配置类
 */
@Configuration
//@EnableTransactionManagement
@ComponentScan
public class MyBatisConfig /**implements TransactionManagementConfigurer*/ {
	
	@Bean(name="busiDataSource")
	@Primary
	@ConfigurationProperties(prefix="busi.datasource")
	public DataSource busiDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "busiSqlSessionFactory")
	public SqlSessionFactory busiSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		//该属性必须配置，多数据源时会有多个dataSource，同时也需要配置多个sqlSessionFactory来对应。
		bean.setDataSource(busiDataSource());
		//该属性可以给包中的类注册别名，注册后可以直接使用类名，而不用使用全限定的类名（就是不用包含包名）
		bean.setTypeAliasesPackage("com.zjs.dto");
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			//配置该属性后，sqlSessionFactory会自动扫描该路径下的所有文件并解析。
			//该路径支持多个，可以用,;\t\n进行分割。
			bean.setMapperLocations(resolver.getResources("classpath:com/zjs/mapper/busi/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean(name="workerDataSource")
	@ConfigurationProperties(prefix="task.datasource")
	public DataSource workerDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "workerSqlSessionFactory")
	public SqlSessionFactory workerSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		//该属性必须配置，多数据源时会有多个dataSource，同时也需要配置多个sqlSessionFactory来对应。
		bean.setDataSource(workerDataSource());
		//该属性可以给包中的类注册别名，注册后可以直接使用类名，而不用使用全限定的类名（就是不用包含包名）
		bean.setTypeAliasesPackage("com.zjs.dto");
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			//配置该属性后，sqlSessionFactory会自动扫描该路径下的所有文件并解析。
			//该路径支持多个，可以用,;\t\n进行分割。
			bean.setMapperLocations(resolver.getResources("classpath:com/zjs/mapper/task/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Transactional属性如下：
	 * propagation 设定事务传播行为，值为Propagation的枚举值
	 * isolation 设置事务的隔离级别，值为Isolation的枚举值
	 * readOnly 设置是否为只读事务，值为boolean
	 * timeout 设置超时时间，值为int型，单位为秒
	 * rollbackFor 设定遇到时需要回滚的异常，值为Class<? extends Exception>[]
	 * rollbackForClassName 设定遇到时需要回滚的异常，值为String[]，异常名称数组
	 * noRollbackFor 设定遇到时不需要回滚的异常，值同上rollbackFor
	 * noRollbackForClassName ......
	 */
	/**
	 * @propagation属性如下：
	 * PROPAGATION_REQUIRED 如果当前没有事务，就创建一个事务，如果已经存在一个事务中。就加入这个事务
	 * PROPAGATION_SUPPORTS 如果当前没有事务就以非事务方式执行
	 * PROPAGATION_MANDATORY 使用当前事务，如果没有就抛出异常
	 * PROPAGATION_REQUIRES_NEW 新建事务，如果当前存在事务，就挂起当前事务
	 * PROPAGATION_NOT_SUPPORTED 以非事务方式执行，如果当前存在事务，就挂起事
	 * PROPAGATION_NEVER 以非事务方式执行，如果当前存在事务，就抛出异常
	 * PROPAGATION_NESTED 如果当前存在事务，则在嵌套事务内执行。如果没有，就执行PROPAGATION_REQUIRED类似的操作
	 */
}
