package com.mingshashan.mybatis.learn.util;

import java.util.Random;

/**
 * @author mingshashan
 */
public class IdGenerator {

    private static final String YOUTUBE_LIKE_ID_DIC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int MIN_LENGTH = 16;
    private static final int MAX_LENGTH = 32;

    public static String generateId() {

        String input = System.currentTimeMillis() + "剑外忽传收蓟北， 初闻涕泪满衣裳。\n" +
                "却看妻子愁何在，漫卷诗书喜欲狂。\n" +
                "白日放歌须纵酒，青春作伴好还乡。\n" +
                "即从巴峡穿巫峡，便下襄阳向洛阳。";
        return genHash(input, MIN_LENGTH, MAX_LENGTH, YOUTUBE_LIKE_ID_DIC);
    }

    public static String generate(String input) {
        return genHash(input, MIN_LENGTH, MAX_LENGTH, YOUTUBE_LIKE_ID_DIC);
    }

    /**
     * Generate string unique hash based on provided dictionary
     */
    private static String genHash(String str, int minLength, int maxLength, String dictionary) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random(str.hashCode());
        int length = minLength + random.nextInt(maxLength - minLength);
        for (int i = 0; i < length; i++) {

            int id = random.nextInt(dictionary.length());
            stringBuilder.append(dictionary.charAt(id));


        }
        return stringBuilder.toString();
    }
}
