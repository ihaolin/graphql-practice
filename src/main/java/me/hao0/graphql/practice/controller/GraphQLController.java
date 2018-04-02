package me.hao0.graphql.practice.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import me.hao0.graphql.practice.graphql.GraphQLSchemas;
import me.hao0.graphql.practice.model.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * GraphQL入口
 */
@RestController
@RequestMapping("/ql")
public class GraphQLController {

    private GraphQL graphQL;

    private GraphQLSchemas graphQLSchemas;

    @Autowired
    GraphQLController(GraphQLSchemas graphQLSchemas) throws IOException {
        this.graphQLSchemas = graphQLSchemas;
        graphQL = graphQLSchemas.initGraphQL();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity query(@RequestBody String query) throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: " + result.getErrors());
        return ResponseEntity.ok(result.getData());
    }

}
