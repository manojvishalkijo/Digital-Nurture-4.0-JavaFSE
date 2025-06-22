package com.helocan;

import java.util.Scanner;

class Logger {
    private static Logger singleInstance;

    private Logger() {
        System.out.println("Logger initialized.");
    }

    public static Logger getInstance() {
        if (singleInstance == null) {
            singleInstance = new Logger();
        }
        return singleInstance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Demo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first log message: ");
        String msg1 = scanner.nextLine();
        logger.log(msg1);

        System.out.print("Enter second log message: ");
        String msg2 = scanner.nextLine();
        logger.log(msg2);

        Logger logger2 = Logger.getInstance();
        if (logger == logger2) {
            System.out.println("Both logger instances are the same (Singleton works).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }

        scanner.close();
    }
}
