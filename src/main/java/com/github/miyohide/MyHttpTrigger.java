package com.github.miyohide;

import java.util.Optional;
import java.util.function.Function;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyHttpTrigger {

   @Autowired
   private Function<String, String> uppercase;

   @FunctionName("example")
   public String execute(
           @HttpTrigger(name = "req", methods = { HttpMethod.GET,
                   HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
           ExecutionContext context) {

       return uppercase.apply(request.getBody().orElse("Hello World"));
   }
}
