package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_12.dto.response.ApiResponse;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/greetings")
public class GreetingController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<String>> greeting(
            @RequestParam(defaultValue = "", required = false) String name
    ) {
            String greeting = "Hello " + name + "!";
            return ResponseEntity.ok(
                    ApiResponse.<String>builder()
                            .code(UUID.randomUUID())
                            .data(greeting)
                            .message("Greeting successfully")
                            .build()
            );
    };
}



























