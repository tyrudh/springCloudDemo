package ynu.edu.controller;
import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
import ynu.edu.feign.UserFeignClient;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController {
    //注入Fegin接口（@EnableFeignClients自动扫描@FeignClient注解）
    @Resource
    private UserFeignClient userFeignClient;
    @GetMapping("/getUserById/{userId}")
//    @Bulkhead(name = "backendB", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "fallbackMethod")
    public CommonResult getUserById(@PathVariable("userId") Integer userId){ //使用Fegin接口进行服务调用
        return userFeignClient.getUserById(userId);
    }


    public CompletableFuture<User> getUserByIdDown(Integer userId,Throwable throwable){
        throwable.printStackTrace();
        String message = "获取用户"+userId+"当前功能异常火爆";
        System.out.println(message);
        return  CompletableFuture.completedFuture(new CommonResult<>(400,message,new User()).getResult());
    }

}
