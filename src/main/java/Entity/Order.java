package Entity;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public class Order {
    private long id;
    private long userID;
     private Date dateOfCreation;
    private int summaryPrice;
    private List<Product> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

        public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(int summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
