package com.example.mydata.controller;

import com.example.mydata.dto.Notice;
import com.example.mydata.service.NoticesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticesController {
    private final NoticesService service;

    public NoticesController(NoticesService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getNotices(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            ModelAndView mav = new ModelAndView("notices");
            String userId = (String) session.getAttribute("userid");
            mav.addObject("username", session.getAttribute("username"));
            mav.addObject("userid", userId);

            // 서비스에서 공지사항 데이터를 가져와서 모델에 추가
            List<Notice> notices = service.getAllNoticesByUserId(userId);
            mav.addObject("notices", notices);

            return mav;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @PostMapping
    public String createNotice(@RequestParam String title, @RequestParam String content, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String userId = (String) session.getAttribute("userid");
            Notice notice = new Notice();
            notice.setUserId(userId);
            notice.setTitle(title);
            notice.setContent(content);
            service.createNotice(notice);
            return "redirect:/notices";
        } else {
            return "redirect:/login";
        }
    }
}
