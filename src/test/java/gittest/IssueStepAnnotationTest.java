package gittest;

import org.junit.jupiter.api.Test;

public class IssueStepAnnotationTest {

    private static final String REPOSITORY = "dariaAbramkina/qa_quru_homework7";

    @Test
    public void testAnnotatedSteps() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepository(REPOSITORY);
        steps.checkIssueTabIsDisplayed();
    }
}
