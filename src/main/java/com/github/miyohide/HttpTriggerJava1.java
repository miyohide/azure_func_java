package com.github.miyohide;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

@Component
public class HttpTriggerJava1 {
    private final Function<String, String> uppercase;

    public HttpTriggerJava1(Function<String, String> uppercase) {
        this.uppercase = uppercase;
    }

    @FunctionName("example")
    public String execute(
        @HttpTrigger(name = "req", methods = { HttpMethod.GET }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
        ExecutionContext context) {
            return uppercase.apply("Hello World");
        }
}
