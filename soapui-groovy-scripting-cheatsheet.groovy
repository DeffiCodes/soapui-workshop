/** SoapUI Groovy Scripting Cheat Sheet
* Other usefull resources:
* https://automatenow.io/soapui-groovy-scripting/
* https://www.soapui.org/docs/scripting-and-properties/tips-tricks/
* https://www.soapui.org/docs/scripting-and-properties/scripting-and-the-script-library/
**/

// 1. Accessing Properties:
// Test Case Level
def testCaseProperty = context.testCase.getPropertyValue("propertyName")

// Test Suite Level
def testSuiteProperty = context.testCase.testSuite.getPropertyValue("propertyName")

// 2. Setting Properties:
// Test Case Level
context.testCase.setPropertyValue("propertyName", "propertyValue")

// Test Suite Level
context.testCase.testSuite.setPropertyValue("propertyName", "propertyValue")

// 3. Logging:
// Info Level
log.info("Your message here")

// Error Level
log.error("Your error message here")

// 4. Accessing Request and Response:
// Request Content
def requestContent = context.expand('${Request#request}')

// Response Content
def responseContent = context.expand('${Response#response}')

// 5. Assertions:
// Check Property Content
assert context.expand('${#TestCase#propertyName}') == 'expectedValue'

// Check Status Code
assert messageExchange.responseStatusCode == 200

// Check Response Contains a Substring
assert responseContent.contains("expectedSubstring")

// Check Not Null
assert elementValue != null

// Check Numeric Values
assert elementValue.isNumber()

// Check Size of a List
assert jsonResponse.items.size() == expectedSize

// 6. Random Data Generation:
import org.apache.commons.lang.RandomStringUtils
def randomString = RandomStringUtils.randomAlphabetic(10)

// 7. Working with JSON:
// Parse JSON Response
def jsonResponse = new groovy.json.JsonSlurper().parseText(context.response.getResponseContent())

// Access JSON Elements
def elementValue = jsonResponse.elementName

// 8. Conditional Statements:
switch (condition) {
    case 1:
        println("One")
        break
    case 2:
        println("Two")
        break
    case 3:
        println("Three")
        break
    default:
        println("Other")
}

// 9. Looping Statements:
// Avoid infinite loop by specifying the range
for (item in 1..10) {
    // Your code here
}

// 10. Date Formatting:
def currentDate = new Date().format("yyyy-MM-dd")

// 11. File Operations:
// Read File
def fileContent = new File("path/to/file.txt").text

// Write to File
new File("path/to/file.txt").text = "content"

// 12. Working with XML:
// Parse XML Response
def xmlResponse = new XmlSlurper().parseText(context.response.getResponseContent())

// Access XML Elements
def elementValue = xmlResponse.elementName.text()

// 13. Data-Driven Testing with DataSource:
def dataSource = ["A", "B", "C"]

for (data in dataSource) {
    // Perform actions with data
    log.info("Sending request with status: $data")

    // Example: Set data in a property
    testRunner.testCase.setPropertyValue("status", data)

    // Run your request or do other actions
    testRunner.testCase.testSteps['YOUR_STEP_NAME'].run(testRunner, context)
}
