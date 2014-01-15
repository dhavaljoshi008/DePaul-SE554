package edu.depaul.cdm.se.setup;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@SessionScoped
@Named
public class BookBean implements Serializable {
    private static final Logger logger = Logger.getLogger(BookBean.class.getName());
    
    @PersistenceContext(unitName = "bookPU")
    private EntityManager entityManager;
     
    public List<Book> getBookList() throws SQLException {
        logger.info("Before getting connection");
        
        Query query = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> list =  query.getResultList();
        
        logger.info("Before returning: " + list.size());
        
        return list;
    }
}