package com.multicampus.ex01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    private Long rno; // 댓글 고유번호

    @NotNull
    private Long bno;

    @NotEmpty
    private String replyText; // 댓글 내용

    @NotEmpty
    private String replyer; // 댓글 단 사람

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    @JsonIgnore
    private LocalDateTime modDate;

}
