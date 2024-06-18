package com.scaledivya.ProductService.exception;

import org.aspectj.bridge.IMessageHandler;

public class ProductControllerSpecificEcception extends Exception{
    ProductControllerSpecificEcception(String message){
        super(message);
    }
}
