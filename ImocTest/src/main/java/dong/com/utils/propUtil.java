package dong.com.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @Description:该类主要是用来读取properties文件，然后根据key值 获取value
 * @param:
 * @return:
 * @author: zhangdongdong
 * 
 * @Date: 2019年11月7日 上午11:00:17
 * 
 * 
 */
public class propUtil {
	private Properties properties;

	public propUtil(String filePath) {
		properties = redProperty(filePath);

	}

	/**
	 * 
	 * @description 该方法主要是根据上送的properties文件位置，加载文件
	 * @param filePath properties 文件的位置
	 * @return 2019年11月7日下午2:04:18
	 */
	public Properties redProperty(String filePath) {
		properties = new Properties();
		try {
			FileInputStream f = new FileInputStream(filePath);
			BufferedInputStream b = new BufferedInputStream(f);
			properties.load(b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return properties;

	}

	/**
	 * 
	 * @description 该方法主要是通过 properties对象读取文件中的键值对
	 * @param key 就是properties文件中的键值
	 * @return 2019年11月7日下午2:08:46
	 */
	public String getProp(String key) {

		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		} else {

			return "";
		}

	}
}
