package ru.netology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

        System.out.println("Доступ предоставлен");

        scanner.close();
    }

    public static User[] getUsers() {

        User userOne = new User("Иван Иванов", "ivan", "123456", 14);
        User userTwo = new User("Петр Петров", "petya", "753qwerty", 21);
        User userThree = new User("Сидор Сидоров", "sidor", "qqq159www", 18);

        return new User[] {userOne, userTwo, userThree};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if(login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
            if(user.getAge() < 18) {
                throw new AccessDeniedException("You are too young! Access Denied!");
            }
    }
}
