package com.github.miyohide;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

@Component
public class HttpTriggerJava1 {
    @Autowired
    private Function<String, String> uppercase;

    @FunctionName("example")
    public String execute(
        @HttpTrigger(name = "req", methods = { HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
        ExecutionContext context) {
            return uppercase.apply("Hello World");
        }
}
