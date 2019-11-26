package com.pengxg.demo.generic;

import cn.hutool.json.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String... args) {
        System.out.println("【泛型类基本用法】：");
        DataContainer<String> dataContainer = new DataContainer<String>();
        dataContainer.setData("DATA");
        System.out.println(dataContainer.getData());

        System.out.println("【泛型方法】：");

        String[] arr = {"a", "s"};
        System.out.println(dataContainer.toString(arr));


    }

    @Test
    public void testErase() {
        System.out.println("【泛型擦除机制】：");
        DataContainer<String> dataContainer = new DataContainer<String>();
        DataContainer<Integer> dataContainer1 = new DataContainer<Integer>();
        System.out.println("dataContainer: " + Arrays.toString(dataContainer.getClass().getTypeParameters()));
        System.out.println("dataContainer1: " + Arrays.toString(dataContainer1.getClass().getTypeParameters()));
        System.out.println("HashMap.class:" + Arrays.toString(HashMap.class.getTypeParameters()));
        System.out.println("new HashMap<String, JSON>(): " + Arrays.toString(new HashMap<String, JSON>().getClass().getTypeParameters()));

        Manipulator manipulator = new Manipulator();
        System.out.println("manipulator: " + Arrays.toString(manipulator.getClass().getTypeParameters()));

        Class c1 = new ArrayList<Number>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2); // true, 类型限定被擦除了

        System.out.println("【结论】： 即使已经给几个泛型类实例指定了类型信息，但是在运行期仍然无法获取到指定的类型信息(<String>, <Integer>, " +
                "<String, JSON>), 这就是java语言泛型的擦除机制，这是为了兼容原先的旧代码。" +
                "不过， 编译器虽然会在编译过程中移除参数的类型信息，但是会保证类或方法内部参数类型的一致性。");
    }


    public class Manipulator<T extends Jsonify> {
        T obj;

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }
    }

    @Test
    public void testWildcard() {

        // ########################### 上界通配符 ############################
        // Plate<Fruit> plate1 = new Plate<Apple>(new Apple());
        // 上面这样的转换就是错误的, 提示类型不兼容。
        // 原因是：即使容器(Plate)中的两个类型(Fruit和Apple)之间存在继承，
        // 但是Plate<Fruit> 和 Plate<Apple> 是不存在继承关系的，
        // 因此java设计为如下方式, 使得Plate<Fruit> 和 Plate<Apple>建立继承关系。 <b><? extends T>被称为上界通配符</b>
        Plate<? extends Fruit> applePlate = new Plate<Apple>(new Apple()); // 苹果盘
        Plate<? extends Fruit> fruitPlate = new Plate<Fruit>(new Fruit()); // 水果盘

        // 下面两行setItem是无法编译通过的.
        // Java编译期只知道容器里面存放的是Fruit和它的派生类，具体是什么类型不知道，
        // 可能是Fruit？可能是Apple？也可能是Banana，RedApple，GreenApple？
        // 编译器在后面看到Plate< Apple >赋值以后，盘子里面没有标记为“苹果”。
        // 只是标记了一个占位符“CAP#1”，来表示捕获一个Fruit或者Fruit的派生类，具体是什么类型不知道。
        // 所以调用代码无论往容器里面插入Apple或者Meat或者Fruit编译器都不知道能不能和这个“CAP#1”匹配，所以这些操作都不允许。
//        applePlate.setItem(new Apple());
//        fruitPlate.setItem(new Fruit());

        // 下面两行getItem是可以编译并运行的。
        // 这个也很好理解，由于上界通配符设定容器中只能存放Fruit及其派生类，那么获取出来的内容我们都可以隐式的转为其基类Fruit（或者Object基类）。
        // 所以上界描述符Extends适合频繁读取的场景。
        Fruit apple = applePlate.getItem();
        Fruit fruit = fruitPlate.getItem();

        // ########################### 下界通配符 ############################
        // 下界通配符<? super T>不影响往里面存储，但是读取出来的数据只能是Object类型。
        // 原因是：
        // 下界通配符规定了元素最小的粒度，必须是T及其基类，那么我往里面存储T及其派生类都是可以的，因为它都可以隐式的转化为T类型。
        // 但是往外读就不好控制了，里面存储的都是T及其基类，无法转型为任何一种类型，只有Object基类才能装下。
        Plate<? super Fruit> fruitPlate1 = new Plate<Fruit>(new Fruit());
        Plate<? super Fruit> foodPlate1 = new Plate<Food>(new Food());
        // 下面这条语句编译不通过
//        Plate<? super Fruit> applePlate1 = new Plate<Apple>(new Apple());

        // PECS原则
        // 最后总结下介绍下Effective Java这本书里面介绍的PECS原则。
        //
        //
        // 上界<? extends T>不能往里存，只能往外取，适合频繁往外面读取内容的场景。
        // 下界<? super T>不影响往里存，但往外取只能放在Object对象里，适合经常往里面插入数据的场景。


    }


    // 泛型通配符
    class Food {
    }

    class Fruit extends Food {
    }

    class Apple extends Fruit {
    }

    // 盘子
    class Plate<T> {
        T item;

        public Plate() {
        }

        public Plate(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

}
