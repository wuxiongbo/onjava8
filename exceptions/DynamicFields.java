// exceptions/DynamicFields.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A Class that dynamically adds fields to itself to
// demonstrate exception chaining

class DynamicFieldsException extends Exception {
}

public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }

        // 没有空的槽位，则添加一个：
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        fields = tmp;

        // 在扩展后的fields上递归调用：
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {

        if (value == null) {
            // 大部分异常没有支持cause参数的构造器，这种情况下，必须使用initCause()
            // Throwable 的所有子类都支持这个方法
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }

        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }

        // setField()会使用getField()取得这个数据项位置的原来的值，并将其作为返回值，而这个过程可能会抛出一个NoSuchFieldException。
        // 如果客户程序员调用getField()，他们要负责处理NoSuchFieldException，但如果这个异常是在setField()里面抛出的，那就是编程错误了，
        // 所以，我们会使用接受 cause 的构造器，将 NoSuchFieldException 转为 RuntimeException。
        Object result = null;
        try {
            result = getField(id); // 得到原来的值
        } catch (NoSuchFieldException e) {
            // 使用接受cause的构造器：
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {

        DynamicFields df = new DynamicFields(3);

//        System.out.println(df);

        try {

            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);

            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);

            System.out.println("df.getField(\"d\") : " + df.getField("d"));


            Object field = df.setField("d", null); // Exception
//            df.getField("434343");


        }
        // catch子句看起来很不一样，它以“|”操作符连接，用同一个子句处理了两种不同类型的异常。
        // 这个Java 7的特性有助于减少代码的重复，并使得指定所要捕捉的多个确切类型更容易了，而不是只能捕捉一个基类类型。
        // 我们可以通过这种方式组合众多的异常类型。
        catch (NoSuchFieldException | DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}

/* Output:
null: null
null: null
null: null

d: A value for d
number: 47
number2: 48

df: d: A new value for d
number: 47
number2: 48
number3: 11

df.getField("d") : A new value for d
DynamicFieldsException
        at
DynamicFields.setField(DynamicFields.java:64)
        at DynamicFields.main(DynamicFields.java:96)
Caused by: java.lang.NullPointerException
        at
DynamicFields.setField(DynamicFields.java:66)
        ... 1 more
*/
