package org.voidmirror.pagcoord.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableKafka
public class KafkaReceiveTestController {

    @KafkaListener(topics = "msgtopic")
    public void msgListener(String msg) {
        System.out.println(msg);
    }


}
