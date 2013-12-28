package edu.depaul.cdm.se.setup;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@SessionScoped
@Named
public class BookBean implements Serializable {
    private static final Logger logger = Logger.getLogger(BookBean.class.getName());
    
    @Resource(name="jdbc/SE554")
    private DataSource ds;
    
    public List<Book> getBookList() throws SQLException {
        System.out.println("getBookList");
        logger.info("Before getting connection");
        Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from BOOK");
        ResultSet result = ps.executeQuery();
        logger.info("After executing query");
        
        List<Book> list = new ArrayList();
        
        while (result.next()) {
            Book b = new Book();
            b.setId(result.getLong("id"));
            b.setTitle(result.getString("title"));
            b.setPrice(result.getFloat("price"));
            list.add(b);
        }
        
        logger.info("Before returning");
        
        return list;
    }
}