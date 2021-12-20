// hiding/packageaccess/PublicConstructor.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package packageaccess;

/**
 *  定义一个具有 "包访问权限" 的类时，你可以给它一个public构造器，此时编译器不会提示任何错误
 *
 *  如果使用命令gradlew hidden:checkstyleMain  来运行像 Checkstyle 这样的工具，它会指出这是虚假陈述，并且从技术上讲是错误的。
 *
 *  hiding/CreatePackageAccessObject.java
 */
class PublicConstructor {

    public PublicConstructor() {
    }

}
