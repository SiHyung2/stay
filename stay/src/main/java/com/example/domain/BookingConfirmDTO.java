package com.example.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BookingConfirmDTO {

    private String bo_num;
    private int room_num;
    private int ac_id;
    private String checkin_day;
    private String checkout_day;
    private String tel;
    private String email_id;
    private int status;
}