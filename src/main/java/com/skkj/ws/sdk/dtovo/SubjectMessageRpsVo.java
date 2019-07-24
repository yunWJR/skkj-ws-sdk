package com.skkj.ws.sdk.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019-07-24 15:30.
 */

@Data
@NoArgsConstructor
public class SubjectMessageRpsVo {
    private Integer messageType;

    private Integer sucCount;

    private String extraId;

    private String contentJson;

    private String contentString;

    private Object content;
}
