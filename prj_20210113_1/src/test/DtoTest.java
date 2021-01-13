package test;

import java.util.HashMap;
import java.util.Map;

import domain.MessageDTO;

public class DtoTest {

   public static void main(String[] args) throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {

      System.out.println("DTO test");
      
      Map<String, String[]> map = new HashMap<>();
      String temp[] = new String[3];
      temp[0] = "자바맨";
      map.put("writer", temp);
      
      temp = new String[1];
      temp[0] = "123456789";
      map.put("password", temp);
      
      temp = new String[1];
      temp[0] = "자바";
      map.put("message", temp);
      
      temp = new String[3];
      temp[0] = "스포츠";
      temp[1] = "문화";
      temp[2] = "사회";
      map.put("kind", temp);
      
      temp = new String[1];
      temp[0] = "010";
      map.put("phone1", temp);
      
      temp = new String[1];
      temp[0] = "1234";
      map.put("phone2", temp);
      
      temp = new String[1];
      temp[0] = "5678";
      map.put("phone3", temp);
      
      map.forEach((x,y)->System.out.println(x+"="+y[0]));
      System.out.println("----------------------");
      
      MessageDTO dto = new MessageDTO(map);
      System.out.println("dto : " + dto);
   } 

} 