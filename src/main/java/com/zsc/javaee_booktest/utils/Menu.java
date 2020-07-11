package com.zsc.javaee_booktest.utils;

import lombok.Data;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author Kami
 * @Date 2020/7/1 17:55
 * @Version 1.0
 **/
@Data
public class Menu {
    String path;
    String name;
    String label;
    String icon;
    String url;
    Menu children;

    public Menu(String path, String name, String label, String icon, String url, Menu children){
        this.path = path;
        this.name = name;
        this.label = label;
        this.icon = icon;
        this.url = url;
        this.children = children;
    }
}
