package com.anynw.springcloud;

import com.anynw.springcloud.annotation.ExcludeFromComponentScan;
import com.anynw.springcloud.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 自定义Ribbon负载均衡算法
 * 方式一：在springboot主程序扫描的包外定义配置类，然后为springboot主程序添加@RibbonClient注解引入配置类 
 * 方式二：在与springboot主程序的同一级目录新建RibbonClient的配置类，但是必须在springboot扫描的包范围内排除掉，方法是自定义注解标识配置类，然后在springboot的添加@ComponentScan根据自定义注解类型过滤掉配置类
 * 此处使用方式二
 * @author wuhp
 * @date 2019年9月22日 下午2:32:23
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MyRule.class)
//过滤掉springboot主程序扫描包下的配置
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
