# Useful Links
- [Swagger Petstore](https://petstore.swagger.io/#/): Documentation for Petstore API.
- [JsonPath Finder](https://jsonpathfinder.com/): Tool for navigating and querying JSON structures.
- [RandomStringUtils - Apache Commons Lang](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomStringUtils.html): Apache Commons Lang documentation for generating random strings.

# SoapUI Properties

## Reference Syntax
- ${#Project#property_name}
- ${#TestSuite#property_name}
- ${#TestCase#property_name}

## Getting Property to Current Context
```groovy
context.expand('${#TestCase#property_name}')
```

## set property
```groovy
testRunner.testCase.testSuite.project.setPropertyValue("preoperty_name", "property_value")
testRunner.testCase.testSuite.setPropertyValue("preoperty_name", "property_value")
testRunner.testCase.setPropertyValue("preoperty_name", "property_value")
```
# groovy script test step

```groovy
import org.apache.commons.lang.RandomStringUtils

testRunner.testCase.setPropertyValue("preoperty_name", "property_value")
```

# Groovy script assertion
```groovy
def response = messageExchange.response.responseContent
def json = new groovy.json.JsonSlurper().parseText(response)

assert json.someKey == "expectedValue"
```

# useful metods
- toString(): Convert an object to its string representation.
- isEmpty(): Check if a string or collection is empty.
- size(): Get the size of a collection.
