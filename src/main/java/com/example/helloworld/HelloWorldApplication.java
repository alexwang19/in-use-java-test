package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.apache.pulsar.client.api.Producer;
// import org.apache.pulsar.client.api.PulsarClient;
// import org.apache.pulsar.client.api.PulsarClientException;
// import org.apache.pulsar.client.api.Schema;

@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) {
        // try {
        //     PulsarClient client = PulsarClient.builder()
        //             .serviceUrl("pulsar://localhost:6650")
        //             .build();
        //     Producer<String> stringProducer = client.newProducer(Schema.STRING)
        //             .topic("starter-topic")
        //             .create();
        //     stringProducer.send("Hello Pulsar. Enjoy Your Day! - From Producer");
        //     stringProducer.close();
        // } catch (PulsarClientException e) {
        //     e.printStackTrace();
        // }
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}
