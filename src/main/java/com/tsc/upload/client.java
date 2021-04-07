package com.tsc.upload;


import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
        //创建流对象，读取本地的配置文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.jpg"));
        //创建输出流，写到服务端
        Socket client = new Socket("127.0.0.1", 7777);
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        //写出数据
        byte[] bytes = new byte[1024 * 8];
        int len;
        while ((len=bis.read())!=-1){
            bos.write(bytes,0,len);
            bos.flush();
        }
        //释放资源
        bos.close();
        client.close();
        bis.close();

    }
}
