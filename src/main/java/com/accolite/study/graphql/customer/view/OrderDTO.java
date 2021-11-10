package com.accolite.study.graphql.customer.view;

import com.accolite.study.graphql.customer.constant.OrderStatus;
import com.accolite.study.graphql.customer.model.OrderEntity;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6426870909658342534L;

    @GraphQLId
    @GraphQLQuery(name = "id")
    private String id;

    @GraphQLId
    @GraphQLQuery(name = "customerId")
    private String customerId;

    @GraphQLQuery(name = "totalQuantity")
    @GraphQLNonNull
    private Integer totalQuantity;

    @GraphQLQuery(name = "total")
    @GraphQLNonNull
    private Double total;

    @GraphQLQuery(name = "status")
    @GraphQLNonNull
    private OrderStatus status;

    public static OrderDTO of(final OrderEntity orderEntity) {

        return new OrderDTO(
            orderEntity.getId().toString(),
            orderEntity.getCustomerId().toString(),
            orderEntity.getTotalQuantity(),
            orderEntity.getTotal(),
            orderEntity.getStatus()
        );
    }
}
