import com.allurejava.util.BaseTestngInit;
import org.testng.annotations.Test;

public class EnterCases {
    BaseTestngInit baseTestngInit = new BaseTestngInit();

    /**
     * 驱动存放路径(小程序的webdriver) target/classes/testng.xml
     */
    private String xmlPath=this.getClass().getClassLoader().getResource("testng.xml").getPath();

    @Test
    public void runCase(){
        baseTestngInit.baseTestngInitXml(xmlPath);
    }
}
