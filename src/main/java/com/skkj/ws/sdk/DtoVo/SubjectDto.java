package com.skkj.ws.sdk.DtoVo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: yun
 * @createdOn: 2019-07-24 14:50.
 */

@Data
@NoArgsConstructor
public class SubjectDto {
    @NotBlank
    @Size(max = 200)
    private String extraSubjectId;

    private Integer maxClient;

    private String remark;
}