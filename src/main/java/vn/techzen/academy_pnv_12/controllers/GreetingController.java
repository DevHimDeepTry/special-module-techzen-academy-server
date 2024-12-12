package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_12.dto.response.ResponseData;

@RestController
@RequestMapping("api/v1/greetings")
public class GreetingController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseData<String> greeting(
            @RequestParam(defaultValue = "", required = false) String name
    ) {
            String greeting = "Hello " + name + "!";
            return new ResponseData<>(HttpStatus.OK.value(),"Greeting Successfully", greeting);

    };
}