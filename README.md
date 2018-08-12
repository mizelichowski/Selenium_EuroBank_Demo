# EuroBank Demo Selenium Test Suite

A test suite to verify some functionalities of EuroBank Demo service.

[EuroBank demo service](http://demo.eurobank.pl/)

***

## Notes:

- WebDriver singleton prevents from executing parallel tests.
This is intended - the suite test flow has some tests depend on the
others,
- Reports generated exclusively with ExtentReports.

## Made with:

- Chrome WebDriver 3.14.0,
- Java 8,
- Maven 4.0.0,
- Selenium 3.14.0,
- TestNG 6.14.3,
- ExtentReports 3.1.5.
