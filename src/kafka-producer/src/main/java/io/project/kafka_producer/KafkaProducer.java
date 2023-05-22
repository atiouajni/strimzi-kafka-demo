package io.project.kafka_producer;

import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/produce")
public class KafkaProducer {

    @Inject
    Emitter<String> msgEmitter;

    @POST
    @Path("/message")
    public String sendMessage(String message) {
    	
        try {
        	msgEmitter.send(KafkaRecord.of(ApplicationConstant.TOPIC_NAME, "kafka-producer-key", message));
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Message sent successfully !\n";
    }
    
}