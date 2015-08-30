## A Shopping website hosted in Google App Engine .

EasyBuy is a shopping website build uisng java web technologies. Powered by Google App Engine as web host & Google Cloud SQL as Database.The pages are developed in JSP & Java Servlets with Bootstrap 3 . The web pages are responsive , adjust the look & feel for diffrent screen sizes of Desktops or mobile or tablets.


## Requirements

* [Apache Maven](http://maven.apache.org) 3.0 or greater
* Google App engine instance.
* Google Cloud SQL instance (Database)
* JDK 7+
* Git Version Control

Clone this repository to a local directory.  Maven will download all the other dependencies.


## Deploying

To build, run:

    mvn package


## Local deployment

TBD

## App Engine deployment

In `pom.xml` update the following properties:

* `appengine.app.appId` to point to your App Engine application ID
* `cloudsql.url` to point to your Cloud SQL instance by replacing `your-instance-name` with the full name of your instance (this looks either like `my_project:my_instance` for non-domain specific instances or like `my_domain:my_project:my_instance` for the domain-specific ones).

Make sure the  database exists on the Cloud SQL instance.

To deploy the app run the following command from command line or Shell:

Go to the folder of the app with target.

appcfg.cmd -A roshaneasybuy update target\native-mysql-eclipselink-jpa-1.0
   


Visit the website here :

http://roshaneasybuy.appspot.com

