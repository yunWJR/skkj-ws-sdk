package com.skkj.ws.sdk.DtoVo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yun
 * @createdOn: 2019-07-24 14:52.
 */

@Data
@NoArgsConstructor
public class SubjectVo {
    private Long id;

    private Long createTime;

    private Long updateTime;

    private Long mgUserId;

    private String extraSubjectId;

    private String remark;

    private Integer maxClient = 0;

    private String wsPath;

    private String sessionId;
}
