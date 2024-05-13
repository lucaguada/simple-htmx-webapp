package org.acme.webapp;

import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.IWebRequest;
import org.thymeleaf.web.IWebSession;

import java.io.InputStream;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public interface WebExchange extends IWebExchange {
}

record SimpleWebExchange() implements WebExchange {

  @Override
  public IWebRequest getRequest() {
    return new IWebRequest() {
      @Override
      public String getMethod() {
        return "";
      }

      @Override
      public String getScheme() {
        return "";
      }

      @Override
      public String getServerName() {
        return "";
      }

      @Override
      public Integer getServerPort() {
        return 0;
      }

      @Override
      public String getApplicationPath() {
        return "";
      }

      @Override
      public String getPathWithinApplication() {
        return "";
      }

      @Override
      public String getQueryString() {
        return "";
      }

      @Override
      public boolean containsHeader(String name) {
        return false;
      }

      @Override
      public int getHeaderCount() {
        return 0;
      }

      @Override
      public Set<String> getAllHeaderNames() {
        return Set.of();
      }

      @Override
      public Map<String, String[]> getHeaderMap() {
        return Map.of();
      }

      @Override
      public String[] getHeaderValues(String name) {
        return new String[0];
      }

      @Override
      public boolean containsParameter(String name) {
        return false;
      }

      @Override
      public int getParameterCount() {
        return 0;
      }

      @Override
      public Set<String> getAllParameterNames() {
        return Set.of();
      }

      @Override
      public Map<String, String[]> getParameterMap() {
        return Map.of();
      }

      @Override
      public String[] getParameterValues(String name) {
        return new String[0];
      }

      @Override
      public boolean containsCookie(String name) {
        return false;
      }

      @Override
      public int getCookieCount() {
        return 0;
      }

      @Override
      public Set<String> getAllCookieNames() {
        return Set.of();
      }

      @Override
      public Map<String, String[]> getCookieMap() {
        return Map.of();
      }

      @Override
      public String[] getCookieValues(String name) {
        return new String[0];
      }
    };
  }

  @Override
  public IWebSession getSession() {
    return new IWebSession() {
      @Override
      public boolean exists() {
        return false;
      }

      @Override
      public boolean containsAttribute(String name) {
        return false;
      }

      @Override
      public int getAttributeCount() {
        return 0;
      }

      @Override
      public Set<String> getAllAttributeNames() {
        return Set.of();
      }

      @Override
      public Map<String, Object> getAttributeMap() {
        return Map.of();
      }

      @Override
      public Object getAttributeValue(String name) {
        return null;
      }

      @Override
      public void setAttributeValue(String name, Object value) {

      }

      @Override
      public void removeAttribute(String name) {

      }
    };
  }

  @Override
  public IWebApplication getApplication() {
    return new IWebApplication() {
      @Override
      public boolean containsAttribute(String name) {
        return false;
      }

      @Override
      public int getAttributeCount() {
        return 0;
      }

      @Override
      public Set<String> getAllAttributeNames() {
        return Set.of();
      }

      @Override
      public Map<String, Object> getAttributeMap() {
        return Map.of();
      }

      @Override
      public Object getAttributeValue(String name) {
        return null;
      }

      @Override
      public void setAttributeValue(String name, Object value) {

      }

      @Override
      public void removeAttribute(String name) {

      }

      @Override
      public boolean resourceExists(String path) {
        return false;
      }

      @Override
      public InputStream getResourceAsStream(String path) {
        return null;
      }
    };
  }

  @Override
  public Principal getPrincipal() {
    return () -> "";
  }

  @Override
  public Locale getLocale() {
    return null;
  }

  @Override
  public String getContentType() {
    return "";
  }

  @Override
  public String getCharacterEncoding() {
    return "";
  }

  @Override
  public boolean containsAttribute(String name) {
    return false;
  }

  @Override
  public int getAttributeCount() {
    return 0;
  }

  @Override
  public Set<String> getAllAttributeNames() {
    return Set.of();
  }

  @Override
  public Map<String, Object> getAttributeMap() {
    return Map.of();
  }

  @Override
  public Object getAttributeValue(String name) {
    return null;
  }

  @Override
  public void setAttributeValue(String name, Object value) {

  }

  @Override
  public void removeAttribute(String name) {

  }

  @Override
  public String transformURL(String url) {
    return "";
  }
}
