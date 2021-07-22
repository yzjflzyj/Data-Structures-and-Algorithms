package com.example.test.jvmTest;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class OOMDirectBufferMemory {
    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     * 直接内存  sun.misc.VM.maxDirectMemory()
     *
     * 写NIO程序经常使用ByteBuffer来读取或者写入数据，这是一种基于通道(Channel)与缓冲区(Buffer)的IO方式，它可以使用Native函数库直接分配堆外内存，然后通过一个存储在Java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作。
     * 这样能在一些场景中显著提高性能，因为避兔了在Java堆和Native堆中来回复制数据。
     * ByteBuffer.allocate(capability) 第一种方式是分配VM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢。
     * ByteBuffer.allocateDirect(capability) 第二种方式是分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快。
     * 但如果不断分配本地内存，堆内存很少使用，那么JV就不需要执行GC，DirectByteBuffer对象们就不会被回收，这时候堆内存充足，但本地内存可能已经使用光了，再次尝试分配本地内存就会出现OutOfMemoryError，那程序就直接崩溃了。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(String.format("配置的maxDirectMemory: %.2f MB",//
                sun.misc.VM.maxDirectMemory() / 1024.0 / 1024));

        TimeUnit.SECONDS.sleep(3);

        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
