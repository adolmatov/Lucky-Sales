package dto;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 06.02.17.
 */
public class OrderDTO {
        private long id;
        private long userID;
    private Date dateOfCreation;
        private int summaryPrice;
        private List<ProductDTO> products;

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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
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

}

