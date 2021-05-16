package com.company.view;

import com.company.Factory;
import com.company.context.Config;
import com.company.view.decorators.ControllerDecorator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/*
Decorator
 */
public class StackView {

    private final Scanner scanner = new Scanner(System.in);

    public void menu() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ControllerDecorator controllerDecorator = context.getBean(ControllerDecorator.class);
//        ControllerDecorator controllerDecorator = Factory.crateControllerDecorator();
        int option;

        do {
            do {
                System.out.println("Please pick menu option:");
                System.out.println("1. Get class name and superclass names\n" +
                        "2. Invoke by annotation (ano)\n" +
                        "3. Get details about class\n" +
                        "4. Get class modifiers\n" +
                        "5. Try proxy\n" +
                        "0. EXIT");
                option = getOption();
            } while (option > 5 || option < 0);

            if (option == 0) break;

            try {
                System.out.println(controllerDecorator.show(option) + "\n");
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } while (true);
        System.out.println("Bye!");
    }

    private int getOption() {
        String str;
        do {
            str = scanner.nextLine().trim();
        } while (!str.matches("\\d"));
        return Integer.parseInt(str);
    }
}
