package app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@EnableAutoConfiguration
@RefreshScope
@ComponentScan
@Api("资源管理")
@RequestMapping("/userresou")
public class Controller {


	/*@Value("${name}")
	private String name;*/

	@Value("${age}")
	private String age;

	@RequestMapping(value="/getRecord",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation("查询全部资源")
	public String getRecord(){
		
		return age;
	}
}
