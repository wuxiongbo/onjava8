# staticchecking/DogsAndRobots.py
# (c)2021 MindView LLC: see Copyright.txt
# We make no guarantees that this code is fit for any purpose.
# Visit http://OnJava8.com for more book information.

class Dog:
    def speak(self):
        print("Arf!")
    def sit(self):
        print("Sitting")
    def reproduce(self):
        pass

class Robot:
    def speak(self):
        print("Click!")
    def sit(self):
        print("Clank!")
    def oilChange(self):
        pass

# 在perform(anything)中，并没有关于anything的类型信息，anything只是一个标识符。
# 它必须执行perform()要求执行的操作，所以，相当于隐藏了一个接口。
# 不过，你永远不需要显式地写出该接口——————它是潜在的。
# perform()并不关心它的参数类型，因此，可以向其传入任何对象，只要该对象支持speak()和sit()方法接口。
# 如果向perform()传入了不支持这些操作的对象，就会抛出 运行时 异常。
def perform(anything):
    anything.speak()
    anything.sit()

a = Dog()
b = Robot()
perform(a)
perform(b)

output = """
Arf!
Sitting
Click!
Clank!
"""