package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

@Data
@AllArgsConstructor
public class ProductManager {
  private ProductRepository repository;

  public void add(Product item) {
    repository.save(item);
  }

  public Product[] searchBy(String text) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (product.matches(text)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }
}