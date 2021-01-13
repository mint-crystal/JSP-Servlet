package test;
 
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 
import domain.MessageDTO;
 
public class ReflectionTest {
 
    public static void main(String[] args)
        throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
 
        MessageDTO messageDTO = new MessageDTO();
       
        // 1) 필드
        // "writer"라는 이름의 멤버 필드에 "java"라는 값을 대입
        Field field = messageDTO.getClass().getDeclaredField("writer");
        field.setAccessible(true); // 필드 접근 권한 획득
        field.set(messageDTO,  "java");
        System.out.println("writer : " +messageDTO.getWriter());
       
        ////////////////////////////////////////////////
       
        // 2) 메서드
        // "writer"라는 이름의 멤버 필드에 해당되는 setWriter 메서드를 통해서"java"라는 값을 대입
        Method method = messageDTO.getClass().getDeclaredMethod("setWriter", String.class);
        method.invoke(messageDTO, "python");
       
       
        // messageDTO.setWriter("python");
       
        System.out.println("writer : " +messageDTO.getWriter());
    }
 
}
