package com.example.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReplyDTO {

    private Long reply_Id;
    private Long review_Id;
    private String content;
    private LocalDate createdAt;

}