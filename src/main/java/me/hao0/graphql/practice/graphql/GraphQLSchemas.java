package me.hao0.graphql.practice.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import me.hao0.graphql.practice.graphql.fetchers.UserFetcher;
import me.hao0.graphql.practice.graphql.fetchers.UsersFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

/**
 * Author : haolin
 * Email  : haolin.h0@gmail.com
 */
@Component
public class GraphQLSchemas {

    @Value("classpath:schema.graphqls")
    private Resource schema;

    private GraphQL graphQL;

    @Autowired
    private UserFetcher userFetcher;

    @Autowired
    private UsersFetcher usersFetcher;

    @PostConstruct
    public GraphQL initGraphQL() throws IOException {
        File s = schema.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(s);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);
        return newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                    .dataFetcher("getUsers", usersFetcher)
                    .dataFetcher("getUser", userFetcher))
                .build();
    }
}
