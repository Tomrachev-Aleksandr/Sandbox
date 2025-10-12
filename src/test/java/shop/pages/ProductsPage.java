package shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);
    final By title = By.xpath("//span[@class='title']");
    final By title2 = By.xpath("//*[text ()='Products']");
    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // 1. проверка: текст соотвутвует ожидаемому результату
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    // 2. проверка: что этот элемент вообще существует
    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
     }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));//упрощенный вариант предыдущей сроки
        driver.findElement(addToCart).click();
    }
}