package com.example;

import com.example.entity.LapInfo;
import com.example.service.SlackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MtgTimestampServerApplication {

    private static final Logger log = LoggerFactory.getLogger(MtgTimestampServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MtgTimestampServerApplication.class, args);
	}

    @Autowired
    SlackService slackService;

	@PostMapping(value = "/POST")
//    @RequestMapping(method = RequestMethod.POST, value = "/POST")
	public HttpStatus postSlack(@RequestBody LapInfo lapInfo) {
		log.info(lapInfo.toString());
		return slackService.postSlack(lapInfo);
	}

    @RequestMapping(method = RequestMethod.GET, value = "/GET")
    public HttpStatus get() {
        return HttpStatus.OK;
    }
}
