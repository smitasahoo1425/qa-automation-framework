import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class PostAPITest {
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeSuite
    public void setupExtentReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/API_Test_Report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    // Utility method to read JSON file
    public static String readJsonFile(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @Test
    public void testCreateUser() {
        test = extent.createTest("POST API - Create User");

        try {
            // Set Base URI
            RestAssured.baseURI = "https://fakestoreapi.com";

            // Read JSON Payload from File
            String requestBody = readJsonFile("src/test/resources/userData.json");

            test.info("Request Payload: " + requestBody);

            // Send POST Request
            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/users")
                    .then()
                    .extract()
                    .response();

            // Log Response
            test.info("Response Status Code: " + response.getStatusCode());
            test.info("Response Body: " + response.getBody().asString());

            // Validate Response
            Assert.assertEquals(response.getStatusCode(), 200);
            test.pass("Test Passed!");

        } catch (Exception e) {
            test.fail("Test Failed: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        extent.flush(); // Generate Extent Report
    }
}
