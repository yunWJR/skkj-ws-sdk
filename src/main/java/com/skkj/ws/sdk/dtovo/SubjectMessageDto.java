package com.skkj.ws.sdk.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019-07-24 15:28.
 */

@Data
@NoArgsConstructor
public class SubjectMessageDto {
    private Integer messageType;

    private String extraId;

    private String contentJson;

    private String contentString;

    private Object content;
}
