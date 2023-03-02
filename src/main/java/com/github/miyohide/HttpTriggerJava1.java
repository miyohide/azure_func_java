package com.github.miyohide;

import java.util.*;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class HttpTriggerJava1 {
    @Autowired
    private Function<String, String> uppercase;

    @FunctionName("HttpTriggerJava1")
    public String run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("name");
        String name = request.getBody().orElse(query);

        if (name == null) {
            return uppercase.apply("Please input your name...");
        } else {
            return uppercase.apply(name);
        }
    }
}
