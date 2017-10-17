package liye.com.springboot_activiti.test;

import java.io.InputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOne {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService  repositoryService;
	//发布流程
	@Test
	public void start(){
		InputStream inputStreamBpmn = this.getClass().getResourceAsStream("MyProcess.bpmn");
		InputStream inputStreamPng = this.getClass().getResourceAsStream("MyProcess.png");
		Deployment deployment = repositoryService.createDeployment()//创建一个部署对象
				.name("流程定义")//添加部署的名称
				.addInputStream("MyProcess.bpmn", inputStreamBpmn)
				.addInputStream("MyProcess.png", inputStreamPng)
				.deploy();//完成部署
				System.out.println("部署ID："+deployment.getId());
				System.out.println("部署名称："+deployment.getName());
	}
}
