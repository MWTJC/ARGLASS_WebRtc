package com.dds.core.consts;

/**
 * Created by dds on 2020/4/19.
 * ddssingsong@163.com
 */
public class Urls {

    //    private final static String IP = "192.168.2.111";//此处切换地址
    //public final static String IP = "192.168.2.222:5000";//寝室唐地址
    //public final static String IP = "192.168.1.102:5000";//实验室孟地址
    //public final static String IP = "192.168.1.106:5000";//实验室唐地址
    public final static String IP = "192.168.1.5:5000";//唐CMCC地址

    private final static String HOST = "http://" + IP + "/";

    // 信令地址
    public final static String WS = "ws://" + IP + "/ws";

    // 获取用户列表
    public static String getUserList() {
        return HOST + "userList";
    }

    // 获取房间列表
    public static String getRoomList() {
        return HOST + "roomList";
    }
}
