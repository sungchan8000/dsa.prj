package com.dsa.prj.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberJoinParams {
    private String requestName;
    private String requestEmail;
    private String requestId;
    private String requestPhoneNumber;
    private String passWord;

    private JoinBirthDay joinBirthDay;


    @Getter
    @Setter
    @ToString
    private static class JoinBirthDay {
        private String year;
        private String month;
        private String day;

        public JoinBirthDay(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }



}
