package com.main;

import com.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.service");

      
        OrderService orderService = context.getBean(OrderService.class);

      
        System.out.println(orderService.checkout("CART001")); 
        System.out.println(orderService.checkout("CART002")); 
        System.out.println(orderService.checkout("INVALID")); 
        context.close();
    }
}
