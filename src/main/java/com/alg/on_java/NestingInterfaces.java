package com.alg.on_java;

class A{
    interface B{
        void f();
    }
    public class BImp implements B{
        @Override
        public void f() {

        }
    }
    private class BImp2 implements B{
        @Override
        public void f() {

        }
    }
    public interface C{
        void f();
    }
    public class CImp implements C{
        @Override
        public void f() {

        }
    }
    private class CImp2 implements C{
        @Override
        public void f() {

        }
    }

    private interface D{
        void f();
    }
    public class DImp implements D{
        @Override
        public void f() {

        }
    }
    private class DImp2 implements D{
        @Override
        public void f() {

        }
    }
    D getD(){
        return new DImp();
    }
    private D dRef;
    public void receiveD(D d){
        dRef = d;
        dRef.f();
    }
}

interface E{
    interface G{
        void f();
    }
    void g();
}
public class NestingInterfaces {
    public static void main(String[] args) {
        A a = new A();
        A.DImp ad = (A.DImp) a.getD();
        ad.f();
    }
}
