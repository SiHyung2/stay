package com.example.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;


@Data 


public class ReviewDTO {

    private long rev_Num;
    private String bo_Num;
    private String ac_Title;
    private int room_Num;
    private String content;
    private Date review_Date;
    private Date update_Date;
    
    
	public String getId() {
		// TODO Auto-generated method stub
		return String.valueOf(rev_Num);
	}


		
	}

    
    
 
   