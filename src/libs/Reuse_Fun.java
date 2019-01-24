package libs;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reuse_Fun {

	public static void screenShot(WebDriver driver, String filename) throws Exception {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/ZenQ/Screenshots" +filename+ ".png"));
		
	}

}
