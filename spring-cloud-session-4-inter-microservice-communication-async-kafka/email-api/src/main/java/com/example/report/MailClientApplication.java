package com.example.report;

import com.example.report.models.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class MailClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailClientApplication.class, args);
    }

    @StreamListener(Processor.INPUT)
    public void receivedEmail(Employee employee) {
        System.out.println("Received employee details: " + employee);
        System.out.println("Sending email and sms: "+employee.getName());
    }

}