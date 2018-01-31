package com.lxh.cloud.study.user.controller;

import com.lxh.cloud.study.user.feign.UserFeignClient;
import com.lxh.cloud.study.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
//    @Qualifier("microservice-provider-user")
    private UserFeignClient userFeignClient;

/*    private UserFeignClient userUserFeignClient;

    private UserFeignClient adminUserFeignClient;*/
/*    @Autowired
    private RestTemplate restTemplate;*/

/*    @Autowired
    private LoadBalancerClient loadBalancerClient;*/

/*    @Value("${user.userServiceUrl}")
    private String userServiceUrl;*/

    /*@Autowired
    private DiscoveryClient discoveryClient;*/

 /*   @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user","password1")).target(UserFeignClient.class,"http://microservice-provider-user");
        adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2")).target(UserFeignClient.class, "http://microservice-provider-user/");
    }*/
   // @HystrixCommand(fallbackMethod = "findByIdFallback")
   @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
//        System.out.println(userServiceUrl);
//        return  restTemplate.getForObject(userServiceUrl+id,User.class);
//       return restTemplate.getForObject("http://microservice-provider-user/user/"+id,User.class);
       System.out.println("microservice-consumer-movie:-------"+ id);
       return userFeignClient.findById(id);
//       return userUserFeignClient.findById(id);
    }

/*    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }*/

/*    @GetMapping("/admin/{id}")
    public User findByIdAdmin(@PathVariable Long id) {
        return this.adminUserFeignClient.findById(id);
    }*/


    /*@GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return discoveryClient.getInstances("microservice-provider-user");
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }*/
}
