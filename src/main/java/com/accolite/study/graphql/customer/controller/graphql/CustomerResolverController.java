package com.accolite.study.graphql.customer.controller.graphql;

import com.accolite.study.graphql.customer.service.CustomerService;
import com.accolite.study.graphql.customer.service.OrderService;
import com.accolite.study.graphql.customer.view.CustomerDTO;
import com.accolite.study.graphql.customer.view.CustomerFilterCriteriaDTO;
import com.accolite.study.graphql.customer.view.OrderDTO;
import io.leangen.graphql.annotations.*;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "customerResolverController")
@GraphQLApi
@RequiredArgsConstructor
@Slf4j
public class CustomerResolverController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @GraphQLMutation(name = "addCustomer")
    public CustomerDTO addCustomer(
        @GraphQLArgument(name = "customerReq") @GraphQLNonNull final CustomerDTO customerReq
    ) {
        return this.customerService.save(customerReq);
    }

    @GraphQLQuery(name = "customers")
    public List<CustomerDTO> customers(
        @GraphQLArgument(name = "filter") final CustomerFilterCriteriaDTO filter
    ) {
        return this.customerService.findAll(filter);
    }

    @GraphQLQuery(name = "orders")
    public List<OrderDTO> orders(
        @GraphQLContext final CustomerDTO customer
    ) {

        log.info("START: CustomerResolverController.orders with customer {}...", customer.getEmail());

        return this.orderService.customerOrders(customer);
    }
}
