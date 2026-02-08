package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDowload extends TestBase {

    @Test
    void dowloadFile(){
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        File dowloaded =
                $(".prc-ButtonGroup-ButtonGroup-vFUrY [href='https://github.com/junit-team/junit-framework/raw/refs/heads/main/README.md']")
                        .download();
        System.out.println();


    }
}
