/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Reader;
import entity.User;
import java.util.Scanner;
import tools.managers.ReaderManager;
import tools.savers.ReaderSaver;
import tools.savers.UserSaver;

/**
 *
 * @author user
 */
public class SecureManager {
    private Scanner scanner = new Scanner(System.in);
    
    public User checkTask(User[] users, Reader[] readers) {
        int numTask = -1;
        do{
            System.out.println("Ваш выбор: ");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход в систему");
            System.out.println("Введите номер задачи: ");
            String task = scanner.nextLine();
            UserManager userManager = new UserManager();
            try {
                numTask = Integer.parseInt(task);
                if(numTask >= 0 && numTask < 3){
                   if(numTask == 0){
                       System.out.println("Пока! :)");
                       System.exit(0);
                   }else if(numTask == 1){
                       User regUser = userManager.regUser();
                       userManager.addUserToArray(regUser, users);
                       ReaderManager readerManager = new ReaderManager();
                       readerManager.addReaderToArray(regUser.getReader(), readers);
                       ReaderSaver readerSaver = new ReaderSaver();
                       readerSaver.saveReaders(readers);
                       UserSaver userSaver = new UserSaver();
                       userSaver.saveUsers(users);
                   }else if(numTask == 2){
                       return userManager.getAuthUser(users);
                   }
                }
               
            } catch (Exception e) {
                System.out.println("Нет такой задачи. Выберите из перечисленных");
            }
         }while(true);
    }
    
}
