package com.tsc.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，等待连接。。。。");
        //1.创建ServerSocket对象，绑定端口，开始等待连接
        ServerSocket server = new ServerSocket(8888);
        //接收连接accept方法，返回socket对象
        Socket accept = server.accept();
        //通过accept获取输入流
        InputStream is = accept.getInputStream();
        //一次性读取数据
        byte[] bytes = new byte[1024];
        //读取数据到字节数组中
        int len = is.read(bytes);
        //解析数组打印字符信息
        String content = new String(bytes, 0, len);
        System.out.println(content);

        //回写数据
        //通过socket获取输出流
        OutputStream os = accept.getOutputStream();
        os.write("我很好，谢谢你".getBytes());
        os.close();
        //关闭资源
        is.close();
        accept.close();
    }
}
