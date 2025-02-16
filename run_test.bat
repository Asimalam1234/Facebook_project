@echo off

REM Change directory to your Maven project directory
cd C:\Users\Kinectro\Desktop\Facebook_Automation

REM Clean and install the project (optional but recommended)
mvn clean install

REM Run TestNG tests using Maven (with Surefire plugin)
mvn test

REM Pause to keep the console window open (optional)
pause
