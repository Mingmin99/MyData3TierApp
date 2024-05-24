package com.example.mydata.controller;

import com.example.mydata.dto.Asset;
import com.example.mydata.service.AssetsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AssetsController {
private final AssetsService service;

    public AssetsController(AssetsService service) {
        this.service = service;
    }

    @RequestMapping("/assets")
    public ModelAndView manageAssets(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            ModelAndView mav = new ModelAndView("assets");
            mav.addObject("username", session.getAttribute("username"));
            mav.addObject("userid", session.getAttribute("userid"));

            // 서비스에서 자산 데이터를 가져와서 모델에 추가
            List<Asset> assets = service.getAssetsByUserId((String) session.getAttribute("userid"));
            mav.addObject("assets", assets);

            // 자산 데이터를 JSON 문자열로 변환하여 모델에 추가
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String assetsJson = objectMapper.writeValueAsString(assets);
                mav.addObject("assetsJson", assetsJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return mav;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

}
