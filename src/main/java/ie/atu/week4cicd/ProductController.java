package ie.atu.week4cicd;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
     public ProductController(){
         productList.add(new Product("1", "TV", "Electronics", 600.0));
         productList.add(new Product("2", "Phone", "Electronics", 500.0));
     }
     @GetMapping
    public List<Product> getAllProducts(){
         return productList;
     }

    @GetMapping("/getProducts")
    public List<Product> getProduct(){
        return productList;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product){
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable String id,@RequestBody Product product) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                productList.remove(p);
            }
        }
        productList.add(product);
        return ResponseEntity.ok(productList);
    }
}
