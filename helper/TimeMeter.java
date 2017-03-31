package helper;


import javax.annotation.PostConstruct;
import java.lang.reflect.Method;


/**
 * Created by stephan on 30.03.17.
 */
public class TimeMeter {
    public static void main(){
        measure(new String("hoi"),"toUpper");
    }

    public static int measure(Object object, String methodName){
        Class c = object.getClass();
        for (Method method : c.getDeclaredMethods()) {
            if (method.getAnnotation(PostConstruct.class) != null) {
                System.out.println(method.getName());
            }
        }
        return 0;
    }
}
