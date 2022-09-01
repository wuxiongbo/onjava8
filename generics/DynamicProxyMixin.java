// generics/DynamicProxyMixin.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.reflect.*;
import java.util.*;


class MixinProxy implements InvocationHandler {
    // key methodName ，value 被代理类的实例
    Map<String, Object> delegatesByMethod;

    @SuppressWarnings("unchecked")
    MixinProxy(Tuple2<Object, Class<?>>... pairs) {

        delegatesByMethod = new HashMap<>();

        // 存储为 委托。
        for (Tuple2<Object, Class<?>> pair : pairs) {

            // pair.a1 被代理类的实例
            // pair.a2 被代理类的接口的class对象
            for (Method method : pair.a2.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map
                // implements the method.
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.a1);
            }

        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        // 调用 委托
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(Tuple2... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].a2;
        }

        // 获取类加载器
        ClassLoader cl = pairs[0].a1.getClass().getClassLoader();

        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

/**
 * 因为只有 “动态类型” 而不是 “静态类型” 才包含所有的 混入类型，因此，这仍旧不如 C++ 的方式好，
 *
 * 只有 “动态类型” 而不是 “静态类型” 才包含所有的 混入类型。 这句话可以这么理解，
 * 动态的 运行时期，才动态代理增强，使包含所有的混入类型。
 * 静态的 编译时期，并不包含混入类型。
 *
 * 因为，在 具有这些类型的对象的方法 可以调用之前，你被强制要求 必须先将这 些对象向下转型到恰当的类型。
 * 虽然这种方式依然不够完美，但它明显地更接近于真正的混型。
 *
 *
 * 为了让 Java 支持混型，人们已经做了大量的工作朝着这个目标努力，
 * 包括创建了至少一种附加语言（Jam 语言），它是专门用来支持混型的。
 *
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                Tuple.tuple(new BasicImp(), Basic.class),
                Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
                Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));

        Basic b = (Basic) mixin;
        b.set("Hello");
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;

        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());

    }
}
/* Output:
Hello
1611503350927
1
*/