package com.skkj.ws.sdk.DtoVo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-07-15 13:27.
 */

@Data
@NoArgsConstructor
public class WsConversationDto {
    @NotBlank
    @Size(max = 200)
    private String extraCvsId;

    private List<String> extraUserId;

    private String remark;
}
