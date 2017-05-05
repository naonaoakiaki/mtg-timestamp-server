package com.example.service;

import com.example.entity.LapInfo;
import com.example.entity.SlackPayload;
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

    @Value("${api.url:https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX}")
    URI uri;

    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);



    public HttpStatus postSlack(LapInfo lapInfo) {
        logger.info(lapInfo.toString());
        RestTemplate restTemplate = new RestTemplate();
        SlackPayload slackPayload = new SlackPayload("#time_stamp_sand", "webhookbot", lapInfo.toString(), ":ghost:");
        RequestEntity<SlackPayload> requestEntity = RequestEntity.post(this.uri).contentType(MediaType.APPLICATION_JSON).body(slackPayload);
        ResponseEntity<SlackPayload> responseEntity = restTemplate.exchange(requestEntity, SlackPayload.class);
        return responseEntity.getStatusCode();
    }
}
