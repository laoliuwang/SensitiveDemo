package com.cw;

public class ThreadLocalTest2 {
    static InheritableThreadLocal<String> localVar = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        localVar.set("local value");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程获取到的本地线程变量值 :" + localVar.get());
            }
        });
        t1.start();
        System.out.println("main线程获取到的本地线程变量值：" + localVar.get());


        localVar.remove();
    }
}
