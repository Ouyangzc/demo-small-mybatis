package com.ouyang.mybatis.chapter05.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @ClassName Resources
 * @Description 资源加载
 * @Author OuYang
 * @Date 2023/6/27 13:57
 * @Version 1.0
 */
public class Resources {

    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    private static InputStream getResourceAsStream(String resource) throws IOException{
        ClassLoader[] classLoaders = getClassLoader();
        for (ClassLoader classLoader:classLoaders){
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if (null!=inputStream){
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }

    private static ClassLoader[] getClassLoader() {
        return new ClassLoader[]{Thread.currentThread().getContextClassLoader(),ClassLoader.getSystemClassLoader()};
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
