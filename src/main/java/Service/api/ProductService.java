package Service.api;

import dto.ProductDTO;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 05.02.17.
 */
public  interface ProductService {
    List<ProductDTO> findAllProducts();
    ProductDTO findById(long id);

}
