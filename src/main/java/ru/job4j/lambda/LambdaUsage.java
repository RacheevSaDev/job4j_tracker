package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.getSize() + " : " + left.getSize());
            return  Integer.compare(right.getSize(), left.getSize());
        };
        Attachment att1 = new Attachment("att1", 100);
        Attachment att2 = new Attachment("att2", 120);
        cmpDescSize.compare(att1, att2);
    }
}
