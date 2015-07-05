/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch01.ex11;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author akari
 */
public class IJ{
    public static void main(String[] args) {
        absIabsJ aiaj = new absIabsJ();
        absIdefJ aidj = new absIdefJ();
        absIstaJ aisj = new absIstaJ();
        defIstaJ disj = new defIstaJ();
        defIdefJ didj = new defIdefJ();
        staIstaJ sisj = new staIstaJ();
        supSabsI ssai = new supSabsI();
        supSdefI ssdi = new supSdefI();
        supSstaI sssi = new supSstaI();
        
        // 抽象メソッドを実装したもの優先
        aiaj.f();
        aidj.f();
        aisj.f();
        disj.f();
        // 継承したクラスで実装を書かなければならない
        didj.f();
        //sisj.f();
        // superクラスが優先
        ssai.f();
        ssdi.f();
        sssi.f();
    }
}

class absIabsJ implements absI, absJ{
    @Override
    public void f() {
        System.out.println("aiaj");
    }
}

class absIdefJ implements absI, defaultJ {
    @Override
    public void f() {
        System.out.println("aidj");
    }
}

class absIstaJ implements absI, staticJ {
    @Override
    public void f() {
        System.out.println("aisj");
    }
}


class defIdefJ implements defaultI, defaultJ {
    @Override
    public void f() {
        defaultI.super.f();
        defaultJ.super.f();
    }
}


class defIstaJ implements defaultI, staticJ { 
}

class staIstaJ implements staticI, staticJ{    
}

interface absI {
    public abstract void f();
}

interface absJ {
    public abstract void f();
}

interface defaultI {
    default public void f() {
        System.out.println("defaultI");
    }
}

interface defaultJ {
    default public void f() {
        System.out.println("defaultJ");
    }
}

interface staticI {
    public static void f() {
        System.out.println("staticI");
    }
}

interface staticJ {
    public static void f() {
        System.out.println("staticJ");
    }
}

class superS {
    public void f() {
        System.out.println("superS");
    }
}

class supSabsI extends superS implements absI {
}

class supSdefI extends superS implements defaultI {
}

class supSstaI extends superS implements staticI {
}