package com.example.test.jvmTest;

public class JvmParameterTest {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();//jvm虚拟机中的内存总量，单位字节
        long maxMemory = Runtime.getRuntime().maxMemory();//jvm虚拟机试图使用的最大内存，单位字节
        System.out.println("虚拟机内存总量"+totalMemory/1024/1024+"M");
        System.out.println("虚拟机最大内存总量"+maxMemory/1024/1024+"M");
    }
}
