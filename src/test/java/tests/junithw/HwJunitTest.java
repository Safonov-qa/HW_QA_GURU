package tests.junithw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HwJunitTest {

    @BeforeEach
    void setup() {
        open("http://www.sberbank.ru/ru/person");
        $("a.kitt-header-search").click();
    }



    @DisplayName("В поисковой выдаче Сбербанка должен осуществится поиск по запросу 'Вклады' ")
    //@Tag("BLOCKER")
    @Test
    void searchResultDeposit() {
        $(".kitt-header-search__search").setValue("Вклады").pressEnter();
        $(".search-result").shouldHave(text("Вклады с высоким процентом для физических лиц... — СберБанк"));


      sleep(5000);



    }
}






//    @ParameterizedTest
//    @ValueSource(strings = { "Вклады", "Кредиты","Инвестиции"})
//    void
//
//
//
//    @DisplayName("Название тест кейса")
//
//
//
//    @Blocker
//
//
//}

