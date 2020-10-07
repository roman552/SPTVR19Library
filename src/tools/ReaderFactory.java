/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.Reader;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class ReaderFactory {
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
}
