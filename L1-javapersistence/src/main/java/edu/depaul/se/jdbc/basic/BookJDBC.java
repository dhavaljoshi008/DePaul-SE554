package edu.depaul.se.jdbc.basic;

import java.io.Serializable;

/**
 * Book object to be used in JDBC
 */
public class BookJDBC implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    
    private String title;
    private Float price;
    
    private String description;
    private String isbn;
    private Integer numOfPages;
    private Boolean illustrations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookJDBC)) {
            return false;
        }
        BookJDBC other = (BookJDBC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.se.basic.Book[ id=" + id + ", title="+title+"]" ;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the numOfPages
     */
    public Integer getNumOfPages() {
        return numOfPages;
    }

    /**
     * @param numOfPages the numOfPages to set
     */
    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    /**
     * @return the illustrations
     */
    public Boolean getIllustrations() {
        return illustrations;
    }

    /**
     * @param illustrations the illustrations to set
     */
    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
    
}
