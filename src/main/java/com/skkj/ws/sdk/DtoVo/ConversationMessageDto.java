package com.skkj.ws.sdk.DtoVo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-07-15 13:30.
 */

@Data
@NoArgsConstructor
public class ConversationMessageDto {
    private Long conversationId;

    private String extraConversationId;

    private Integer messageType;

    private String contentJson;

    private String contentString;

    private List<IgnoreUserPlatformDto> ignoreList;
}
