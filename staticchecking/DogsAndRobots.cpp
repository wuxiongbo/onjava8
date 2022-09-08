// staticchecking/DogsAndRobots.cpp
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
#include <iostream>
using namespace std;

class Dog {
public:
  void speak() { cout << "Arf!" << endl; }
  void sit() { cout << "Sitting" << endl; }
  void reproduce() {}
};

class Robot {
public:
  void speak() { cout << "Click!" << endl; }
  void sit() { cout << "Clank!" << endl; }
  void oilChange() {}
};

/*
在C++中，Dog和Robot没有任何共同之处——————它们只是恰巧有两个结构完全相同的方法。
从类型的角度看，它们是两个完全不同的类型。但是，perform()并不关心其参数的具体类型，潜在类型机制使它可以同时接受这两个类型的对象。
C++编译器保证了它确实可以发送这些信息。
如果试图传入错误的类型，编译器会给出错误信息（这些错误信息在历史上是出了名的可怕及冗长，这也是C++模板口碑不佳的主要原因）。
虽然，C++和Python检查并抛出错误的时机不同————————前者在编译时，后者在运行时
但是，这两种语言都保证了类型不会错用，因此也都可以被认为是强类型的语言。
潜在类型机制并不会违背 强类型机制。
*/
template<class T> void perform(T anything) {
  anything.speak();
  anything.sit();
}

int main() {
  Dog d;
  Robot r;
  perform(d);
  perform(r);
}
/* 输出：
Arf!
Sitting
Click!
Clank!
*/