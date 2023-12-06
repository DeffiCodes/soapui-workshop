# Useful Links
- [Swagger Petstore](https://petstore.swagger.io/#/)
- [JsonPath Finder](https://jsonpathfinder.com/)
- [RandomStringUtils - Apache Commons Lang](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomStringUtils.html)

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

assert ...
```
