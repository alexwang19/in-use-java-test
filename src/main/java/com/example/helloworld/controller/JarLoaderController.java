package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Method;

@RestController
public class JarLoaderController {

    @GetMapping("/load-jars")
    public ResponseEntity<String> loadJars() {
        try {
            String externalJarsDirectoryPath = "/";
            ExternalJarLoader.loadJarsFromDirectory(externalJarsDirectoryPath);

            Class<?> logManagerClass = Class.forName("org.apache.logging.log4j.LogManager");
            Method getLoggerMethod = logManagerClass.getMethod("getLogger", Class.class);

            Object loggerObject = getLoggerMethod.invoke(null, JarLoaderController.class);
            org.apache.logging.log4j.Logger logger = (org.apache.logging.log4j.Logger) loggerObject;

            logger.info("This is a log message from the dynamically loaded log4j.");
            return ResponseEntity.ok("JARs loaded successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to load JARs.");
        }
    }
}
