package com.example.mydata.controller;

import com.example.mydata.dto.User;
import com.example.mydata.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMember(@RequestBody Map<String, String> loginData, HttpServletRequest request) {
        System.out.println("Received login data: " + loginData); // 디버깅 로그 추가
        System.out.println("이게 로그인 데이터 컨트롤러" + loginData);
        User loginUser = service.loginUser(loginData);
        System.out.println("그래서 로그인 된 사람이 누구냐면  컨트롤러" + loginUser);

        HttpSession session = request.getSession();
        if (loginUser != null) {
            System.out.println("그래서 로그인 된 사람이 누구냐면 아아디  컨트롤러" + loginUser.getId());
            System.out.println("그래서 로그인 된 사람이 누구냐면 비밀번호 컨트롤러" + loginUser.getPassword());
            System.out.println("그래서 로그인 된 사람이 누구냐면 이름 컨트롤러" + loginUser.getUsername());
            session.setAttribute("username", loginUser.getUsername());
            session.setAttribute("userid", loginUser.getId());

            HashMap<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("username", loginUser.getUsername());
            response.put("userid", loginUser.getId());
            return ResponseEntity.ok(response);
        } else {
            HashMap<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "로그인 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @RequestMapping("/assets")
    public ModelAndView manageAssets(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            ModelAndView mav = new ModelAndView("assets"); // 자산 관리 페이지로 이동
            mav.addObject("username", session.getAttribute("username"));
            mav.addObject("userid", session.getAttribute("userid")); // userid 추가
            return mav;
        } else {
            return new ModelAndView("redirect:/login"); // 로그인 페이지로 리다이렉트
        }
    }


}
