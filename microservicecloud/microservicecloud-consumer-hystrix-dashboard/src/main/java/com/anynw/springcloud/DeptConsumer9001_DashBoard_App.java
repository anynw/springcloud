package com.anynw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * 访问地址：localhost:9001/hystrix
 * @author Administrator
 * @date 2019年9月27日 下午10:49:06
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer9001_DashBoard_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer9001_DashBoard_App.class, args);
	}
}
