package com.johnturkson.weather.util;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unused", "Duplicates"})
@Deprecated
public class AutoMatcher {
    private String text;
    private Pattern pattern;
    private Matcher matcher;
    
    private AutoMatcher(String text, Pattern pattern) {
        this.text = text;
        this.pattern = pattern;
        this.matcher = pattern.matcher(text);
    }
    
    public static AutoMatcher of(String text, String pattern) {
        return new AutoMatcher(text, Pattern.compile(pattern));
    }
    
    public static AutoMatcher of(String text, Pattern pattern) {
        return new AutoMatcher(text, pattern);
    }
    
    public String getText() {
        return text;
    }
    
    public Pattern getPattern() {
        return pattern;
    }
    
    public Matcher getMatcher() {
        return matcher;
    }
    
    /**
     * Invoking this method changes this matcher's state. If the matcher is to be used in further matching operations then it should first be reset.
     *
     * @return
     */
    public boolean find() {
        return matcher.find();
    }
    
    // TODO find better solution to find(). Should it not modify the state? should it make a copy
    //  and find it there? it is important that the behavior should remain consistent across the 
    //  class
    
    /**
     * Invoking this method changes this matcher's state. If the matcher is to be used in further matching operations then it should first be reset.
     *
     * @param start
     * @return
     */
    public boolean find(int start) {
        return matcher.find(start);
    }
    
    public boolean findAndReset() {
        boolean result = matcher.find();
        matcher.reset();
        return result;
    }
    
    public boolean findAndReset(int start) {
        boolean result = matcher.find(start);
        matcher.reset();
        return result;
    }
    
    public boolean matches() {
        return matcher.matches();
    }
    
    public void reset() {
        matcher.reset();
    }
    
    public void reset(String text) {
        matcher.reset(text);
    }
    
    public void usePattern(String pattern) {
        this.pattern = Pattern.compile(pattern);
        matcher.usePattern(this.pattern);
    }
    
    public void usePattern(Pattern pattern) {
        this.pattern = pattern;
        matcher.usePattern(this.pattern);
    }
    
    public Optional<String> findAndGetGroup() {
        return matcher.find() ? Optional.of(matcher.group()) : Optional.empty();
    }
    
    public Optional<String> findAndGetGroup(int group) {
        return matcher.find() ? Optional.of(matcher.group(group)) : Optional.empty();
    }
    
    public Optional<String> findAndGetGroup(String name) {
        return matcher.find() ? Optional.of(matcher.group(name)) : Optional.empty();
    }
    
    public Optional<Map<Integer, String>> findAndGetGroups(int... groups) {
        Map<Integer, String> results = new HashMap<>();
        if (matcher.find()) {
            for (int group : groups) {
                results.put(group, matcher.group(group));
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }
    }
    
    public Optional<Map<String, String>> findAndGetGroups(String... names) {
        Map<String, String> results = new HashMap<>();
        if (matcher.find()) {
            for (String name : names) {
                results.put(name, matcher.group(name));
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }
    }
    
    public Optional<List<String>> findAllAndGetGroup() {
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results.isEmpty() ? Optional.empty() : Optional.of(results);
    }
    
    public Optional<List<String>> findAllAndGetGroup(int group) {
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group(group));
        }
        return results.isEmpty() ? Optional.empty() : Optional.of(results);
    }
    
    public Optional<List<String>> findAllAndGetGroup(String name) {
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group(name));
        }
        return results.isEmpty() ? Optional.empty() : Optional.of(results);
    }
    
    public Optional<List<Map<Integer, String>>> findAllAndGetGroups(int... groups) {
        List<Map<Integer, String>> results = new ArrayList<>();
        while (matcher.find()) {
            Map<Integer, String> match = new HashMap<>();
            for (int group : groups) {
                match.put(group, matcher.group(group));
            }
            results.add(match);
        }
        return results.isEmpty() ? Optional.empty() : Optional.of(results);
    }
    
    public Optional<List<Map<String, String>>> findAllAndGetGroups(String... names) {
        List<Map<String, String>> results = new ArrayList<>();
        while (matcher.find()) {
            Map<String, String> match = new HashMap<>();
            for (String name : names) {
                match.put(name, matcher.group(name));
            }
            results.add(match);
        }
        return results.isEmpty() ? Optional.empty() : Optional.of(results);
    }
    
    public Optional<String> matchAndGetGroup() {
        return matcher.matches() ? Optional.of(matcher.group()) : Optional.empty();
    }
    
    public Optional<String> matchAndGetGroup(int group) {
        return matcher.matches() ? Optional.of(matcher.group(group)) : Optional.empty();
    }
    
    public Optional<String> matchAndGetGroup(String name) {
        return matcher.matches() ? Optional.of(matcher.group(name)) : Optional.empty();
    }
}
