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

        for (Tuple2<Object, Class<?>> pair : pairs) {

            // a1 被代理类的实例  a2 被代理类的接口的class对象
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
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(Tuple2... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].a2;
        }

        ClassLoader cl = pairs[0].a1.getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

/**
 * 因为只有 动态类型 而不是 静态类型 才包含所有的 混入类型，因此，这仍旧不如 C++ 的方式好，
 * 因为，在 具有这些类型的对象的方法 可以调用之前，你被强制要求 必须先将这 些对象向下转型到恰当的类型。但是，它明显地更接近于真正的混型。
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Object mixin = MixinProxy.newInstance(
                Tuple.tuple(new BasicImp(), Basic.class),
                Tuple.tuple(new TimeStampedImp(), TimeStamped.class),
                Tuple.tuple(new SerialNumberedImp(), SerialNumbered.class));

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;

        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());


//        Mixin1 mix = (Mixin1)mixin;
//        b.set("Hello11111");
//        System.out.println(mix.get());
//        System.out.println(mix.getStamp());
//        System.out.println(mix.getSerialNumber());

    }
}
/* Output:
Hello
1611503350927
1
*/


//interface Mixin1 extends Basic,TimeStamped, SerialNumbered { }