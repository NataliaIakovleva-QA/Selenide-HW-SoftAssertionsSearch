package github;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsSearchTest {

  @Test
  void shouldFindJUnit5CodeExampleTest() {
    // открыть страницу репозитория селенида
    open("https://github.com/selenide/selenide");

    // найти и провалится в Wiki проекта
    $("#wiki-tab").click();

    // проверить, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-body").shouldHave(text("Soft assertions"));

    // открыть ее
    $("a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
    
    // проверить, что внутри есть пример кода для JUnit5
    $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}"));
  }
}
