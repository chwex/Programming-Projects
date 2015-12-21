package scrap;
import java.util.*;
public class Scrap {
    public static void main(String[] args) {
String str = "oddly";
    if(str.length() >= 2){
    if("ly".equals(str.substring(str.length()-2,str.length())) ){
        System.out.println(true);
  }
  else{
  System.out.println(false);
  }}
  else{
  System.out.println(false);
  }
    }
}