/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;


import entity.Reader;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class ReaderManager {
    public Reader createReader(){
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Создание пользователя---");
        System.out.print("Имя пользователя: ");
        reader.setFirstName(scanner.nextLine());
        System.out.print("Фамилия пользователя: ");
        reader.setLastName(scanner.nextLine());
        System.out.print("Э-почта пользователя: ");
        reader.setEmail(scanner.nextLine());
        return reader;
    }    
    public void addReaderToArray(Reader reader, Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]==null){
                readers[i] = reader;
                break;
            }
        }
    }
    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if (readers[i]!=null){
                System.out.println((i+1)+". Имя: "+readers[i].getFirstName() + " " + readers[i].getLastName() + " | email: "+readers[i].getEmail());
            }
        }
    }
}
