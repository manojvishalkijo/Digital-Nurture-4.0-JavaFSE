package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the book to add: ");
        String bookName = scanner.nextLine();

        bookService.addBook(bookName);
        scanner.close();
    }
}
