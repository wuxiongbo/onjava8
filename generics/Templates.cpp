// generics/Templates.cpp
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
#include <iostream>
using namespace std;

// “Manipulator类中存放了一个T类型的对象obj，manipulate()方法则调用了obj上的f()方法。”
template<class T> class Manipulator {
  T obj;
public:
  Manipulator(T x) { obj = x; }
  void manipulate() { obj.f(); }
};

class HasF {
public:
  void f() { cout << "HasF::f()" << endl; }
};

int main() {
  HasF hf;
  Manipulator<HasF> manipulator(hf);
  manipulator.manipulate();
}
/* Output:
HasF::f()
*/
