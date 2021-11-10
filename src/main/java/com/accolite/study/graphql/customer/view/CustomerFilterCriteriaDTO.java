package com.accolite.study.graphql.customer.view;

import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CustomerFilterCriteriaDTO {

    @GraphQLQuery(name = "name")
    @GraphQLNonNull
    private String name;
}
