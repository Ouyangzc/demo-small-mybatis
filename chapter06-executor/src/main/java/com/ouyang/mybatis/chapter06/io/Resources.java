package com.ouyang.mybatis.chapter06.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @ClassName Resources
 * @Description 资源加载类
 * @Author OuYang
 * @Date 2023/7/4 10:51
 * @Version 1.0
 */
public class Resources {


    public static Reader getResourceAsReader(String location) throws IOException {
        return new InputStreamReader(getResourceAsInputStream(location));
    }

    public static InputStream getResourceAsInputStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoader();
        for (ClassLoader classLoader : classLoaders) {
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if (null != inputStream) {
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }

    private static ClassLoader[] getClassLoader() {
        return new ClassLoader[]{ClassLoader.getSystemClassLoader(), Thread.currentThread().getContextClassLoader()};
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
