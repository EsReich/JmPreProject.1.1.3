package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

//        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//
//        userDaoJDBC.createUsersTable();
//
//        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 5);
//        userDaoJDBC.saveUser("Vasiliy", "Petrov", (byte) 25);
//        userDaoJDBC.saveUser("Aleksandr", "Sidorov", (byte) 35);
//        userDaoJDBC.saveUser("Semen", "Semenich", (byte) 65);
//
//        List<User> userList = userDaoJDBC.getAllUsers();
//        userList.forEach(System.out::println);
//
//        userDaoJDBC.cleanUsersTable();
//
//        userDaoJDBC.dropUsersTable();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Ivan", "Ivanov", (byte) 5);
        userDaoHibernate.saveUser("Vasiliy", "Petrov", (byte) 25);
        userDaoHibernate.saveUser("Aleksandr", "Sidorov", (byte) 35);
        userDaoHibernate.saveUser("Semen", "Semenich", (byte) 65);

        List<User> userList = userDaoHibernate.getAllUsers();
        userList.forEach(System.out::println);

        userDaoHibernate.cleanUsersTable();

        userDaoHibernate.dropUsersTable();
    }
}
