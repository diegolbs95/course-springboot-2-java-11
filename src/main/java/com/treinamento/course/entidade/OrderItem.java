package com.treinamento.course.entidade;

import com.treinamento.course.entidade.pk.OrderItemPK;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_order_item")
@Entity
@NoArgsConstructor
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItem (Order order, Product product, Integer quantity, Double price){
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder (){
        return id.getOrder();
    }
    public void setOrder (Order order){
        id.setOrder(order);
    }

    public Product getProduct (){
        return id.getProduct();
    }

    public void setProduct (Product product){
        id.setProduct(product);
    }

    public Double getSubTotal (){
        long priceAtual = Long.valueOf(String.valueOf(price)).longValue();
        double result = Math.multiplyHigh(priceAtual, quantity);
        return result;
    }

}
