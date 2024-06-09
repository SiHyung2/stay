package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BookingConfirmDTO {

    private String bo_num;
    private int ro_name;
    private String checkin_day;
    private String checkout_day;
    private String name;
    private String tel;
    private int status;
    private String ac_title;
    private int room_num;
    private String status_explain;
    private String email_id;
    
}