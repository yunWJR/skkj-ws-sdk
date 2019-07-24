package com.skkj.ws.sdk.DtoVo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: yun
 * @createdOn: 2019-07-15 10:50.
 */

@Data
@NoArgsConstructor
public class ClientUserDto {
    @NotBlank
    @Size(max = 200)
    private String extraUserId;

    @Size(max = 200)
    private String remark;
}
