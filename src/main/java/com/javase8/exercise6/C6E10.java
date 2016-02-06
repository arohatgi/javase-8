package com.javase8.exercise6;

import com.javase8.WordStore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: eugen
 * Date: 03.12.2014
 */
public class C6E10 implements WordStore {

    @Test
    @Override
    public void perform() {
        CompletableFuture.supplyAsync(() -> readPage("http://www.horstmann.com/"))
                .thenApply(this::getLinks)
                .handle((l, e) -> {
                    if (e != null) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        return new ArrayList<>();
                    } else {
                        return l;
                    }
                })
                .thenAccept(l -> l.stream().forEach(System.out::println));
        ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
    }

    public String readPage(String urlString) {
        URL url;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            return content.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getLinks(String content) {
        List<String> links = new ArrayList<>();
        Pattern p = Pattern.compile("(?i)href=\"http://(.*?)\"");
        Matcher m = p.matcher(content);
        while (m.find()) {
            links.add(m.group(1));
        }
        if (links.size() > 0) {
            throw new RuntimeException("test Exception.");
        }
        return links;
    }
}
