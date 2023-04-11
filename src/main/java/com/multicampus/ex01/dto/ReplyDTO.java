package com.multicampus.ex01.dto;

import io.swagger.annotations.ApiImplicitParams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDTO {
    private Long rno;
    @NotNull
    private Long bno;
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replayer;
    private LocalDateTime regDate, modDate;
}
