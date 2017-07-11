package com.wit.hbcs.qic.it.htmldb.base;

public class ServerUtils {

    private static int serverPort;

    /**
     * 返回全路径。
     *
     * @param path
     * @return
     */
    public static String getServerUri(String path) {
        String uri = "http://localhost:" + serverPort + "/hwq" + path;
        return uri;
    }

    public static void setServerPort(int port) {
        serverPort = port;
    }

}
