package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", false);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);
        System.out.println("Appium start");

        //awal aplikasi
        delay(3);
        MobileElement allowBtn = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        allowBtn.click();
        delay(1);
        MobileElement tutupBtn = (MobileElement) driver.findElementById("android:id/button2");
        tutupBtn.click();
        delay(1);
        MobileElement addBtn = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        addBtn.click();
        delay(1);

        //Pemasukkan Case
        MobileElement pemasukanBtn = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        pemasukanBtn.click();
        delay(1);
        MobileElement jumlahInput = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement ketInput = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement saveBtn = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        jumlahInput.sendKeys("5000000");
        ketInput.sendKeys("Gaji Bulan Agustus");
        saveBtn.click();
        delay(3);
        MobileElement pemasukan = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]");
        String txtPemasukkan = pemasukan.getText();
        if (txtPemasukkan.equals("5.000.000")) {
            System.out.println("Pemasukkan Case Done");
        } else {
            System.out.println("error");
        }

        //Pengeluaran Case
        delay(1);
        addBtn.click();
        delay(1);
        MobileElement kategoriList = (MobileElement) driver.findElementById("com.chad.financialrecord:id/spCategory");
        kategoriList.click();
        delay(1);
        MobileElement pajakList = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView");
        pajakList.click();
        delay(1);
        MobileElement jumlahPengInput = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        MobileElement ketPengInput = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        MobileElement savePengBtn = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        jumlahPengInput.sendKeys("125000");
        ketPengInput.sendKeys("pajak rumah");
        savePengBtn.click();
        delay(1);
        MobileElement pengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvExpense");
        String pengeluaranTxt = pengeluaran.getText();
        if (pengeluaranTxt.equals("125.000")) {
            System.out.println("Pengeluaran Case Done");
        } else {
            System.out.println("error");
        }

        //Saldo Case
        MobileElement saldo = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvBalance");
        String saldoTxt = saldo.getText();
        if (saldoTxt.equals("4.875.000")) {
            System.out.println("Saldo Case Done");
        } else {
            System.out.println("error");
        }

        System.out.println("Finish");


    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}