package io.project.kafka_consumer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(groupId = ApplicationConstant.GROUP_ID_STRING, topics = ApplicationConstant.TOPIC_NAME)
	public void receivedMessage(@Payload String message,
	                               @Headers Map<String, Object> headers) {
	        LOGGER.info("Received record from Topic-Partition '{}-{}' with Offset '{}' -> Key: '{}' - Value '{}'",
	                headers.get(KafkaHeaders.RECEIVED_TOPIC),
	                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
	                headers.get(KafkaHeaders.OFFSET),
	                headers.get(KafkaHeaders.MESSAGE_KEY),
	                message);
	}
}
