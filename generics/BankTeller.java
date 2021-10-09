// generics/BankTeller.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A very simple bank teller simulation

import java.util.*;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Customer " + id;
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Teller " + id;
    }
}

class Bank {
    private List<BankTeller> tellers = new ArrayList<>();

    public void put(BankTeller bt) {
        tellers.add(bt);
    }
}

public class BankTeller {

    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serves " + c);
    }

    public static void main(String[] args) {
        // Demonstrate create():
        // 演示 create()
        RandomList<Teller> tellers = Suppliers.create(RandomList::new, Teller::new, 4);
        // Demonstrate fill():
        // 演示 fill()。使用第一个版本的fill()
        List<Customer> customers = Suppliers.fill(new ArrayList<>(), Customer::new, 12);
        customers.forEach(c -> serve(tellers.select(), c));


        // Demonstrate assisted latent typing:
        // 演示 辅助潜在分型
        Bank bank = Suppliers.fill(new Bank(), Bank::put, BankTeller::new, 3);

        // Can also use second version of fill():
        // 也可以使用第二个版本的fill()
        List<Customer> customers2 = Suppliers.fill(new ArrayList<>(),List::add, Customer::new, 12);
    }

}
/* Output:
Teller 3 serves Customer 1
Teller 2 serves Customer 2
Teller 3 serves Customer 3
Teller 1 serves Customer 4
Teller 1 serves Customer 5
Teller 3 serves Customer 6
Teller 1 serves Customer 7
Teller 2 serves Customer 8
Teller 3 serves Customer 9
Teller 3 serves Customer 10
Teller 2 serves Customer 11
Teller 4 serves Customer 12
*/
