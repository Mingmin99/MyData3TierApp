package com.example.mydata.dto;

import java.sql.Timestamp;

public class LoanCondition {
    private int id;
    private String userid;
    private String loanType;
    private double interestRate; // double로 변경
    private int loanAmount;
    private int term;
    private String status;
    private Timestamp createdAt;

    // 기본 생성자
    public LoanCondition() {
    }

    // 모든 필드를 포함하는 생성자
    public LoanCondition(int id, String userid, String loanType, double interestRate, int loanAmount, int term, String status, Timestamp createdAt) {
        this.id = id;
        this.userid = userid;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.loanAmount = loanAmount;
        this.term = term;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}