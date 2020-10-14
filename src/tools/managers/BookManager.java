/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class BookManager {
    public void addBookToArray(Book book, Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null){
                books[i] = book;
                break;
            }
        }
    }

    public void printListBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i]!=null){
                System.out.println((i+1)+". Название: "+books[i].getName() + ". Автор " + books[i].getAuthor()+ " | год: "+books[i].getPublishedYear());
            }
        }
    }
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
