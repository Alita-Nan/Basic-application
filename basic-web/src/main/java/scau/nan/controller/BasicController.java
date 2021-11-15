package scau.nan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Swagger的注解的简单使用。该注解是标注在方法上并用来描述整个控制器的工作内容。")
@RestController
@RequestMapping("basic")
public class BasicController {

    // 该注解用于控制器的方法上，用于描述该方法的作用
    @ApiOperation(value = "测试接口")
    @GetMapping("/hello")
    public String basic(@RequestParam("something") @ApiParam("该参数的含义...") String something){
        System.out.println(something);
        return "Have a look!";
    }
}
