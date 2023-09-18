import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Hover {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void hoverTest (){
        //открыть главную страницу GitHub
        open("");

        //выбрать меню Solutions -> Enterprize
        $x("//button[contains(text(),'Solutions')]").hover();
        $x("//ul[@class='list-style-none f5']/..//a[@href='/enterprise'][1]").click();

        //убедиться, что загрузилась страница "Build like the best"
        $x("//h1[@class='h1-mktg mb-3 color-fg-default']").shouldHave(text("Build like the best"));
    }
}
