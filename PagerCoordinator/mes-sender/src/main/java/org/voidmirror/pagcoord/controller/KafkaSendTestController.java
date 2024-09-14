package org.voidmirror.pagcoord.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("msg")
public class KafkaSendTestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public void send(@RequestParam("msgId") String msgId, @RequestParam("msg") String msg) {
        log.info("Id: {}, Message: {}", msgId, msg);
        kafkaTemplate.send("msgtopic", msgId, msg);
    }

}
