package com.mabdullaev.lesson2.controller;

import com.mabdullaev.lesson2.model.Cart;
import com.mabdullaev.lesson2.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MainMenu {
    Scanner scanner;
    @Autowired
    private ApplicationContext context;

    private void printProducts(ProductRepository repository) {
        repository.printProducts();
    }

    private void printCart(Cart cart) {
        cart.printCart();
    }

    private void addProduct(Cart cart) {
        int id;
        int delta;

        System.out.println("Product id:");
        id = scanner.nextInt();
        System.out.println("Quantity:");
        delta = scanner.nextInt();
        cart.addProductToCart(id, delta);
    }

    private void removeProduct(Cart cart) {
        int id;

        System.out.println("Product id:");
        id = scanner.nextInt();
        cart.removeProductFromCart(id);
    }

    private void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public void showMenu() {
        String[] options = {"1- Show available products",
                "2- Show products in cart",
                "3- Add product to cart",
                "4- Remove product from cart",
                "5- New cart",
                "6- Exit",
        };
        scanner = new Scanner(System.in);
        int option;
        Cart cart = null;
        ProductRepository repository;
        while (true) {
            printMenu(options);
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    repository = context.getBean(ProductRepository.class);
                    printProducts(repository);
                    break;
                }
                case 2: {
                    if (cart == null) {
                        cart = context.getBean(Cart.class);
                    }
                    printCart(cart);
                    break;
                }
                case 3: {
                    if (cart == null) {
                        cart = context.getBean(Cart.class);
                    }
                    addProduct(cart);
                    break;
                }
                case 4:
                    removeProduct(cart);
                    break;
                case 5:
                    cart = context.getBean(Cart.class);
                    break;
                case 6:
                    return;
            }
        }
    }


}
