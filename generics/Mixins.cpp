// generics/Mixins.cpp
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
#include <string>
#include <ctime>
#include <iostream>
using namespace std;

/*
c++ 中 模板可以继承

Java 泛型不允许这样。擦除会忘记基类类型，因此 泛型类 不能直接继承自一个泛型参数

class 派生类名:［继承方式］基类名{
    派生类新增加的成员
};


下面是 C++ 示例，它有两个混型类型：
一个（TimeStamped），使得你可以在每个对象中混入拥有一个时间戳这样的属性，
而另一个（SerialNumbered），可以混入一个序列号。
Basic


// generics/Mixins.java

*/

template <class T>
class TimeStamped : public T
{
    long timeStamp;

    public:
      TimeStamped() { timeStamp = time(0); }

    long getStamp() { return timeStamp; }
};

template <class T>
class SerialNumbered : public T
{
    long serialNumber;
    static long counter;

    public:
      SerialNumbered() { serialNumber = counter++; }

    long getSerialNumber() { return serialNumber; }
};

// Define and initialize the static storage:
template <class T>
long SerialNumbered<T>::counter = 1;

class Basic
{
    string value;

    public:
      void set(string val) { value = val; }

    string get() { return value; }
};

// 因为  C++ 能够记住其模版参数的类型
// 所以，在C++ 中，可以很容易地创建混型
int main()
{
  TimeStamped<SerialNumbered<Basic>> mixin1, mixin2;
  mixin1.set("test string 1");
  mixin2.set("test string 2");
  cout << mixin1.get() << " " << mixin1.getStamp() << " " << mixin1.getSerialNumber() << endl;
  cout << mixin2.get() << " " << mixin2.getStamp() << " " << mixin2.getSerialNumber() << endl;

  // cout  打印
  // endl  换行
}
/* Output:
test string 1 1452987605 1
test string 2 1452987605 2
*/
