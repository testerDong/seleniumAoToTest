package dong.com.spEnterprise.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** 

* @Description: 
* @param:
* @return:
* @author: zhangdongdong

* @Date: 2019年9月5日 上午11:43:11
 

*/
public class OpenMerchat extends BasePage{

	public OpenMerchat(WebDriver driver) {
		super(driver);
	}
    //*****页面元素定位
	//顶部菜单--商户菜单
	@FindBy(xpath="//div[@class='nav']/ul/li[2]/a")
	private WebElement merTextlink;
	//左边菜单--商户管理菜单
	@FindBy(id="treeDemo_1_span")
	private WebElement merchant_mg;
	//左边菜单--新商户进件菜单
	@FindBy(id="treeDemo_8_span")
	private WebElement merchant_jj;
	//商户基本信息页面
	//商户类别--标准类
	@FindBy(id="subMerType0")
	private WebElement subMerType;
	//商户性质--企业商户
	@FindBy(id="subMerProperty0")
	private WebElement subMerProperty;
	//***业务逻辑
	public void addMerchantInfo() {
		my_switch_frame("frmTop");
		my_click(merTextlink);
		my_clsw_frame("treeShow");
		my_click(merchant_mg);
		my_click(merchant_jj);
		my_clsw_frame("mainShow");
		my_click(subMerType);
		my_click(subMerProperty);
	}
	
	
	
	
	
}
