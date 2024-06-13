package com.example.mydata.controller;

import com.example.mydata.dto.LoanCondition;
import com.example.mydata.service.LoanConditionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LoanController {
    private final LoanConditionService service;

    public LoanController(LoanConditionService service) {
        this.service = service;
    }

    @RequestMapping("/loans")
    public ModelAndView manageLoans(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            ModelAndView mav = new ModelAndView("loans");
            mav.addObject("username", session.getAttribute("username"));
            mav.addObject("userid", session.getAttribute("userid"));

            // 서비스에서 대출 조건 데이터를 가져와서 모델에 추가
            List<LoanCondition> loanConditions = service.getLoanConditionsByUserId((String) session.getAttribute("userid"));
            mav.addObject("loanConditions", loanConditions);

            // 대출 조건 데이터를 JSON 문자열로 변환하여 모델에 추가
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String loanConditionsJson = objectMapper.writeValueAsString(loanConditions);
                mav.addObject("loanConditionsJson", loanConditionsJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return mav;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

}
