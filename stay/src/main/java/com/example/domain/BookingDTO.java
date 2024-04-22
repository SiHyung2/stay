package com.example.domain;

import lombok.Data;

@Data
public class BookingDTO {

    private String bo_num;
    private String email_id;
    private int ro_type;
    private int ac_id;
    private String checkin_day;
    private String checkout_day;
    private int status;
    private int payment_code;
    private String reg_date;
    
}

