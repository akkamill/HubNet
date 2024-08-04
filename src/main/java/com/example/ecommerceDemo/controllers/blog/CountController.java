//package com.example.ecommerceDemo.controllers.blog;
//
//import com.example.ecommerceDemo.services.blog.CountService;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/counts")
//public class CountController {
//
//    private final CountService countService;
//
//    public CountController(CountService countService) {
//        this.countService = countService;
//    }
//
//    @GetMapping("/{blogId}")
//    public String viewBlog(@PathVariable Long blogId, HttpServletRequest request) {
//        String userId = request.getRemoteUser();
//        countService.record("/api/blogs" + blogId, userId);
//        return "Blog content";
//    }
//
//    @PostMapping("/{blogId}/share")
//    public String shareBlog(@PathVariable Long blogId, HttpServletRequest request) {
//        String userId = request.getRemoteUser();
//        countService.record("/api/blogs/" + blogId + "/share", userId);
//        return "Blog shared"; // Placeholder
//    }
//
//
//}
