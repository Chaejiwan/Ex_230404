package com.multicampus.ex01.repository.search;

import com.multicampus.ex01.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    //페이지 처리하는 기능만 선언
    Page<Board> search1(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);

}
