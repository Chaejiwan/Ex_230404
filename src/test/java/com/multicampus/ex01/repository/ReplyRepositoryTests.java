package com.multicampus.ex01.repository;

import com.multicampus.ex01.domain.Board;
import com.multicampus.ex01.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;


@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;
    
    @Test
    public void testInsert() {
        // 실제 DB에 있는 bno : 103
        Long bno = 103L;
        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("103번 글에 대한 댓글1")
                .replyer("user1")
                .build();
        replyRepository.save(reply);
    }

    @Transactional
    @Test
    public void testBoardReplies() {
        Long bno = 101L;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> {
            log.info(reply);
        });
    }
}
