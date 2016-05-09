# Spring Customer Products Application

By Amadeo Ascó, April 2016.

This is an implementation of a simple web app using Java and Spring that allows 
customers to select products which are available to them, based on their home 
location.


Licensed under the Apache License, Version 2.0, see more in the [license](license.txt) file.


## Running customerform locally
>cd spring-customerform

>./mvnw tomcat7:run

You can then access customerform [here](http://localhost:9966/customerform/): ``http://localhost:9966/customerform/``

If the web app is started from within eclipse then access customerform 
[here](http://localhost:8080/customerform/): ``http://localhost:8080/customerform/``


## Running unit-tests

To run all the test execute:

>./mvnw test

To run an specific unit-test execute: ./mvnw -Dtest=TestsClassName test, example:

>./mvnw -Dtest=CatalogueServiceJpaTests test


Note: the JPA and JDBC implementations have unit-tests implemented and tested.


## How to use customerform

There are three views accessible directly through the web app menu, which it is 
located at the top right hand side. The views are:

1) [Home](#home-view)

2) [Customers](#customers-view)

If an exception is thrown when processing a request by one of the controller 
then an internal error page is displayed on the browser.

All the pages have at the footer, left hand side, a list of the languages 
supported represented by the flags of the countries the language originate 
from. The first of this flags corresponds to the language displayed in the 
shown page and subsequent pages. The next flags to this one are the other 
language supported, any of which can be clicked to change the language.

### Home view
The 'Home' view gives an introduction to the web app.

### Customers view
The 'Customers' view lists all the customer details in the database. The 
customer can be sorted by any of the shown columns by clicking on the 
corresponding header. The action applicable to each entry are accessible 
from the last column.


## Overview
View: JSP with custom tags + bootstrap (CSS), [Webjars](http://www.webjars.org/) and [Dandelion](http://dandelion.github.io/).

Controller: Sprint and MVC annotations with bean validation.

Service: @Cacheable and @Transactional.

Repository: 3 profiles - Sprint Data JPA, default (JPA) and jdbc.

---

The Web Layer: Sprint MVC and third-party web libraries (Dandelion and Webjars).

	Dandelion: datatables (based on JQuery datatables and Bootstrap) with functionality to sort and filter
	
	Webjars: Allows CSS and JS libraries to be imported as Maven libraries (http://www.webjar.org/).

This implementation uses the Model View Controller (MVC) pattern. The different components can be found at:
	<ul>
		<li>Model <a href="/src/main/java/com/aas/samples/customerform/model">here</a></li>
		<li>Views <a href="/src/main/webapp/WEB-INF/jsp">here</a></li>
		<li>Controllers <a href="/src/main/java/com/aas/samples/customerform/web">here</a></li>
	</ul>

### Flow Diagram

<p align="center">
  <img alt="FD" src="docs/customerform_flowDiagram.png" width="350" title="Flow Diagram."/>
</p>


## Database

<p align="center">
  <img alt="ERD" src="docs/customerform_erd.png" width="200" title="Entity Relation Diagram (ERD)."/>
</p>

### Database configuration

In its default configuration, Customerform uses an in-memory database 
(HSQLDB) which gets populated at startup with data. A similar setup is provided 
for MySql in case a persistent database configuration is needed. Note that 
whenever the database type is changed, the data-access.properties file needs to 
be updated and the mysql-connector-java artifact from the pom.xml needs to be 
uncommented.

You may start a MySql database with docker:

>docker run -e MYSQL_ROOT_PASSWORD=customerform -e MYSQL_DATABASE=customerform -p 3306:3306 mysql:5.7.8

## Working with Customerform in Eclipse/STS

### Prerequisites
The following items should be installed in your system:
* Maven 3

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process [here](http://www.eclipse.org/m2e/).


### Steps:

1) In the command line
``copy project into your local storage``

2) Inside Eclipse
``File -> Import -> Maven -> Existing Maven project``


## Security

There is not any security implemented on this code except on the use of GET and 
POST, where POST hides the direct view of the transmitted values.

A common used approach to security is the use of security tokens:

	Since the HTTP protocol is stateless, this means that if we authenticate a 
	user with a username and password, then on the next request, our 
	application won’t know who we are. We would have to authenticate again.

Token based authentication is stateless. No information about a user is 
being stored on the server or in a session, so the application can scale.

The step followed are:
- User requests access with Username and Password
- Application validates credentials
- Application provides a signed token to the client, which me contain extra data
- Client stores that token and sends it along with every request
- Server verifies token and responds accordingly to the request, e.g. data


## Looking for something in particular?

<table border="1">
  <tr>
    <th width="300px">Java Config</th><th width="510px">Comments</th>
  </tr>
  <tr>
    <td>Java Config branch</td>
    <td>
      Customerform uses XML configuration by default. In case you'd like to 
      use Java Config instead.
    </td>
  </tr>
  <tr>
    <th width="300px">Inside the 'Web' layer</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Spring MVC - XML integration</td>
    <td><a href="/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>Spring MVC - ContentNegotiatingViewResolver</td>
    <td><a href="/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>JSP custom tags</td>
    <td>
      <a href="/src/main/webapp/WEB-INF/tags">WEB-INF/tags</a>
    </td>
  </tr>
  <tr>
    <td>Bower</td>
    <td>
      Bower-install maven profile declaration inside <a href="/pom.xml">pom.xml</a> <br />
      JavaScript libraries are defined by the manifest file <a href="/bower.json">bower.json</a> <br />
      <a href="/.bowerrc">Bower configuration</a> using JSON <br />
      <a href="/src/main/resources/spring/mvc-core-config.xml#L30">Resource mapping</a> in Spring configuration <br />
	</td>
  </tr>
  <tr>
    <td>Dandelion-datatables</td>
    <td>
      <a href="/src/main/webapp/WEB-INF/jsp/customers/wellcome.jsp">wellcome.jsp</a>, 
      <a href="/src/main/webapp/WEB-INF/jsp/customers/customersList.jsp">customersList.jsp</a>, 
      <a href="/src/main/webapp/WEB-INF/jsp/products/customerView.jsp">customerView.jsp</a>, 
      <a href="/src/main/webapp/WEB-INF/jsp/products/customerEdit.jsp">customerEdit.jsp</a>, 
      <a href="/src/main/webapp/WEB-INF/web.xml">web.xml</a> and 
      <a href="/src/main/resources/dandelion/datatables/datatables.properties">datatables.properties</a> 
   </td>
  </tr>
</table>
<br />
<table border="1">
  <tr>
    <th width="300px">'Service' and 'Repository' layers</th><th width="510px">Files</th>
  </tr>
  <tr>
    <td>Transactions</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>, 
      <a href="/src/main/java/com/aas/samples/customerform/service/CustomerServiceImpl.java">CustomerServiceImpl.java</a> and  
      <a href="/src/main/java/com/aas/samples/customerform/service/HomeServiceImpl.java">HomeServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Cache</td>
      <td>
       <a href="/src/main/resources/spring/tools-config.xml">tools-config.xml</a> and
       <a href="/src/main/java/com/aas/samples/customerform/service/CustomerServiceImpl.java">CustomerServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Bean Profiles</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a>, 
      <a href="/src/test/java/com/aas/samples/customerform/service/CustomerServiceJdbcTests.java">CustomerServiceJdbcTests.java</a> and 
      <a href="/src/main/webapp/WEB-INF/web.xml">web.xml</a>
    </td>
  </tr>
  <tr>
    <td>JdbcTemplate</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a> and 
      <a href="/src/main/java/com/aas/samples/customerform/repository/jdbc">jdbc folder</a>
    </td>
  </tr>
  <tr>
    <td>JPA</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a> and 
      <a href="/src/main/java/com/aas/samples/customerform/repository/jpa">jpa folder</a>
    </td>
  </tr>
  <tr>
    <td>Spring Data JPA</td>
    <td>
      <a href="/src/main/resources/spring/business-config.xml">business-config.xml</a> and 
      <a href="/src/main/java/com/aas/samples/customerform/repository/springdatajpa">springdatajpa folder</a>
    </td>
  </tr>
</table>


## Others
The graphics were created using [draw.io](https://www.draw.io/). They can be 
modified by uploading the XML files located under the [docs](docs/) directory 
from within [draw.io](https://www.draw.io/").

### TODO
- Need to complete the storage in a file.
- Complete unit-tests.
