package com.xue.utils;

import java.util.UUID;

public class IDutis {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");

    }

    public static void main(String[] args) {
        System.out.println(IDutis.getId());
    }


}
