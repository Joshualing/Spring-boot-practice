package com.learn.controller;

import com.learn.bean.Person;
import com.learn.bean.UserRegisterRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequestMapping("prefix")
public class MyController {

    //@PathVariable用于获取路径参数，@RequestParam用于获取查询参数。
    @GetMapping("/klass/{klassId}/teachers")
    public String getKalss(@PathVariable("klassId") String kalssId, @RequestParam(value = "type", required = false) String type) {
        return  "PathVariable:" + kalssId +" type" + type;
    }

    //请求命令:curl -H "Content-Type: application/json"  -X POST -d '{"userName":"coder","fullName":"shuangkou","password":"123456"}'  http://localhost:8080/sign-up
    @PostMapping("/sign-up")
    public String signUp(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userRegisterRequest.toString();
    }

    //请求curl -H "Content-Type: application/json"  -X POST -d '{"classId":"cod","name":"lcn","sex":"Man"}'  http://localhost:8080/api/person
    //数据验证格式
    @RestController
    @RequestMapping("/api")
    public class PersonController {

        @PostMapping("/person")
        public String getPerson(@RequestBody @Valid Person person) {
            return person.toString();
        }
    }
}
