Demo.SpringAop
==============

A simple console &amp; test apps to demonstrate AOP &amp; Dependency injection using Spring AOP framework.

Things to do before running the sample:
---------------------------------------
Install these following softwares in your machine:
  - JDK 7 with latest updates version.
  - Git client
  - Intellij IDEA 11.x-12.x (Optional)

HOW TO - Pull the project from github to your local machine:
------------------------------------------------------------
1. Open the git bash console.
2. Change directory to a folder where you are going to put the source code in.
3. Type &amp; run this command: git clone git@github.com:saintc0d3r/Demo.SpringAop.git

HOW TO - Run the unit test in Intellij IDEA:
--------------------------------------------
1. Run your intellij IDEA.
2. Open the project.
3. Click "Run" -> "Edit Configuration" menu.
4. On the "Run/Debug Configurations", click greenish '+' small icon and click "Junit".
5. On the Junit section panel, enter the Name field with any string (e.g. demo.springaop.spec), Package: demo.springaop.spec, Search for tests: In whole project.
6. Click [Apply] and then [Ok].
7. Run the unit test through pressing [CTL]+[F5] or click "Run"->"Run '<your Junit run configuration name>'".

HOW TO - Run the console client in Intellij IDEA:
-------------------------------------------------
1. Run your intellij IDEA.
2. Open the project.
3. Click "Run" -> "Edit Configuration" menu.
4. On the "Run/Debug Configurations", click greenish '+' small icon and click "Application"
5. On the Application section panel, enter the Name field with any string (e.g. demo.springaop.console), Main class: demo.springaop.ConsoleClient.
6. Click [Apply] and then [Ok].
7. Run the unit test through pressing [CTL]+[F5] or click "Run"->"Run '<your Application run configuration name>'".

The anatomy of Demo.SpringAop project:
---------------------------------------------------------
1. lib folder - contains all required dependencies to run the samples.
2. resources folder - contains the Spring's configuration xml files and Jbehave's story files.
2. spec folder - contains java files which built the unit test demo.
2. src folder - contains java files which built the console demo & Digest service's class + interface.

HOW TO - Confirm that the dependency injection & Aspect are working:
-------------------------------------------------------------------
1. When running the Console demo, confirm that the output does not return "Digest service is unavailable.", instead it should return the output of invoking the Digest Service.
2. Confirm that a log message "INFO: Start calling 'demo.springaop.service.IDigestService.digest' method at ..." displayed before the output.
   Also, a log message "INFO: Finished calling 'demo.springaop.service.IDigestService.digest' method at ..." displayed after the output.

Future TO-DOs:
--------------
1. Improve the console demo.
