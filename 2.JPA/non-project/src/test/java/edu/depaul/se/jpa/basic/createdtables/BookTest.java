package edu.depaul.se.jpa.basic.createdtables;

import edu.depaul.se.jpa.basic.AbstractJPATest;
import java.util.List;
import javax.persistence.EntityTransaction;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest extends AbstractJPATest{
    
    public BookTest() {
    }

    @Test
    public void testBookCRUD() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");
        
        EntityTransaction tx = getEm().getTransaction();
        
        tx.begin();
        getEm().persist(book);
        tx.commit();
        assertNotNull("ID should have been generated and populated after persist", 
                book.getId());
        
        List<Book> books = 
                getEm().createNamedQuery("findAllBooks").getResultList();
        assertEquals(1, books.size());
        
        tx = getEm().getTransaction();
        tx.begin();
        book = getEm().find(Book.class, new Long(1));
        book.setTitle(book.getTitle() + " 2nd edition");
        tx.commit();
        
        Book updatedBook = 
                getEm().createNamedQuery("findAllBooks", Book.class).getSingleResult();
        assertEquals(book, updatedBook);
        
        int priorCount = getEm().createNamedQuery("findAllBooks").getResultList().size();
        tx = getEm().getTransaction();
        tx.begin();
        book = getEm().find(Book.class, new Long(1));
        getEm().remove(book);
        tx.commit();
        
        int afterCount = getEm().createNamedQuery("findAllBooks").getResultList().size();

        assertEquals(afterCount + 1, priorCount);
    }
    
    @Test
    public void testBookService() {
        Book book = new Book();
        book.setTitle("Beginning Java Persistence");
        
        BookService service = new BookService();
        service.saveBook(book);
        assertNotNull("ID should have been generated and populated after persist", 
                book.getId());
        
        List<Book> books = service.getAllBooks(); 
        assertEquals(1, books.size());
    }
    
    
}
