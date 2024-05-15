package org.acme.webapp;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Request;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;
import gg.jte.resolve.ResourceCodeResolver;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

public interface Webapp {
  record Model(String firstName, String lastName) {}

  static void main(String[] args) throws IOException {
    var resolver = new ResourceCodeResolver("wwwroot");
    var engine = TemplateEngine.create(resolver, ContentType.Html);
    var output = new StringOutput();
    engine.render("index.jte", new Model("Bilbo", "Baggins"), output);

    var httpServer = HttpServer.create(new InetSocketAddress(8080), -1);
    httpServer.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    httpServer.createContext("/manifest", exchange -> {
      System.out.printf("Manifest requested: %s%n", exchange.getRequestURI().getPath());
      try (final var manifest = getResource(exchange); final var body = exchange.getResponseBody()) {
        var requestPath = exchange.getRequestURI().getPath();
        var bytes = Objects.requireNonNull(manifest, () -> "Can't read manifest %s".formatted(requestPath)).readAllBytes();

        if (requestPath.endsWith("ico")) {
          exchange.getResponseHeaders().add("Content-Type", "image/x-icon");
        } else if (requestPath.endsWith("png")) {
          exchange.getResponseHeaders().add("Content-Type", "image/png");
        } else if (requestPath.endsWith("svg")) {
          exchange.getResponseHeaders().add("Content-Type", "image/svg+xml");
        } else if (requestPath.endsWith("webmanifest")) {
          exchange.getResponseHeaders().add("Content-Type", "plain/text");
        }

        exchange.sendResponseHeaders(200, bytes.length);
        body.write(bytes);
      }
    });

    httpServer.createContext("/font", exchange -> {
      System.out.printf("Font requested: %s%n", exchange.getRequestURI().getPath());
      try (final var font = getResource(exchange); final var body = exchange.getResponseBody()) {
        var bytes = Objects.requireNonNull(font, () -> "Can't read font %s".formatted(exchange.getRequestURI().getPath())).readAllBytes();
        exchange.getResponseHeaders().add("Content-Type", "font/woff2");
        exchange.sendResponseHeaders(200, bytes.length);
        body.write(bytes);
      }
    });

    httpServer.createContext("/img", exchange -> {
      System.out.printf("Image requested: %s%n", exchange.getRequestURI().getPath());
      try (final var image = getResource(exchange); final var body = exchange.getResponseBody()) {
        var bytes = Objects.requireNonNull(image, () -> "Can't read image %s".formatted(exchange.getRequestURI().getPath())).readAllBytes();
        var requestPath = exchange.getRequestURI().getPath();
        if (requestPath.endsWith("jpeg")) {
          exchange.getResponseHeaders().add("Content-Type", "image/jpeg");
        } else if (requestPath.endsWith("jpg")) {
          exchange.getResponseHeaders().add("Content-Type", "image/jpeg");
        } else if (requestPath.endsWith("svg")) {
          exchange.getResponseHeaders().add("Content-Type", "image/svg+xml");
        } else if (requestPath.endsWith("png")) {
          exchange.getResponseHeaders().add("Content-Type", "image/png");
        }

        exchange.sendResponseHeaders(200, bytes.length);
        body.write(bytes);
      }
    });

    httpServer.createContext("/css", exchange -> {
      System.out.printf("CSS requested: %s%n", exchange.getRequestURI().getPath());
      try (final var css = getResource(exchange); final var body = exchange.getResponseBody()) {
        var bytes = Objects.requireNonNull(css, () -> "Can't read CSS %s".formatted(exchange.getRequestURI().getPath())).readAllBytes();
        exchange.getResponseHeaders().add("Content-Type", "text/css");
        exchange.sendResponseHeaders(200, bytes.length);
        body.write(bytes);
      }
    });

    httpServer.createContext("/js", exchange -> {
      System.out.printf("JS requested: %s%n", exchange.getRequestURI().getPath());
      try (final var js = getResource(exchange); final var body = exchange.getResponseBody()) {
        var bytes = Objects.requireNonNull(js, () -> "Can't read JS %s".formatted(exchange.getRequestURI().getPath())).readAllBytes();
        exchange.getResponseHeaders().add("Content-Type", "application/javascript");
        exchange.sendResponseHeaders(200, bytes.length);
        body.write(bytes);
      }
    });

    httpServer.createContext("/", exchange -> {
      var rendered = output.toString().getBytes(UTF_8);
      exchange.getResponseHeaders().add("Content-Type", "text/html");
      exchange.sendResponseHeaders(200, rendered.length);
      try (final var body = exchange.getResponseBody()) {
        body.write(rendered);
      }
    });
    httpServer.start();
  }

  static InputStream getResource(Request exchange) {
    var classLoader = Webapp.class.getClassLoader();
    var requested = "wwwroot%s".formatted(exchange.getRequestURI().getPath());
    var resource = classLoader.getResource(requested);
    System.out.printf("Resource found %s%n", resource);
    return classLoader.getResourceAsStream(requested);
  }
}
