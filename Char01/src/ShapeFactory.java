import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ShapeFactory {

  private static Properties shapes=new Properties();

  static{
    try{
      InputStream in=ShapeFactory.class.getResourceAsStream("panel.properties");
      shapes.load(in); //把配置信息加载到shapes对象中
    }catch(IOException e){throw new RuntimeException(e);}
  }

  public static Shape getShape(int type){
    try{
      //获得与形状类型匹配的形状类名
      String className=(String)shapes.get(String.valueOf(type));
      //运用Java反射机制构造形状对象
      return (Shape)Class.forName(className).newInstance();
    }catch(Exception e){return null;}
  }

}