package com.example.demo.one;

public class FuTest2 {

    public static void main(String[] args) {
        Zi zi = new Zi();
    }

    static class Fu {
        // 新增static变量
        static int FU_STATIC_A = 10;
        int a = 10;

        public void printA() {
            System.out.println("Fu PrintA:" + a);
        }

        public Fu() {
            printA();
        }
    }

    static class Zi extends Fu {
        // 新增static变量
        static int ZI_STATIC_A = 20;
        int a = 20;

        @Override
        public void printA() {
            System.out.println("Zi PrintA:" + a);
        }

        public Zi() {
            // 为了方便观察，显式调用super()
            super();
            printA();
        }
    }
}

