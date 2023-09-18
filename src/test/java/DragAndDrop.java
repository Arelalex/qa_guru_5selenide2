import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080";
    }

    //не работает с actions()
    @Test
    void dragAndDropTestError() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("");

        //Перенесите прямоугольник А на место В
        int x = $("#column-b").getLocation().getX();
        int y = $("#column-b").getLocation().getY();
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(x, y).release().perform();

        //Проверьте, что прямоугольники действительно поменялись
    }

    //сработало
    @Test
    void dragAndDropTest() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("");

        //Перенесите прямоугольник А на место В
        int x = $("#column-b").getLocation().getX();
        int y = $("#column-b").getLocation().getY();
        $("#column-a").dragAndDrop(to($("#column-b")));

        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
    }
}
