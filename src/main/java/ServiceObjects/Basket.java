package ServiceObjects;

import dto.ProductDTO;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 15.02.17.
 */
public class Basket {
    private long userID;
    private int summaryPrice;
    private List<ProductDTO> products;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(int summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
