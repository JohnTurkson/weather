package com.johnturkson.weather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class Service<T> {
    protected String key;
    
    public Service(Key key) {
        this.key = key.getKey();
    }
    
    public Service(String key) {
        this.key = key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public T request(String query) throws ServiceException {
        query = replaceUnsafeCharacters(query);
        URL request = generateRequest(query);
        String response = getResponse(request);
        return parseResponse(response);
    }
    
    protected abstract URL generateRequest(String query);
    
    private String getResponse(URL request) throws ServiceException {
        StringBuilder contents = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contents.append(line).append("\n");
            }
            return contents.toString();
        } catch (IOException e) {
            throw new ServiceException("Error when obtaining response.");
        }
    }
    
    protected abstract T parseResponse(String response) throws ServiceException;
    
    private String replaceUnsafeCharacters(String query) {
        Map<String, String> replacements = new LinkedHashMap<>();
        // LinkedHashMap used instead of HashMap as the first character that has to be 
        // replaced is "%" every character replaced is escaped by "%"
        replacements.put("%", "%25");
        replacements.put("+", "%2B");
        replacements.put(" ", "%20");
        replacements.put("#", "%23");
        replacements.put("\"", "%22");
        replacements.put("<", "%3C");
        replacements.put(">", "%3E");
        replacements.put("{", "%7B");
        replacements.put("}", "%7D");
        replacements.put("|", "%7C");
        replacements.put("\\", "%5C");
        replacements.put("^", "%5E");
        replacements.put("~", "%7E");
        replacements.put("[", "%5B");
        replacements.put("]", "%5D");
        replacements.put("`", "%60");
        replacements.put(";", "%3B");
        replacements.put("/", "%2F");
        replacements.put("?", "%3F");
        replacements.put(":", "%3A");
        replacements.put("@", "%40");
        replacements.put("=", "%3D");
        replacements.put("&", "%26");
        replacements.put("$", "%24");
        replacements.put("-", "%2D");
        replacements.put("_", "%5F");
        replacements.put(".", "%2E");
        replacements.put("!", "%21");
        replacements.put("*", "%2A");
        replacements.put("'", "%27");
        replacements.put("(", "%28");
        replacements.put(")", "%29");
        replacements.put(",", "%2C");
        
        for (String s : replacements.keySet()) {
            query = query.replaceAll(Pattern.quote(s), replacements.get(s));
        }
        
        return query;
    }
}
