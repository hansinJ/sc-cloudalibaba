package com.hansin.order.design.prototype;

import java.io.*;

/**
 * @Date 10:22 2021/10/14
 **/
public class Prototype implements Cloneable, Serializable {

    /**
     * 浅复制
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 将对象以二进制流的方式写入
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
