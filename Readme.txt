Product: CingleVue International:Code Challange: Java EE SPA Web application for manage school database records

Pre-requisites:

Maven 3.x
Java 1.7 or above
JBoss Enterprise Application Platform 6.3.0.GA
MongoDB 2.6 or above

Used Technologies/Frameworks

Java EE 2.5
Spring MVC v4.0
Spring Integrated RESTFul web services
Spring Data MongoDB v1.2
AngularJS v1.2.27
Bootstrap v2.3.2
GIT

Tested Platform:
Apple OSX 10.10 Chrome/Safari

Steps to follow in deploying web application.

01)	Install the relevent softwares and plugings that mentioned as Pre-requisites.

02) Clone or Download the Maven project from github.

   	https://github.com/samliyanage/schools-app/

03 	Build the project with maven using following command

	{Project_Location}>mvn clean install 

04) Deploy the "schoolWebApp.war" file that built in step [3].

05) To manage/view school records, use the following URL.

	http://{Host_Name}:{Port}/studentApp/
