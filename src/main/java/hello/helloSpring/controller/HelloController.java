package hello.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")  // Controller 지정
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";    // resource/hello.html
    }

    @GetMapping("helloMvc")
    public String helloMvc (@RequestParam("name") String name, Model model) {
        model.addAttribute("data", name);
        return "helloTemplate";
    }

    @GetMapping("helloString")
    @ResponseBody
    public helloString helloString(@RequestParam("name") String name) {
        helloString hello = new helloString();
        hello.setName(name);
        return hello;
    }

    static class helloString {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
