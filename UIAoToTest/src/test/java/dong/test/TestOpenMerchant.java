package dong.test;
/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年9月5日 下午2:01:28
 

*/

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dong.com.spEnterprise.po.OpenMerchat;

public class TestOpenMerchant {
	
	@Test
	public void TestMerchant() {
		//使用静态变量：TestLoginSpEnterprise.driver 保证driver在整个运行期间的唯一性
		OpenMerchat om =PageFactory.initElements(TestLoginSpEnterprise.driver,OpenMerchat.class);
		om.addMerchantInfo();
		
	}

}
