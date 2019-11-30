package com.example.jmsreceiver.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import java.util.Arrays;

@Configuration
//@EnableJms  //to enable support for the @JmsListener annotation that was used on the Receiver.(to enable detection of JmsListener annotation)
public class ReceiverConfig {

    /*@Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory receiverActiveMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.example"));

        return activeMQConnectionFactory;
    }


    //for asynchronous message listening
    //it will receive message from the queue and pass it on the bean which is annotated with @JmsListener
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SomeHandler errorHandler){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());
        factory.setErrorHandler(errorHandler);
        factory.setPubSubDomain(true); //to receive message from Topic instead of queue (messages sent only after the receiver has subscribed
                                        //will be received)
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){           //required on receiver side only for synchronous receive(i.e for jmsTemplate.receive() )
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(receiverActiveMQConnectionFactory());
        template.setDefaultDestinationName("temp");
        //template.setPubSubDomain(true);       //to receive message from topic
        return template;
    }

    @Bean
    public Receiver receiver(){
        return new Receiver();
    }
    */

    @Bean
    MessageConverter converter(){
        return new SimpleMessageConverter();
    }

}
