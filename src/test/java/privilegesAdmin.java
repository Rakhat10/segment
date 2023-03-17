import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class privilegesAdmin {
    @Test
    public void privilegesTest() {
        String email = "rakhat.m@rahmetapp.kz", password= "qqqqqqqq";
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
        step("переход в раздел привилегии (список привилегии)", () -> {
            $x("//*[@id=\"side-menu\"]/li[18]/a").click();
            $x("//*[@id=\"side-menu\"]/li[18]/ul/li[1]/a/span").click();
            sleep(2500);
        });
        step("поиск по названию привилегии через фильтр", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[1]/button").click();
            $x("//*[@id=\"pref-search\"]").setValue("тест");
            $x("//*[@id=\"filter-panel\"]/div/div/div[4]/div/button[1]").click();
            sleep(10000);
        });
        step("проверяем результат поиска", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[2]").shouldBe(Condition.visible);
        });
        step("переходим на вторую по счету привилегию (в подробку) и проверяем подгрузились ли данные", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[11]/a").click();
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div[2]/div[1]/div[1]").shouldBe(Condition.visible);
        });
        step("в подробке привилегии переключаемся между разделами (переходим в раздел /дополнительные параметры/", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div[1]/div[2]/div[2]/h2").click();
            sleep(1500);
        });
        step("возвращаемся в список привилегии из подробки привилегии", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[1]/div/ol/li[2]/a").click();
            sleep(3000);
        });
        step("переходим на следующую страницу с привилегиями", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[2]/div[2]/ul/li[7]/a").click();
            sleep(4000);
        });
        step("создаем привилегию (кликаем на создать привилегии)", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[1]/div[2]/div/a").click();
        });
        step("создаем привилегию (выбираем проект)", () -> {
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div/div[1]/div[1]/select").click();
            $x("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div/div/div[1]/div[1]/select/option[5]").click();
            sleep(3000);
        });
    }
    @BeforeAll
    static void beforeAll() { Configuration.browserSize = "1280x800"; }
}
