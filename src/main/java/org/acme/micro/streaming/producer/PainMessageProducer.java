package org.acme.micro.streaming.producer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class PainMessageProducer {

	private Properties createProducerConfiguration() {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "osboxes:9092");
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);

		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);

		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.ByteArraySerializer");

		return props;
	}

	private void produceMessages() {
		Producer<String, byte[]> producer = new KafkaProducer<>(createProducerConfiguration());

		for (int i = 0; i < 100; i++) {
			try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("samplePain.xml");) {
				producer.send(new ProducerRecord("rawpain", "key" + i, IOUtils.toByteArray(in)));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		producer.close();
	}

	public static void main(String[] args) {
		PainMessageProducer painMsg = new PainMessageProducer();
		painMsg.produceMessages();
	}
}
