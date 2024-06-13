package com.example.mydata.controller;

import com.example.mydata.dto.Asset;
import com.example.mydata.dto.LoanCondition;
import com.example.mydata.dto.Notice;
import com.example.mydata.dto.User;
import com.example.mydata.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProfileController {
    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/profile")
    public ModelAndView getProfile(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String userId = (String) session.getAttribute("userid");
            ModelAndView mav = new ModelAndView("profile");
            User user = service.getUserById(userId);
            List<Asset> assets = service.getAssetsByUserId(userId);
            List<LoanCondition> loans = service.getLoansByUserId(userId);
            List<Notice> notices = service.getNoticesByUserId(userId);
            mav.addObject("user", user);
            mav.addObject("assets", assets);
            mav.addObject("loans", loans);
            mav.addObject("notices", notices);
            return mav;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }
}