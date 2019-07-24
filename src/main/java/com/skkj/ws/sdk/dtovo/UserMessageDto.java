package com.skkj.ws.sdk.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-07-19 14:43.
 */

@Data
@NoArgsConstructor
public class UserMessageDto {
    private Integer messageType;

    private List<String> userIds;

    private String contentJson;

    private String contentString;

    private Object content;

    public static UserMessageDto newItem(List<Long> userIds, String data, Integer messageType) {
        UserMessageDto dto = new UserMessageDto();

        dto.userIds = new ArrayList<>();
        for (Long uId : userIds) {
            dto.userIds.add(uId.toString());
        }

        dto.setContentJson(data);
        dto.setMessageType(messageType);

        return dto;
    }
}
