package com.tsc.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动。。。");
        //1.创建服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        //建立连接
        Socket accept = serverSocket.accept();
        //创建流对象
        //获取输入流，读取文件数据
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //获取输出流，用来保存到本地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.jpg"));
        //读写数据
        byte[] bytes = new byte[1024 * 8];
        int len;
        while ((len=bis.read(bytes))!=-1){

            bos.write(bytes,0,len);
        }
        //关闭资源
        bos.close();
        bis.close();
        accept.close();
        System.out.println("文件上传已保存");

    }
}
