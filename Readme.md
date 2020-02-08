## Setup

* Clone the repo
* Install dependencies `mvn compile`
* Update `*.conf.json` files inside the `src/test/resources/conf` directory with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)

## Running your com.projectname.tests

- To run a single test, run `mvn test -P single`
- To run local com.projectname.tests, run `mvn test -P local`
- To run parallel com.projectname.tests, run `mvn test -P parallel`
- To run the test suite, run `mvn test -P suite`