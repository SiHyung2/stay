package com.example.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data 
public class ReviewDTO {

	private long ac_id;
    private long rev_Num;
    private String bo_Num; 
    private String ac_Title;
    private int room_Num;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date review_Date;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date update_Date; 
    private String email_Id;
    
    public String getBo_Num() {
        return bo_Num;
    }


    public String getEmailId() {
        return email_Id;
    }

    public void setEmailId(String email_Id) {
        this.email_Id = email_Id;
    }
		
}

    


 
    