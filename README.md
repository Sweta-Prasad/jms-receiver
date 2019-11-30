# jms-receiver

//----Queue(point-to-point)---
    //-- there is only 1 client for each message.
-1: Asynchronous receive - the sender sends many messages to queue and when the receiver appln starts, it receives all the messages.
-2: Synchronous receive - the sender sends many messages to queue and when receiver appln starts, it receives 1 message, then it
                           starts again and receives 2nd message etc.

//-----Topic(pub-sub)---
-1: Asynchronous receive - the receiver subscribes for topic(and is active), then sender sends many messages. It will receive all the
                           messages which were sent after tat subscription, provided the receive is active.
-2: Synchronous receive - the receiver subscribes for topic(and is active), then sends many messages. it will receive only
                           1 message which was sent after tat subscription(and not all), provided the receiver is active.
