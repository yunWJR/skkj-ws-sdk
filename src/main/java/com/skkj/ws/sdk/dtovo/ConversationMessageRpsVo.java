package com.skkj.ws.sdk.dtovo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;

/**
 * @author: yun
 * @createdOn: 2019-07-19 14:30.
 */

@Data
@NoArgsConstructor
public class ConversationMessageRpsVo {
    private String extraConversationId;

    private List<String> pushSucIds;

    private List<String> pushFailIds;

    public HashSet<Long> failUserIds(Long igUser) {
        HashSet<Long> userIds = new HashSet<>();

        if (pushFailIds != null) {
            for (String idStr : pushFailIds) {
                Long uId = Long.valueOf(idStr);
                if (uId.equals(igUser)) {
                    continue;
                }

                userIds.add(uId);
            }
        }

        return userIds;
    }

    public HashSet<String> failUserIdsStr(Long igUser) {
        HashSet<String> userIds = new HashSet<>();

        String igUserStr = igUser.toString();
        if (pushFailIds != null) {
            for (String idStr : pushFailIds) {
                if (igUserStr.equals(idStr)) {
                    continue;
                }

                userIds.add(idStr);
            }
        }

        return userIds;
    }
}
