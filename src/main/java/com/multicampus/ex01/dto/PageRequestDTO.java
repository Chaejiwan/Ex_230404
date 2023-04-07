package com.multicampus.ex01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


//페이징 관련 정보(page, size), type, keyword 추가 지정하여 선언
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    private  int page = 1;

    @Builder.Default
    private int size = 10;

    private String type; // 검색의 종류 : t, c, w, tc, tw, twc  문자열 하나로 처리해서 나중에 각 문자로 분리하도록 작성
    private String keyword;
    private String link;

    // 현재 검색 조건들을 BoardRepository에서 String[]로 처리하고 있기에, type이라는 문자열을 배열로 반환가능
    public String[] getTypes() {
        if(type==null || type.isEmpty()) {
            return null;
        } return type.split("");
    }

    // 페이징 처리를 위해 Pageable 타입 반환하는 기능
    public Pageable getPageable(String...props) {

        return PageRequest.of(this.page-1, this.size, Sort.by(props).descending());
    }

    // 검색조건과 페이징 조건을 문자열로 구성하는 getLink()
    public String getLink() {
        if(link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            if(type != null && type.length() > 0) {
                builder.append("&type=" + type);
            }
            if(keyword != null) {
                try {
                    builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            link = builder.toString();

        }
        return link;
    }
}
