import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class segmentAdmin {
        @Test
        public void testName () {
            String email = "rakhat.m@rahmetapp.kz", password = "qqqqqqqq";
            step("Открываем главную страницу", () -> {
                open("https://cp.choco.kz/");
            });
            step("авторизация через email", () -> {
                //кликаем на "войти через почту"
                $x("//*[@id=\"app\"]/div/div/div/div/div[3]/div/button[2]").click();
                sleep(2000);
                //вводим данные почты и авторизуемся
                $x("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/input").setValue(email);
                sleep(1500);
                $x("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div/input").setValue(password);
                $x("/html/body/div[1]/div/div/div/div/div[3]/div/button[1]").click();
                sleep(10000);
            });
            step("переходим в раздел сегментов/управление", () -> {
                $x("/html/body/div/nav/div/ul/li[17]/a").click();
                $x("/html/body/div/nav/div/ul/li[17]/ul/li[1]/a/span").click();
            });
            step("сегменты подгрузились", () -> {
                $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[2]").shouldBe(visible);
                sleep(1500);
            });
            step("кликаем на кнопку /создать сегмент/ ", () -> {
                $x("/html/body/div/div/div[2]/div[1]/div[2]/div/a").click();
                sleep(1500);
            });
            step("проверяем что окошко /новый сегмент/ виден", () -> {
                $x("/html/body/div[1]/div/div[2]/div[1]/div[3]/div/div/div[1]").shouldBe(visible);
            });
            step("вводим название нового сегмента и сохраняем", () -> {
                $x("/html/body/div[1]/div/div[2]/div[1]/div[3]/div/div/div[2]/div/input").setValue("new_autotest_segment");
                $x("/html/body/div[1]/div/div[2]/div[1]/div[3]/div/div/div[3]/button[1]").click();
                sleep(2000);
            });
            step("кликаем на /сегменты/ в подробке сегмента", () -> {
                $x("/html/body/div/div/div[2]/div[1]/div/ol/li[2]/a").click();
            });
            step("кликаем на кнопку /фильтр/ на главном экране", () -> {
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/button").click();
            });
            step("проверяем подгрузилось ли тело /фильтра/", () -> {
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div").shouldBe(visible);
            });
            step("ищем сегмент по названию /new_autotest_segment/", () -> {
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div[2]/input").setValue("new_autotest_segment");
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[3]/div/button[1]").click();
                sleep(1500);
            });
            step("проверяем результат поиска", () -> {
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]").shouldBe(visible);
            });
            step("очищаем параметры фильтра", () -> {
                //clicl to "clear" button
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[3]/div/button[2]").click();
                //click to "apply" button
                $x("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[3]/div/button[1]").click();
                sleep(1500);
            });
            step("обновляем страницу", () -> {
                refresh();
            });
        }
    }
