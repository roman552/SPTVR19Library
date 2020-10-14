/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;

import tools.savers.HistorySaver;
import tools.savers.ReaderSaver;
import tools.managers.ReaderManager;
import tools.savers.BookSaver;
import entity.Reader;
import entity.Book;
import entity.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.managers.BookManager;
import tools.managers.HistoryManager;

/**
 *
 * @author user
 */
class App {
    private Book[] books = new Book[10];
    private Reader[] readers = new Reader[10];
    private History[] histories = new History[10];
    private ReaderManager readerManager = new ReaderManager();
    private BookManager bookManager = new BookManager(); 
    private HistoryManager historyManager = new HistoryManager(); 
    private Calendar c = new GregorianCalendar();
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
                    book = bookManager.createBook();
                    bookManager.addBookToArray(book, books);
                    bookManager.printListBooks(books);
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
                    System.out.println("-----------------------------------");
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    bookManager = new BookManager();    
                    bookManager.printListBooks(books);
                    break;
                case "3":
                    System.out.println("---Зарегистрировать читателя---");
                    Reader reader;
                    reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader, readers);
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);
                    System.out.println("-----------------------------------");
                    break;
                case "4":
                    System.out.println("---Список читателей---");
                    readerManager = new ReaderManager();
                    readerManager.printListReaders(readers);
                    System.out.println("-----------------------------------");
                    break;
                case "5":
                    System.out.println("---Выдать книгу читателю---");
                    History history;                
                    history = historyManager.takeOnBookToReader(books, readers);
                    historyManager.addHistoryToArray(history, histories);
                    HistorySaver historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    System.out.println("-----------------------------------");
                    break;
                case "6":
                    System.out.println("--- Возврат книги ---");
                    System.out.println("--- Список читаемых книг ---");
                    historyManager.printListHistories(histories);
                    historyManager.returnBook(histories);
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    break;
                case "7":
                    System.out.println("--- Список читаемых книг ---");
                    historyManager.printListHistories(histories);
                    break;
                default:
                    System.out.println("---Нет такой задачи---");

            }
        }while(repeat);
    }
}
