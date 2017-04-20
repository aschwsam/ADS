package p07;

import java.util.Iterator;

public class Main {

    public static void main(String Args[]){
        Hashtable<String> table = new Hashtable(Integer.valueOf(Args[0]),true);

        //table.test();

        Iterator asd = table.iterator();
        while(asd.hasNext()){
            Object follow = asd.next();
            if(follow!=null){
                System.out.println(follow.getClass().getSimpleName());
            }
        }

        System.out.println(table.isEmpty());

        String teststring = "hello world";
        table.add(teststring);

        System.out.println(table.isEmpty());

        if(table.contains(teststring)){
            System.out.println("It has this value");
        } else {
            System.out.println("this value was not found");
        }

        Iterator xxx = table.iterator();
        while(xxx.hasNext()){
            Object follow = xxx.next();
            if(follow!=null && follow.toString().equals(teststring)){
                xxx.remove();
            }
        }

        System.out.println(table.isEmpty());
    }
}
