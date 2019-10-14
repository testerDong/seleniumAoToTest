package dong.com.spEnterprise.untils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZip {
public static String fileDateStemp;
/**
 * 
 *@description 递归压缩一个文件下的所有文件
 *@param reportPath 要压缩的报告文件路径
 *2019年10月14日下午2:56:04
 */
	public static void createZips(String reportPath) {

//		String entry = "E:\\workspace\\testngSelenium\\test-output";// 需要压缩的文件目录
		File file = new File(reportPath);
		//压缩文件的名字
		ZipOutputStream zipOutput;
		fileDateStemp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + ".zip" ;
		try {
			zipOutput = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(file.getAbsolutePath()+ "-" + fileDateStemp)));
			String base = file.getName();
			compressZip(zipOutput, file, base);
			zipOutput.closeEntry();
			zipOutput.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * 因为子文件夹中可能还有文件夹，所以进行递归
	 *
	 */
	private static void compressZip(ZipOutputStream zipOutput, File file, String base) throws IOException {

		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();// 列出所有的文件

			for (File fi : listFiles) {
				if (fi.isDirectory()) {
					compressZip(zipOutput, fi, base + "/" + fi.getName());
				} else {
					zip(zipOutput, fi, base);
				}
			}
		} else {
			zip(zipOutput, file, base);
		}
	}

	/** 
	 * 压缩的具体操作
	 *
	 */
	public static void zip(ZipOutputStream zipOutput, File file, String base)
			throws IOException, FileNotFoundException {
		ZipEntry zEntry = new ZipEntry(base + File.separator + file.getName());
//		System.out.println("需要压缩的文件名字："+base + File.separator + file.getName());
		zipOutput.putNextEntry(zEntry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

		byte[] buffer = new byte[1024];
		int read = 0;
		while ((read = bis.read(buffer)) != -1) {
			zipOutput.write(buffer, 0, read);
		}
		bis.close();
	}

}