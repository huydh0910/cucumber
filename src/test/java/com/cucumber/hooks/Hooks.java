package com.cucumber.hooks;

import com.cucumber.driver.DriverManager;
import com.cucumber.driver.ScenarioManager;
import com.cucumber.helpers.CaptureHelpers;
import com.cucumber.helpers.PropertiesHelpers;
import com.cucumber.helpers.SystemHelpers;
import com.cucumber.keywords.WebUI;
import com.cucumber.listeners.TestListener;
import com.cucumber.report.AllureManager;
import com.cucumber.utils.EmailSendUtils;
import com.cucumber.utils.LogUtils;
import com.cucumber.utils.ReportUtils;
import com.cucumber.utils.ZipUtils;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import static com.cucumber.constants.FrameworkConstants.*;

public class Hooks {

    public static int count_totalTCs = 0;
    public static int count_passedTCs = 0;
    public static int count_skippedTCs = 0;
    public static int count_failedTCs = 0;

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void before_all() {
        LogUtils.info("================ BEFORE ALL ================");
        PropertiesHelpers.loadAllFiles();
        AllureManager.setAllureEnvironmentInformation();

        try {
            if (DELETE_TEMP_FOLDER.equals(YES)) {
                FileUtils.deleteDirectory(new File("target/allure-results"));
                LogUtils.info("Deleted directory target/allure-results");
                FileUtils.deleteDirectory(new File("ExportData"));
                LogUtils.info("Deleted directory ExportData");
            }
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void after_all() {
        LogUtils.info("================ AFTER ALL ================");
        ZipUtils.zipReportFolder();
        ReportUtils.openReports(SystemHelpers.getCurrentDir() + PropertiesHelpers.getValue("extent.reporter.spark.out"));
        EmailSendUtils.sendEmail(count_totalTCs
                , count_passedTCs
                , count_failedTCs
                , count_skippedTCs);

        LogUtils.info("count_totalTCs: " + count_totalTCs);
        LogUtils.info("count_passedTCs: " + count_passedTCs);
        LogUtils.info("count_failedTCs: " + count_failedTCs);
        LogUtils.info("count_skippedTCs: " + count_skippedTCs);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        LogUtils.info("Running Scenario Name: " + scenario.getName());
        count_totalTCs = count_totalTCs + 1;
        ScenarioManager.setScenario(scenario);

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.startRecord(scenario.getName());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (Status.PASSED.equals(scenario.getStatus())) {
            count_passedTCs = count_passedTCs + 1;
        }
        if (Status.FAILED.equals(scenario.getStatus())) {
            count_failedTCs = count_failedTCs + 1;
        }
        if (Status.SKIPPED.equals(scenario.getStatus())) {
            count_skippedTCs = count_skippedTCs + 1;
        }

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            WebUI.sleep(1);
            CaptureHelpers.stopRecord();
        }

        //Quit driver in thread local
        DriverManager.quit();
        WebUI.stopSoftAssertAll();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.getStatus().equals(Status.PASSED) && SCREENSHOT_PASSED_STEPS.equals(YES)) {
            WebUI.waitForPageLoaded();
            CaptureHelpers.takeScreenshotScenario(scenario,"Screenshot passed step");
        }
        if (scenario.getStatus().equals(Status.FAILED) && SCREENSHOT_FAILED_STEPS.equals(YES)) {
            WebUI.waitForPageLoaded();
            CaptureHelpers.takeScreenshotScenario(scenario,"Screenshot failed step");
        }
        if (SCREENSHOT_ALL_STEPS.equals(YES)) {
            WebUI.waitForPageLoaded();
            CaptureHelpers.takeScreenshotScenario(scenario,"Screenshot step");
        }
    }

}
