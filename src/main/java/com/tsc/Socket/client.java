package com.tsc.Socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端发送数据");
        //1.创建Socket(ip,port),确定连接到哪里
        Socket client = new Socket("127.0.0.1", 8888);
        //2获取流对象，输出流
        OutputStream outputStream = client.getOutputStream();
        //3.写出数据
        outputStream.write("你好么，tcp 我来了".getBytes());

        //解析回写的数据
        InputStream is = client.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        java.lang.String content = new java.lang.String(bytes, 0, len);
        System.out.println(content);
        //4.关闭资源
        outputStream.close();
        client.close();
    }
}
