package com.coderscampus.assignment;

public class Main {
    public static void main(String[] args) {
        Assignment8Service service = new Assignment8Service();

        service.getData();
        while (service.numbersList.size() != 1000000) {
            System.out.println(service.numbersList.size());
        }
        service.unique();
    }
}