package com.example.jmsreceiver;

import com.example.jmsreceiver.jms.Receiver;
import com.example.jmssender.jms.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//implements ApplicationRunner
@SpringBootApplication
public class JmsReceiverApplication{

	@Autowired
	private Receiver receiver;

	public static void main(String[] args) {
		SpringApplication.run(JmsReceiverApplication.class, args);
	}

	/*@Override
	public void run(ApplicationArguments args) throws Exception {

		Product response = receiver.receiveMessage();			//required on receiver side only for synchronous receive
		System.out.println("message received successfully : " + response);
	}*/
}
