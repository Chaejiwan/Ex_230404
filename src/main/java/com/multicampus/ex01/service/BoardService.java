package com.multicampus.ex01.service;

import com.multicampus.ex01.dto.BoardDTO;
import com.multicampus.ex01.dto.PageRequestDTO;
import com.multicampus.ex01.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);  //list라는 이름으로 목록과 검색기능 선언
}
