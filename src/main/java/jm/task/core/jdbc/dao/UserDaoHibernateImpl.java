package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {

    Session session;
    Transaction transaction;
    private String sql;

    public UserDaoHibernateImpl() {

    }

    private void openSessionAndBeginTransaction() {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void commitTransactionAndCloseSession() {
        transaction.commit();
        session.close();
    }

    @Override
    public void createUsersTable() {
        openSessionAndBeginTransaction();

        sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL)";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        commitTransactionAndCloseSession();
    }

    @Override
    public void dropUsersTable() {
        openSessionAndBeginTransaction();

        sql = "DROP TABLE IF EXISTS users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        commitTransactionAndCloseSession();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        openSessionAndBeginTransaction();

        session.save(new User(name, lastName, age));
        System.out.println("User " + name + " " + lastName + " добавлен в базу данных");

        commitTransactionAndCloseSession();
    }

    @Override
    public void removeUserById(long id) {
        openSessionAndBeginTransaction();

        sql = "DELETE FROM users WHERE id = ?";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.setLong(0, id);
        query.executeUpdate();

        commitTransactionAndCloseSession();
    }

    @Override
    public List<User> getAllUsers() {
        openSessionAndBeginTransaction();

        sql = "SELECT id, name, lastName, age FROM users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        List<User> userList = query.list();

        commitTransactionAndCloseSession();

        return userList;
    }

    @Override
    public void cleanUsersTable() {
        openSessionAndBeginTransaction();

        sql = "DELETE FROM users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        commitTransactionAndCloseSession();
    }
}
