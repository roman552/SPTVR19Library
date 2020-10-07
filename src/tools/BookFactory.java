/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class BookFactory {
    
    public Book createBook(){
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Создание книги---");
        System.out.print("Название книги: ");
        book.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Год издания книги: ");
        book.setPublishedYear(scanner.nextInt());
        return book;
    }
}
