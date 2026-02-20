package com.Naveena.e_commerce.service;

import com.Naveena.e_commerce.model.Product;
import com.Naveena.e_commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());

        return repo.save(product);
    }

    public Product updateProduct(int id, Product newProduct, MultipartFile imageFile) throws IOException {

        Product existingProduct = repo.findById(id).orElse(null);

        if(existingProduct == null){
            return null;
        }

        existingProduct.setName(newProduct.getName());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setBrand(newProduct.getBrand());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setCategory(newProduct.getCategory());
        existingProduct.setReleaseDate(newProduct.getReleaseDate());
        existingProduct.setProductAvailable(newProduct.isProductAvailable());
        existingProduct.setProductQuantity(newProduct.getProductQuantity());

        if(imageFile != null && !imageFile.isEmpty()){
            existingProduct.setImageName(imageFile.getOriginalFilename());
            existingProduct.setImageType(imageFile.getContentType());
            existingProduct.setImageDate(imageFile.getBytes());
        }

        return repo.save(existingProduct);   // UPDATE happens
    }


    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
