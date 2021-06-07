package com.example.test.jvmTest;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class OOMDirectBufferMemory {
    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     *
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
