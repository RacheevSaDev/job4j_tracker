package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> usageMap = new HashMap<String, String>();
        usageMap.put("racheev.sa@gmail.com","Racheev Semyon Aleksandrovich");
        usageMap.put("pupkin@gmail.com","Pupkin Vasya Vasilievich");
        usageMap.put("sidorov@gmail.com","Sidorov Petya");
        for(String key: usageMap.keySet()) {
            String value = usageMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
