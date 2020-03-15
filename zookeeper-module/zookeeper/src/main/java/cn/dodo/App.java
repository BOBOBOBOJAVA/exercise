package cn.dodo;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.core.SpringProperties;
import org.springframework.core.convert.ConversionException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        byte[] b = "中国".getBytes();
        byte[] b1 = "中国".getBytes();
        new String(b);
    }

}
