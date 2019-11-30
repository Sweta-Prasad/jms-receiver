package com.example.jmsreceiver.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class SomeHandler implements ErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeHandler.class);

    @Override
    public void handleError(Throwable t) {
        LOGGER.error("error in listener is SUCCESS", t);
    }
}
