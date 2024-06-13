package com.example.mydata.controller;

import com.example.mydata.dto.User;
import com.example.mydata.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginMember(@RequestBody Map<String, String> loginData, HttpServletRequest request) {
        System.out.println("Received login data: " + loginData); // 디버깅 로그 추가
        User loginUser = service.loginUser(loginData);

        HttpSession session = request.getSession();
        Map<String, Object> response = new HashMap<>();
        if (loginUser != null) {
            session.setAttribute("username", loginUser.getUsername());
            session.setAttribute("userid", loginUser.getId());

            response.put("success", true);
            response.put("username", loginUser.getUsername());
            response.put("userid", loginUser.getId());
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "로그인 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}
