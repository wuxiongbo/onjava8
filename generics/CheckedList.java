// generics/CheckedList.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using Collection.checkedList()

import pets.Cat;
import pets.Dog;
import pets.Pet;

import java.util.*;

public class CheckedList {

    /**
     * oldStyleMethod() 表示遗留代码，因为它接受的是原生的 List
     * @param probablyDogs
     */
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }


    public static void main(String[] args) {

        // 示例1： 旧方法
        // 给dogs1列表，添加一直猫。
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat



        // 示例2： 动态类型检查

        // 给dogs2列表：

        // 添加 一只猫。 抛异常
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception。  运行时异常
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }

        // 添加 派生类型。 可以正常工作
        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());

    }

}
/* Output:
Expected: java.lang.ClassCastException: Attempt to
insert class reflection.pets.Cat element into collection
with element type class reflection.pets.Dog
*/
