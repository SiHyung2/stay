package com.example.service;

import java.util.List;

import com.example.domain.ReplyDTO;

public interface ReplyService {

    // Create
    void addReply(ReplyDTO replyDTO);
    public List<ReplyDTO> readReply();
   
}
