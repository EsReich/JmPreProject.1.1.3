package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 5);
        userDaoJDBC.saveUser("Vasiliy", "Petrov", (byte) 25);
        userDaoJDBC.saveUser("Aleksandr", "Sidorov", (byte) 35);
        userDaoJDBC.saveUser("Semen", "Semenich", (byte) 65);

        List<User> userList = userDaoJDBC.getAllUsers();
        userList.forEach(System.out::println);

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();

    }
}
