package com.skkj.ws.sdk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.skkj.ws.sdk.base.WsSdkException;
import com.skkj.ws.sdk.config.WsProperties;
import com.skkj.ws.sdk.dtovo.*;
import com.skkj.ws.sdk.util.JsonHelper;
import com.yun.util.module.rsp.RspData;
import com.yun.util.module.rsp.RspDataT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author: yun
 * @createdOn: 2019-07-15 10:42.
 */

public class WsApiServiceImpl {
    @Autowired
    private WsProperties wsProperties;

    @Autowired
    private RestTemplate restTemplate;

    public ClientUserVo addClientUser(@Valid ClientUserDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<ClientUserDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/clientUser/add"),
                HttpMethod.POST, request, String.class);

        RspDataT<ClientUserVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<ClientUserVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public ClientUserLoginVo clientUserLogin(@NotNull String extraUserId, @NotNull String platform) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl(
                String.format("v1/api/clientUser/login/%s/%s", extraUserId, platform)),
                HttpMethod.POST, request, String.class);

        RspDataT<ClientUserLoginVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<ClientUserLoginVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public WsConversationVo createConversation(@Valid WsConversationDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<WsConversationDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/conversation/creat"),
                HttpMethod.POST, request, String.class);

        RspDataT<WsConversationVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<WsConversationVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public SubjectVo createSubject(@Valid SubjectDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<SubjectDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/subject/creat"),
                HttpMethod.POST, request, String.class);

        RspDataT<SubjectVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<SubjectVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public ConversationMessageRpsVo pushConversationMessage(@Valid ConversationMessageDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<ConversationMessageDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/message/conversation"),
                HttpMethod.POST, request, String.class);

        RspDataT<ConversationMessageRpsVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<ConversationMessageRpsVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public ConversationMessageRpsVo pushUserMessage(@Valid UserMessageDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<UserMessageDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/message/user"),
                HttpMethod.POST, request, String.class);

        RspDataT<ConversationMessageRpsVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<ConversationMessageRpsVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    public SubjectMessageRpsVo pushSubjectMessage(@Valid SubjectMessageDto dto) {
        HttpHeaders headers = httpHeaders();

        HttpEntity<SubjectMessageDto> request = new HttpEntity<>(dto, headers);

        ResponseEntity<String> response = restTemplate.exchange(httpUrl("v1/api/message/subject"),
                HttpMethod.POST, request, String.class);

        RspDataT<SubjectMessageRpsVo> rst = JsonHelper.toObjType(response.getBody(),
                new TypeReference<RspDataT<SubjectMessageRpsVo>>() {
                });

        handleRst(rst);

        return rst.getData();
    }

    private void handleRst(RspDataT rst) {
        if (rst == null) {
            throw new WsSdkException("返回结果无数据");
        }

        if (rst.isError()) {
            RspData bRst = new RspData(rst.getCode(), rst.getErrorMsg());
            bRst.setData(rst.getData());

            throw new WsSdkException(rst.getErrorMsg());
        }
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("ACCESS_AUTH_DTO", wsProperties.getAccessKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

    private String httpUrl(String path) {
        String url = String.format("%s/%s", wsProperties.getHost(), path);

        return url;
    }
}
