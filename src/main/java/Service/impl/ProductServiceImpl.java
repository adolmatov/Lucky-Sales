package Service.impl;

import Helper.Transformer;
import Service.api.ProductService;
import dao.impl.ProductDaoImpl;
import dto.ProductDTO;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 05.02.17.
 */
public class ProductServiceImpl implements ProductService{
    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOs;
        productDTOs = Transformer.transformProductListToProductDTOlist(ProductDaoImpl.getInstance().findAll());
       return productDTOs;
    }

    @Override
    public  ProductDTO findById(long id) {
        ProductDTO productDTO;
        productDTO = Transformer.transformProductToProductDTO(ProductDaoImpl.getInstance().findById(id));
        return productDTO;
    }
}
