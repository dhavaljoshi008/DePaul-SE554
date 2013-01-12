package edu.depaul.se.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Database access using JDBC
 */
public class BookDAO {

    private static final String CONNECTION_URL = "jdbc:hsqldb:mem:.";
    private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
    private static final String USER_NAME = "";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    public BookDAO() {
    }

    public void persist(BookJDBC book) {
    }

    public List<BookJDBC> getAllBooks() throws SQLException {
        ArrayList<BookJDBC> books = new ArrayList<BookJDBC>();

        // Step 2:  Request a connection from the DriverManager
        Connection con = DriverManager.getConnection(
                CONNECTION_URL, USER_NAME, PASSWORD);

        // Step 3:  Create a statement where the SQL statement will be provided
        Statement stmt = con.createStatement();

        // Step 4:  Get the resultset from the result of executing a query
        ResultSet rs = stmt.executeQuery("select * from Book");

        // Step 5:  Processing the result
        BookJDBC book;
        while (rs.next()) {
            book = map(rs);
            books.add(book);
        }

        // Step 6:  Closing the connection
        rs.close();
        stmt.close();
        con.close();

        return books;
    }

    private BookJDBC map(ResultSet rs) throws SQLException {
        BookJDBC book = new BookJDBC();
        book.setId(rs.getLong("ID"));
        book.setTitle(rs.getString("TITLE"));
        book.setIllustrations(rs.getBoolean("illustrations"));
        book.setPrice(rs.getFloat("price"));
        return book;
    }
}
