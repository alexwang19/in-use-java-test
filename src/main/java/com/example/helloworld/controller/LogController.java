// package com.example.helloworld.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class LogController {
//     @GetMapping("/log/{message}")
//     public String logMessage(@PathVariable String message) {
//         // Dynamically load the Log4j class and invoke the logSomething method
//         try {
//             Class<?> dynamicLoggerClass = Class.forName("com.example.helloworld.controller.DynamicLogger");
//             Object dynamicLoggerInstance = dynamicLoggerClass.getDeclaredConstructor().newInstance();
//             dynamicLoggerClass.getMethod("logSomething", String.class).invoke(dynamicLoggerInstance, message);
//             return "Message logged successfully.";
//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error logging the message.";
//         }
//     }
// }