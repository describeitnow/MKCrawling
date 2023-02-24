package MKCrawling;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MKCrawling {
	
	public static void main(String[] args) {
		WebDriver driver = null;
		WebDriver driver2 = null;
		List<WebElement> webElements = null;
		String url = "";	
		
		System.setProperty("webdriver.chrome.driver", 
				".\\src\\MKCrawling\\chromedriver.exe");
		
		// WebDriver 객체 생성
		driver = new ChromeDriver();
		// 로드 웹페이지에서 특정 요소를 찾을 때까지 기다리는 시간 설정
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// 페이지로드가 완료 될 때까지 기다리는 시간 설정
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// 브라우저 창 최대화
		driver.manage().window().maximize();
		// 웹 자동화 작업을 할 접속 사이트 명시
		driver.get("https://www.mk.co.kr/");
		//상단 메뉴바의 링크 추출
		webElements = driver.findElements(By.cssSelector(".nav_link"));

		for(WebElement webElement : webElements) {
			String str = webElement.getText();
			if (str.equals("증권")) {
				//증권 링크 추출
				url = webElement.getAttribute("href");
			}
		}
		
		// WebDriver 객체 생성
		driver2 = new ChromeDriver();
		// 로드 웹페이지에서 특정 요소를 찾을 때까지 기다리는 시간 설정
		driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// 페이지로드가 완료 될 때까지 기다리는 시간 설정
		driver2.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// 브라우저 창 최대화
		driver2.manage().window().maximize();
		// 웹 자동화 작업을 할 접속 사이트 명시
		driver2.get(url);
		webElements = null;
		//기사 제목 추출
		webElements = driver2.findElements(By.className("news_ttl"));
		
		
		System.out.println(webElements.size());
		
		for(WebElement webElement : webElements) {
			System.out.println("기사제목 : " + webElement.getText());
		}
	}
}