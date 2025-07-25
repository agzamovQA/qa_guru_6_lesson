package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private final SelenideElement
                                tableResponse = $(".table-responsive"),
                                tableContext = $(".modal-content");

    public void checkVisibleTable (String key, String value) {
        tableContext.shouldHave(text("Thanks for submitting the form"));
        tableResponse.$(byText(key)).parent().shouldHave(text(value));

    }

    public void checkUnVisibleTable () {
        tableResponse.shouldNotBe(visible);

    }
}
