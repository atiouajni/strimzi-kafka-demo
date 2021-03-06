package io.project.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@PostMapping("/message")
	public String sendMessage(@RequestBody String message) {

		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, "kafka-producer-key", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Message sent successfully !\n";
	}

}
