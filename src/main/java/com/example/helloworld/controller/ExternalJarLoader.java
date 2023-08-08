package com.example.helloworld.controller;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class ExternalJarLoader {

    public static void loadJarsFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] jarFiles = directory.listFiles((dir, name) -> name.endsWith(".jar"));

        if (jarFiles != null) {
            for (File jarFile : jarFiles) {
                addJarToClasspath(jarFile);
            }
        }
    }

    private static void addJarToClasspath(File jarFile) {
        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL jarUrl;
        try {
            jarUrl = jarFile.toURI().toURL();
        } catch (Exception e) {
            throw new JarLoadingException("Failed to convert JAR file to URL: " + e.getMessage());
        }

        // Use reflection to add the URL to the classpath dynamically
        Class<?> sysClass = URLClassLoader.class;
        try {
            Method method = sysClass.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(classLoader, jarUrl);
        } catch (Exception e) {
            throw new JarLoadingException("Failed to add JAR to classpath: " + e.getMessage());
        }
    }

    public static class JarLoadingException extends RuntimeException {
        public JarLoadingException(String message) {
            super(message);
        }
    }
}
