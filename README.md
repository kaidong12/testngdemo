
--------------------------------------------------------------------
# run

```java
cd D:\backup\git\TestngDemo
cmd

--------------------------------------------------------------------
mvn clean test allure:serve

--------------------------------------------------------------------
mvn clean test site

mvn allure:serve
mvn allure:report

```

--------------------------------------------------------------------

# setup
## download
```java
https://maven.apache.org/download.cgi

https://dlcdn.apache.org/maven/maven-3/3.9.11/binaries/apache-maven-3.9.11-bin.zip
--------------------------------------------------------------------
C:\tools\apache-maven-3.9.11

```

--------------------------------------------------------------------
## config
### mirror
```java
C:\tools\apache-maven-3.9.11\conf\settings.xml
--------------------------------------------------------------------
    <mirror>
        <id>aliyun</id>
        <name>Aliyun Maven Mirror</name>
        <url>https://maven.aliyun.com/repository/public</url>
        <mirrorOf>central</mirrorOf>
    </mirror>

```

--------------------------------------------------------------------
# pom
## cucumber
### runner
```java
src/test/java/runner/TestRunner.java
--------------------------------------------------------------------
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import utils.WebDriverManager;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "steps",
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}
```

--------------------------------------------------------------------
### pom-->dependency
```java
<cucumber.version>7.15.0</cucumber.version>
<testng.version>7.8.0</testng.version>

--------------------------------------------------------------------
<!-- Cucumber -->  
<dependency>  
  <groupId>io.cucumber</groupId>  
  <artifactId>cucumber-java</artifactId>  
  <version>${cucumber.version}</version>  
</dependency>  
<!-- TestNG -->  
<dependency>  
  <groupId>org.testng</groupId>  
  <artifactId>testng</artifactId>  
  <version>${testng.version}</version>  
</dependency>  
<!-- cucumber-testng -->  
<dependency>  
  <groupId>io.cucumber</groupId>  
  <artifactId>cucumber-testng</artifactId>  
  <version>${cucumber.version}</version>  
</dependency>

```
--------------------------------------------------------------------
### pom-->plugins
```java
 <plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>3.1.2</version>
	<configuration>
	  <suiteXmlFiles>
		<suiteXmlFile>testng.xml</suiteXmlFile>
	  </suiteXmlFiles>
</plugin>

```
--------------------------------------------------------------------

## allure
### allure.properties
```java
src/test/resources/allure.properties
--------------------------------------------------------------------
allure.results.directory=target/allure-results
allure.link.issue.pattern=https://example.com/issue/{}
allure.link.tms.pattern=https://example.com/tms/{}

```

--------------------------------------------------------------------
### testng.xml-->listener
```java
    <listeners>
        <listener class-name="io.qameta.allure.testng.AllureTestNg"/>
    </listeners>
```

--------------------------------------------------------------------
### pom-->dependency
```java
<allure.version>2.24.0</allure.version>  
<aspectj.version>1.9.19</aspectj.version>

<!-- Allure TestNG适配器 -->  
<dependency>  
  <groupId>io.qameta.allure</groupId>  
  <artifactId>allure-testng</artifactId>  
  <version>${allure.version}</version>  
  <scope>test</scope>  
</dependency>  
  
<!-- Allure Cucumber 适配器 -->  
<dependency>  
  <groupId>io.qameta.allure</groupId>  
  <artifactId>allure-cucumber7-jvm</artifactId>  
  <version>2.24.0</version>  
  <scope>test</scope>  
</dependency>  
  
<!-- AspectJ 织入 -->  
<dependency>  
  <groupId>org.aspectj</groupId>  
  <artifactId>aspectjweaver</artifactId>  
  <version>${aspectj.version}</version>  
  <scope>test</scope>  
</dependency>  
  
<!-- Allure命令行工具（可选，用于生成报告） -->  
<dependency>  
  <groupId>io.qameta.allure</groupId>  
  <artifactId>allure-commandline</artifactId>  
  <version>${allure.version}</version>  
  <scope>test</scope>  
</dependency>

```

--------------------------------------------------------------------
### pom-->plugins
```java
<plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
          <argLine>
            -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
          </argLine>
          <properties>
            <property>
              <name>listener</name>
              <value>io.qameta.allure.testng.AllureTestNg</value>
            </property>
          </properties>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>${aspectj.version}</version>
          </dependency>
        </dependencies>
      </plugin>

      <!-- Allure Maven插件 -->
      <plugin>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-maven</artifactId>
        <version>2.12.0</version>
        <configuration>
          <reportVersion>2.24.0</reportVersion>
          <resultsDirectory>${project.build.directory}/allure-results</resultsDirectory>
          <reportDirectory>${project.build.directory}/allure-report</reportDirectory>
        </configuration>
      </plugin>

    </plugins>
```
--------------------------------------------------------------------
