package com.example.mapper;

import com.example.domain.ReplyDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
    void addReply(ReplyDTO replyDTO);
    public List<ReplyDTO> readReply();

}
