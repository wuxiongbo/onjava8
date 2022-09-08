// staticchecking/dogsandrobots.go
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package main

import "fmt"

// Dog
// Go没有Class关键字，但你可以用上面的形式等价地创建基类：
//		把你平时要创建的类，改为创建struct，
//		struct中则存放着数据字段（本例中没有数据字段）。
type Dog struct{}
// 每个方法都由func关键字开头，然后，再把方法附着到类上————————用圆括号将对象引用包起来，对象引用可以是任何标识符，但这里用了this，以提醒你这就像C++或Java中的this一样。
// 然后，定义函数中剩下的部分，就和你在Go中定义任何其他函数一样。
func (this Dog) speak()     { fmt.Printf("Arf!\n") }
func (this Dog) sit()       { fmt.Printf("Sitting\n") }
func (this Dog) reproduce() {}

type Robot struct{}

func (this Robot) speak()     { fmt.Printf("Click!\n") }
func (this Robot) sit()       { fmt.Printf("Clank!\n") }
func (this Robot) oilChange() {}

// Go中也没有继承，所以这种“面向对象”的形式相当原始，可能这也是我不愿在这门语言上花费更多时间的主要原因。不过，组合的方式很直观。

/*
perform()函数使用了潜在类型机制：参数的具体类型并不重要，只要它含有speak()方法和sit()方法即可。
这里，在行内匿名地创建了interface，正如你在perform()函数的参数列表中所见。
*/
func perform(speaker interface {
	speak()
	sit()
}) {
	speaker.speak()
	speaker.sit()
}

/*
从main()中可以看出，perform()确实并不关心其参数的具体类型，只要可以在该参数上调用speak()和sit()即可。
不过，就像C++的模板函数一样，会在编译时进行参数类型校验。
语法Dog{}和Robot{}，创建了匿名的Dog和Robot的struct。
*/
func main() {
	perform(Dog{})
	perform(Robot{})
}

/* 输出：
   Arf!
   Sitting
   Click!
   Clank!
*/
