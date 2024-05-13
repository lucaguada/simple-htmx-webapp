package org.acme.webapp;

import com.sun.net.httpserver.HttpServer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.EngineContext;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.web.IWebExchange;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface Webapp {

  static void main(String[] args) throws IOException {
    var templateResolver = new FileTemplateResolver();
    templateResolver.setCacheable(true);
    templateResolver.setCacheTTLMs(3600000L);
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setPrefix("/template");
    templateResolver.setSuffix(".html");

    var templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);

    templateEngine.process("index", new WebContext());

    var httpServer = HttpServer.create(new InetSocketAddress(8080), -1);
    httpServer.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    httpServer.createContext("/", exchange -> {
      var helloWorld = "Hello World";
      exchange.sendResponseHeaders(200, helloWorld.length());
      try (final var body = exchange.getResponseBody()) {
        body.write(helloWorld.getBytes(UTF_8));
      }
    });
    httpServer.start();
  }
}
