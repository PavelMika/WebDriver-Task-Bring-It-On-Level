package tests;
import org.testng.annotations.Test;

public class MainPageTests extends BaseTest{

    @Test
    public void checkPageTitleAndPasteNameMath(){
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        mainPage.openPage();
        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting("Bash");
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkPasteNameMath(textForPasteName);
    }

    @Test
    public void checkSyntaxHighlightedForBash() {
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        String textForSyntaxHighlighting = "Bash";
        mainPage.openPage();
        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting(textForSyntaxHighlighting);
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkTextOnSyntaxButton(textForSyntaxHighlighting);
    }

    @Test
    public void checkRavPasteDataTextMatchNewPasteText() {
        String textForPasteField = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String textForPasteName = "how to gain dominance among developers";
        String textForSyntaxHighlighting = "Bash";
        mainPage.openPage();
        mainPage.writeTextInToNewPasteField(textForPasteField);
        mainPage.selectSyntaxHighlighting(textForSyntaxHighlighting);
        mainPage.selectPasteExpiration();
        mainPage.writeTextInToPasteNameField(textForPasteName);
        mainPage.pressCreateNewPasteButton();
        mainPage.checkTextInRawPasteDataField(textForPasteField);
    }
}

