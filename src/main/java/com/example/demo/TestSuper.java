package com.example.demo;

public class TestSuper {

    public static void main(String[] args) {
        Son son = new Son();
    }


    static class Father {

        public String method() {
            return "father";
        }

    }

    static class Son extends Father {

        public String method() {
            return "son";
        }

        public Son() {
            System.out.println(this.getClass().getSuperclass().getName());
            System.out.println(this.getClass());
            System.out.println(super.getClass());
            System.out.println(this.method());
            System.out.println(super.method());
        }
    }
}