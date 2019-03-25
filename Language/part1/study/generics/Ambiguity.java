package study.generics;

/**
 * Ambiguity caused by erasure on overloaded methods.
 */
class MyGenClass<T, V extends Number>
{
    T ob1;
    V ob2;
    
    MyGenClass(T ob1, V ob2)
    {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
    
    public void set(T newVal)
    {
        System.out.println("Calling set for type T");
        ob1 = newVal;
    }
    
    public void set(V newVal)
    {
        System.out.println("Calling set for type V");
        ob2 = newVal;
    }
}

public class Ambiguity
{

    public static void main(String[] args)
    {
        MyGenClass<String, Number> xz = new MyGenClass<>("Ambiguity", 5);

        xz.set(8);
        
        //MyGenClass<Number, Number> xz1 = new MyGenClass<>(8, 5);
        
        // below will not compile
        //xz1.set(8);
    }

}
