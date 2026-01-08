package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

//    public static String captureScreenshot(WebDriver driver, String scenarioName) {
//        System.out.println("Screenshot method called. Driver = " + driver);
//
//
//        if (driver == null) {
//            System.out.println("Driver is NULL. Screenshot not captured.");
//            return null;
//        }
//
//        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots";
//
//        String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
//
//        System.out.println("About to take screenshot");
//
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        File destFile = new File(screenshotDir + "/" + fileName);
//        destFile.getParentFile().mkdirs();
//
//        File testDir = new File(System.getProperty("user.dir") + "/reports/screenshots");
//        testDir.mkdirs();
//        System.out.println("Test screenshots dir exists = " + testDir.exists());
//
//
//        try {
//            Files.copy(srcFile.toPath(), destFile.toPath());
//            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 👇 RETURN ABSOLUTE PATH
//        return destFile.getAbsolutePath();
//    }
public static String captureScreenshot(WebDriver driver, String scenarioName) {

    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots";

    String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_")
            + "_" + timestamp + ".png";

    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    File destFile = new File(screenshotDir + "/" + fileName);
    destFile.getParentFile().mkdirs();

    try {
        Files.copy(srcFile.toPath(), destFile.toPath());
    } catch (IOException e) {
        e.printStackTrace();
    }

    // ✅ RETURN RELATIVE PATH (from reports folder)
    return "screenshots/" + fileName;
}

}
