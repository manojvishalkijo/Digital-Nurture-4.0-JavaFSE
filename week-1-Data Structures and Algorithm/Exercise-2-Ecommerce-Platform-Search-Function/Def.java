package com.da;

import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName.toLowerCase();
        this.category = category;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class Def {

    public static Product linearSearch(Product[] products, String name) {
        name = name.toLowerCase();
        for (Product p : products) {
            if (p.productName.equals(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String name) {
        name = name.toLowerCase();
        int left = 0, right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].productName.compareTo(name);
            if (cmp == 0) return sortedProducts[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] originalProducts = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "T-shirt", "Clothing"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Shoes", "Footwear"),
            new Product(5, "Book", "Education")
        };

        Product[] sortedProducts = Arrays.copyOf(originalProducts, originalProducts.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        Product linearResult = linearSearch(originalProducts, searchName);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Not Found"));

        Product binaryResult = binarySearch(sortedProducts, searchName);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Not Found"));

        scanner.close();
    }
}
