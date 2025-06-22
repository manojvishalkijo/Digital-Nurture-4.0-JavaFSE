package com.esd;

import java.util.Scanner;

interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Word document opened.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF document opened.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel document opened.");
    }
}

class DocumentFactory {
    public static Document createDocument(String type) {
        switch (type.toLowerCase()) {
            case "word": return new WordDocument();
            case "pdf": return new PdfDocument();
            case "excel": return new ExcelDocument();
            default: return null;
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter document type (word/pdf/excel): ");
        String docType = scanner.nextLine().trim();

        Document doc = DocumentFactory.createDocument(docType);

        if (doc != null) {
            doc.open();
        } else {
            System.out.println("Invalid document type.");
        }

        scanner.close();
    }
}
