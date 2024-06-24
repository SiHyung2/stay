package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.domain.ReplyDTO;
import com.example.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

    private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void addReply(ReplyDTO replyDTO) {
        log.info("Adding reply: {}", replyDTO);
        replyMapper.addReply(replyDTO);
        log.info("Reply added successfully: {}", replyDTO);
    }

	@Override
	public List<ReplyDTO> readReply() {
		return replyMapper.readReply();
	}
}
