package com.accolite.study.graphql.customer.view;

import com.accolite.study.graphql.customer.model.CustomerEntity;
import io.leangen.graphql.annotations.GraphQLId;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class CustomerDTO {

    @GraphQLId
    @GraphQLQuery(name = "id")
    private String id;

    @GraphQLQuery(name = "email")
    @GraphQLNonNull
    @EqualsAndHashCode.Include
    private String email;

    @GraphQLQuery(name = "name", deprecationReason = "Instead use fullName")
    @GraphQLNonNull
    private String name;

    @GraphQLQuery(name = "fullName")
//    @GraphQLNonNull
    private String fullName;

    public static CustomerDTO of(final CustomerEntity customerEntity) {

        return new CustomerDTO(
            customerEntity.getId().toString(),
            customerEntity.getEmail(),
            customerEntity.getName(),
            customerEntity.getName()
        );
    }

    public CustomerEntity convertIntoEntity() {

        return new CustomerEntity(
            null == this.getId() ? null : UUID.fromString(this.getId()),
            this.getEmail(),
            this.name
        );
    }
}
