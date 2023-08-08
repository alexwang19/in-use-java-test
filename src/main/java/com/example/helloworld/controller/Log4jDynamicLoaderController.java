// package com.example.helloworld.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/api")
// public class Log4jDynamicLoaderController {

//     @GetMapping("/load-log4j/{message}")
//     public String loadLog4j(@PathVariable String message) {
//         try {
//             // Dynamically load Log4j class
//             Class<?> dynamicLoggerClass = Class.forName("org.apache.logging.log4j.LogManager");
//             // Class<?> dynamicLoggerClass2 = Class.forName("org.apache.logging.log4j.Logger");
//             ClassLoader classLoader = dynamicLoggerClass.getClassLoader();
//             System.out.println("Class = " + classLoader.getName());
//             Object dynamicLoggerInstance = dynamicLoggerClass.getDeclaredConstructor();
//             // dynamicLoggerClass.getMethod("logger", String.class).invoke(dynamicLoggerInstance, message);
//             // Log4j is now loaded and ready to be used
//             return "Log4j loaded successfully!";
//         } catch (Exception e) {
//             return "Failed to load Log4j: " + e.getMessage();
//         }
//     }
// }
