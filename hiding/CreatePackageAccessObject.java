// hiding/CreatePackageAccessObject.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import packageaccess.*;

/**
 *
 * 实际上无法从 包外部 访问这个所谓的public构造器
 *
 * 在只有 "包访问权限" 的类 中声明一个public构造器，并不会使这个 构造器成为public的
 *
 */
public class CreatePackageAccessObject {
    public static void main(String[] args) {
//        new PublicConstructor(); // 编译报错
    }
}
