package com.example.jmsreceiver.jms;

import com.example.jmssender.jms.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.rmi.CORBA.PortableRemoteObjectDelegate;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    @Autowired
    MessageConverter messageConverter;

    @Autowired
    JmsTemplate jmsTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

//    private CountDownLatch latch = new CountDownLatch(1);
//    public CountDownLatch getLatch(){
//        return latch;
//    }

    @JmsListener(destination = "temp")  //asynchronous receiver(need not be present at the time of message send). Create a message
    public void receive(Product message){ //listener container behind the scenes for each annotated method, using a JmsListenerContainerFactory
                                            //By default, a bean with name jmsListenerContainerFactory is expected by the @JmsListener annotation
        LOGGER.info("received message='{}'", message);
       // latch.countDown();
    }


   /* //-----For synchronous message receiving----------
    public Product receiveMessage(){

        try{
            Message message = jmsTemplate.receive("temp");          // ----synchronous receive---
            Product response = (Product) messageConverter.fromMessage(message);     //receiving Product message
            return response;
        }
        catch (Exception exe){
            exe.printStackTrace();
        }
        return null;
    }
*/
}

//----Queue(point-to-point)---
    //-- there is only 1 client for each message.
//-1: Asynchronous receive - the sender sends many messages to queue and when the receiver appln starts, it receives all the messages.
//-2: Synchronous receive - the sender sends many messages to queue and when receiver appln starts, it receives 1 message, then it
//                           starts again and receives 2nd message etc.

//-----Topic(pub-sub)---
//-1: Asynchronous receive - the receiver subscribes for topic(and is active), then sender sends many messages. It will receive all the
//                           messages which were sent after tat subscription, provided the receive is active.
//-2: Synchronous receive - the receiver subscribes for topic(and is active), then sender sends many messages. it will receive only
//                           1 message which was sent after tat subscription(and not all), provided the receiver is active.
