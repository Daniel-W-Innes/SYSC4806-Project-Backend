package ca.group20.sysc4806project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class Sysc4806ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sysc4806ProjectApplication.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String health() {
        return "Hello World!";
    }
}