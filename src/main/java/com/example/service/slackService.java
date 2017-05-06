package com.example.service;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.example.entity.LapInfo;
import com.example.entity.SlackPayload;
import com.example.properties.SlackProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by naonaoakiaki on 2017/05/06.
 */
@Service
public class SlackService {

    @Autowired
    SlackProperties slackProperties;

    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);

    public HttpStatus postSlack(LapInfo lapInfo) {
        logger.info(lapInfo.toString());
        RestTemplate restTemplate = new RestTemplate();
        SlackPayload slackPayload = new SlackPayload("#time_stamp_sand", "webhookbot", lapInfo.getText(), ":ghost:");
        RequestEntity<SlackPayload> requestEntity = RequestEntity.post(slackProperties.getUri()).body(slackPayload);
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        return responseEntity.getStatusCode();
    }
}
