package com.null01.util;

import com.null01.dbmetadata.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * IO工具类
 * Created by Roxy on 2019/7/21.
 */
public class IOUtil {

    private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);

    private static IOUtil instance = new IOUtil();

    private IOUtil(){};

    public static IOUtil getInstance(){
        return instance;
    }

    /**
     * 获取用于生成文件用的bufferedWriter
     */
    public BufferedWriter getBufferedWriter(String path){
        FileOutputStream fo = null;
        OutputStreamWriter ow = null;
        BufferedWriter bw = null;
        try{

            fo = new FileOutputStream(path);
            ow = new OutputStreamWriter(fo,"UTF-8");
            bw = new BufferedWriter(ow);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return bw;
    }

}
