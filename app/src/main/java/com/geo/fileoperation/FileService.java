package com.geo.fileoperation;

/**
 * Created by geo on 16-2-18.
 */
//package com.jay.example.filedemo1.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

import android.content.Context;

public class FileService {
    private Context context;

    public FileService(Context context) {
        super();
        this.context = context;
    }

    public FileService() {}

    public void save(String filename,String filecontent)throws Exception
    {
        //FileOutputStream output = context.openFileOutput(filename, Context.MODE_PRIVATE);
        FileOutputStream output = context.openFileOutput(filename, Context.MODE_APPEND);
        //对应参数分别为文件名,以及文件的操作方式,是覆盖,还是追加,还有权限的问题
        //这里我们使用私有模式,创建出来的文件只能被本应用访问,还会覆盖原文件哦
        output.write(filecontent.getBytes());
        //将String字符串以字节流的形式写入到输出流中
        output.close();
        //关闭输出流
    }


    //定义读取文件的方法:
    public String show(String filename)throws IOException
    {
        //打开文件输入流
        FileInputStream input = context.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //读取文件内容:
        while((len = input.read(temp)) > 0)
        {
            sb.append(new String(temp,0,len));
        }
        //关闭输入流
        input.close();
        return sb.toString();
    }

}
