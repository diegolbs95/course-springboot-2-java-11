package com.treinamento.course.entidade.pk;

import com.treinamento.course.entidade.Order;
import com.treinamento.course.entidade.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemPK implements Serializable {

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "product_id")
    private Product product;
}
