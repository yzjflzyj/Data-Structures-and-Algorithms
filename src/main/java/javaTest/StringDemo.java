package javaTest;

public class StringDemo {
    public static void main(String[] args) {

        String str1 = new StringBuilder("哈哈").append("哈").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println("------------");

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
        /**
         * String::intern() 是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字串添加到常量池中，并且返回此String对象的引用。
         * 在JDK6或更早之前的HotSpot虚拟机中，常量池都是分配在永久代中，我们可以通过 -XX:PermSize 和 -XX:MaxPermSize 限制永久代的大小，即可间接限制其中常量池的容量.
         * JDK6及之前版本会拷贝字符串的实例到永久代的运行时常量池中,结果是false,false.JDK7之后,永久代中的运行时常量池迁到堆中,不必再拷贝了,只是一个堆的引用,结果是true,false
         * JDK8之后永久代取消,元空间是直接使用物理内存,运行时常量池仍在堆中,结果还是true,false
         *
         *
         * 第二个为false的原因是System.initializeSystemClass(),在JDK类库初始化时被加载和初始化;方法中sun.misc.Version.init(); Vsersion类中静态常量launcher_name放入值是"java",初始化时放入字符串常量池StringTable中
         * Vsersion由类加载器和rt.jar - 根加载器提前部署加载rt.jar
         */

    }
}
