import com.jia.bean.Person;
import com.jia.bean.UserInfo;
import com.jia.bean2.bean1;
import com.jia.bean3.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class BeanTest {

    private AnnotationConfigApplicationContext context;

    private ApplicationContext applicationContext = null;

    @Before
    public void testInitial() {
        //读取类路径下的文件
     /*applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");*/
        applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");


        //读取创建容器
       /* context=new AnnotationConfigApplicationContext(SpringConfig.class);*/
    }

    @Test
    public void test1() {

        //返回的是 Object 类型
        Person person = (Person) applicationContext.getBean("p");
        person.SayHello();
        System.out.println(person.getPname());
    }

    @Test
    public void test2() {
        UserInfo userInfo = (UserInfo) applicationContext.getBean("userInfo");
        System.out.println(userInfo);

    }

    @Test
    public void test3() {
        bean1 bean = (bean1) applicationContext.getBean("bean1");
        System.out.println("strValue=" + bean.getStrValue());
        System.out.println("intValue=" + bean.getIntValue());
        System.out.println("arrayValue=" + Arrays.toString(bean.getArrayValue()));
        System.out.println("setValue=" + bean.getSetValue());
        System.out.println("mapvalue=" + bean.getMapValue());
        System.out.println("listValue=" + bean.getListValue());
System.out.println("dataValue="+bean.getDateValue());

    }

    @Test
    public void test4()
    {
        Person person=(Person) context.getBean("person");
        person.SayHello();
    }
}
