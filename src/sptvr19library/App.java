/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;

import tools.HistorySaver;
import tools.ReaderSaver;
import tools.ReaderFactory;
import tools.BookFactory;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookSaver;

/**
 *
 * @author user
 */
class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    public App(){
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile();
        ReaderSaver readerSaver = new ReaderSaver();
        readers = readerSaver.loadFile();
        HistorySaver historySaver = new HistorySaver();
        histories = historySaver.loadFile();
    }
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
            System.out.println("7. Список читаемых книг");
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
                    Book book;
                    /**Book book = new Book("Voina i Mir","L.Tolstoi",2010);
                    *books[0] = book;
                    *Book book1 = new Book("Otis i deti","I.Turgenjev",2011);
                    *books[1] = book1;
                    */
                    BookFactory bookFactory = new BookFactory();
                    book = bookFactory.createBook();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]==null){
                            books[i] = book;
                            break;
                        }
                    }
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
                    System.out.println("-----------------------------------");
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!= null){
                            System.out.printf("%3d. Название книги: %s%nАвтор: %s%n"
                                    ,i+1
                                    ,books[i].getName()
                                    ,books[i].getAuthor()
                            );
                            System.out.println("--------------------------------");
                        }
                    }
                    break;
                case "3":
                    System.out.println("---Зарегистрировать читателя---");
                    /*Reader reader = new Reader("Roman","Ivanov","roman@email.com");
                    readers[0] = reader;
                    Reader reader1 = new Reader("Ivan","Romanov","ivan@email.com");
                    readers[1] = reader1;
                    */
                    Reader reader;
                    ReaderFactory readerFactory = new ReaderFactory();
                    reader = readerFactory.createReader();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i]==null){
                            readers[i] = reader;
                            break;
                        }
                    }
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);
                    System.out.println("-----------------------------------");
                    break;
                case "4":
                    System.out.println("---Список читателей---");
                    for (int i = 0; i < readers.length; i++) {
                        if (readers[i]!=null){
                            System.out.println((i+1)+". Имя: "+readers[i].getFirstName() + " " + readers[i].getLastName() + " | email: "+readers[i].getEmail());
                        }
                    }
                    System.out.println("-----------------------------------");
                    break;
                case "5":
                    System.out.println("---Выдать книгу читателю---");
                    System.out.println("---Список книг---");
                    for (int i = 0; i < books.length; i++) {
                        if (books[i]!=null){
                            System.out.println((i+1)+". Название: "+books[i].getName() + " | автор: "+books[i].getAuthor()+" | год издания: "+books[i].getPublishedYear());
                            System.out.println("-----------------------------------");
                        }
                    }
                    System.out.println("Выберите номер книги: ");
                    int bookNumber = scanner.nextInt();
                    book = books[bookNumber-1];
                    
                    System.out.println("---Список читателей---");
                    for (int i = 0; i < readers.length; i++) {
                        if (readers[i]!=null){
                            System.out.println((i+1)+". Имя: "+readers[i].getFirstName() + " " + readers[i].getLastName() + " | email: "+readers[i].getEmail());
                            System.out.println("-----------------------------------");
                        }
                    }
                    System.out.println("Выберите номер читателя: ");
                    int readerNumber = scanner.nextInt();
                    reader = readers[readerNumber-1];
                    Calendar c = new GregorianCalendar();
                    
                    History history = new History();
                    history.setBook(book);
                    history.setReader(reader);
                    history.setTakeOnDate(c.getTime());
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i]==null) {    
                            histories[i] = history;
                            break;
                        }
                    }
                    HistorySaver historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    System.out.println("-----------------------------------");
                    break;
                case "6":
                    System.out.println("--- Возврат книги ---");
                    System.out.println("--- Список читаемых книг ---");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null
                               && histories[i].getReturnDate() == null){
                            System.out.printf(
                              "%d. Книгу \"%s\" читает %s %s%n",
                              i+1,
                              histories[i].getBook().getName(),
                              histories[i].getReader().getFirstName(),
                              histories[i].getReader().getLastName()
                            );
                        }
                        
                    }
                    System.out.print("Выберите номер возвращаемой книги: ");
                    int historyNumber = scanner.nextInt();
                    c = new GregorianCalendar();
                    histories[historyNumber - 1].setReturnDate(c.getTime());
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    break;
                case "7":
                    System.out.println("--- Список читаемых книг ---");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null
                               && histories[i].getReturnDate() == null){
                            System.out.printf(
                              "%d. Книгу \"%s\" читает %s %s%n",
                              i+1,
                              histories[i].getBook().getName(),
                              histories[i].getReader().getFirstName(),
                              histories[i].getReader().getLastName()
                            );
                        }
                        
                    }
                    break;
                default:
                    System.out.println("---Нет такой задачи---");

            }
        }while(repeat);
    }
}
