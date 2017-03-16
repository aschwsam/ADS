import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison {
    private static int limit = 1000;    
    
    public ListComparison(){
    }
    
    public void testMLLasc(){
        for(int k=0;k<100;k++){
            MyLinkedList mll = new MyLinkedList();
            mll.addFirst(new Object());
            long startTime = System.nanoTime();
            
            for(int i=0;i<limit;i++){
                try{
                    //mll.add(i,(int)Math.floor((Math.random()*10)+1));
                    mll.add(i,i);
                } catch (ListEmptyException e){
                    System.out.println("Shiit");
                }
            }
            
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime));
        }
    }
    
    public void testMLLrand(){
        for(int k=0;k<100;k++){
            MyLinkedList mll = new MyLinkedList();
            mll.addFirst(new Object());
            long startTime = System.nanoTime();
            
            for(int i=0;i<limit;i++){
                try{
                    mll.add(i,(int)Math.floor((Math.random()*10)+1));
                } catch (ListEmptyException e){
                    System.out.println("Shiit");
                }
            }
            
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime));
        }
    }
    
    public void testARLasc(){
        for(int k=0;k<100;k++){
            ArrayList<Integer> arl = new ArrayList<Integer>();
            long startTime = System.nanoTime();

            for(int i=0;i<limit;i++){
                arl.add(i);
            }
            
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime));
        }
    }
    
    public void testARLrand(){
    }
    
    public void testLLasc(){
       for(int k=0;k<100;k++){
            LinkedList ll = new LinkedList();
            long startTime = System.nanoTime();

            for(int i=0;i<limit;i++){
                ll.add(i);
            }
            
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime));
        }
    }
    
    public void testLLrand(){
       for(int k=0;k<100;k++){
            LinkedList ll = new LinkedList();
            long startTime = System.nanoTime();

            for(int i=0;i<limit;i++){
                ll.add(i,(int)Math.floor((Math.random()*10)+1));
            }
            
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime));
        }
    }
    
}