/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class HistoryManager {
    private BookManager bookManager = new BookManager();
    private ReaderManager readerManager = new ReaderManager();
    private Scanner scanner = new Scanner(System.in);
    private Calendar c = new GregorianCalendar();
    public History takeOnBookToReader(Book[] books, Reader[] readers){
        System.out.println("---Список книг---");   
        bookManager.printListBooks(books);
        System.out.println("Выберите номер книги: ");
        int bookNumber = scanner.nextInt();
        Book book = books[bookNumber-1];

        System.out.println("---Список читателей---");
        readerManager.printListReaders(readers);
        System.out.println("Выберите номер читателя: ");
        int readerNumber = scanner.nextInt();
        Reader reader = readers[readerNumber-1];

        Calendar c = new GregorianCalendar();

        History history = new History();
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOnDate(c.getTime());
        return history;
    }
    public void addHistoryToArray(History history, History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i]==null){
                histories[i] = history;
                break;
            }
        }
    }
    public void printListHistories(History[] histories) {
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
    }
    public void returnBook(History[] histories){
        System.out.print("Выберите номер возвращаемой книги: ");
        int historyNumber = scanner.nextInt();
        c = new GregorianCalendar();
        histories[historyNumber - 1].setReturnDate(c.getTime());
    }
    
}
