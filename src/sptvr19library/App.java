/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;

import entity.Reader;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author user
 */
class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    public void run() {
        System.out.println("--- Библиотека ---");
        Boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Посмотреть список книг");
            System.out.println("3. Зарегистрировать читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.println("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---Конец программы---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---Добавить новую книгу---");
                    //Создадим объект книги
                    Book book = new Book("Voina i Mir","L.Tolstoi",2010);
                    books[0] = book;
                    Book book1 = new Book("Otis i deti","I.Turgenjev",2011);
                    books[1] = book1;
                    
                    System.out.println("-----------------------------------");
                    break;
                case "2":
                    System.out.println("---Список книг---");
                    for (int i = 0; i < books.length; i++) {
                        if (books[i]!=null){
                            System.out.println("Название: "+books[i].getName() + " автор: "+books[i].getAuthor());
                        }
                    }
                    System.out.println("-----------------------------------");
                    break;
                case "3":
                    System.out.println("---Зарегистрировать читателя---");
                    Reader reader = new Reader("Roman","Ivanov","roman@email.com");
                    readers[0] = reader;
                    Reader reader1 = new Reader("Ivan","Romanov","ivan@email.com");
                    readers[1] = reader1;

                    System.out.println("-----------------------------------");
                    break;
                case "4":
                    System.out.println("---Список читателей---");
                    for (int i = 0; i < readers.length; i++) {
                        if (readers[i]!=null){
                            System.out.println("Имя: "+readers[i].getFirstName() + " " + readers[i].getLastName() + " email: "+readers[i].getEmail());
                            
                        }
                    }
                    System.out.println("-----------------------------------");
                    break;
                case "5":
                    System.out.println("---Выдать книгу читателю---");
                    System.out.println("-----------------------------------");
                    break;
                case "6":
                    System.out.println("---Вернуть книгу в библиотеку---");
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("---Нет такой задачи---");

            }
        }while(repeat);
    }
}
