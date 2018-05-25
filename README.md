
This document sometimes refers to the HarrisERP repository folder which contains this project.


# HarrisERPExercise - Fee Processor

This program is located in **HarrisERP\Project** and is a .zip file. Fee Processor was created in Eclipse in a Java 8 environment. Since I used some stream functionality and some lambdas, Java 8 is required to run this program. The stream API and lambda support is not in Java 7 and lower.

To see the code, simply unzip the file at **HarrisERP\Project\HarrisERPExercise.zip** and navigate to **HarrisERPExercise\src\com\harriserpexercise**. Each of the packages located there contain different parts of the projects code. **\app** contains the Main.java file which runs the project, and also the ConsoleRunner.java file which does all of the console displaying. **\services** contains the project's main service class, TransactionManager. This does most of the project's logic. **\entities** is where the Fee, Payment, and Transaction classes reside. Finally, **\util** just contains a class I used for some utility methods.

# NOTES

In this folder, there should be folders named JavaWindows and JavaMac. These are where copies of the Java 8 jre reside. I have included these so that it is not necessary for the user to install anything. If you would like to install Java 8 on your machine anyway, please continue to section titled **How to Check Java Version**. Otherwise, continue to the section titled **How to Run with Embedded JRE**.

# NOTE - When Running

When the program starts up, and you are prompted to begin, maximize your console/terminal window. This is not 100% necessary, however if this is not done, the table that display the data at the end will not appear to be aligned, and certain columnswill show on the wrong lines. Sorry for the inconvenience. 

# How to Run with Embedded JRE

**!!!NOTE FOR MAC!!! - Mac Users, please download this entire folder onto your Desktop. For the RunOnMac.command file to work and use the embedded jre, I had to choose a location for the file to look for the jre because when you run a .command, .sh, or .bash file on Mac, it automatically starts running from the machine's home directory. Since I had to choose a location relative to the home directory, I went ahead and told it to look on the Desktop. So please install this folder onto your desktop. The directory structure should be /Desktop/HarrisERP/ and HarrisERP should contain Project, RunnableJar, JavaMac, etc. Sorry for the inconvenience.**

In the main folder you have downloaded called **HarrisERP** there should be files named **RunOnWindows.bat** and **RunOnMac.command**. Simply double-click the file that corresponds to your operating system, or right-click and choose Open. This should bring up your terminal/command prompt and you should see a command followed by **Welcom to Fee Processor**. You are now running the program and can follow on-screen instructions.

Unfortunately, if you are using Linux, you will need to download Java 8 and use it to run this program. Luckily, it is not very hard. Continue to section **How to Install Java 8**.

# How to Check Java Version

If you are unsure whether you already have Java installed on your machine, please refer to:

Windows - open command prompt and type **java -version**

Mac - open terminal and type **java -version**

Linux - open terminal and type **java -version**


If you java version says something like **java version "1.8.0_###"** then you already have Java 8 installed and can continue to **How to Run in Command Line**. If you instead see **java version "1.7.0_###"**, another number, or an error saying it could not find the java command, then you do not have java 8 installed. Please refer back to section **How to Run with Embedded JRE** or continue to **How to Install Java 8**.

# How to Install Java 8

To install Java 8, please head to https://java.com/en/download/manual.jsp. Choose which operating system you are using (Windows/Mac/Linux). There are also intallation instructions provided to the side of the operating system download choice. 

For instructions:

Windows - https://java.com/en/download/help/windows_manual_download.xml

Mac - https://java.com/en/download/help/mac_install.xml

Linux - https://java.com/en/download/help/linux_install.xml       For linux, the easiest way to install is usually by opening the terminal and running **sudo apt install openjdk-8-jre-headless** and follow the instructions on-screen. It should install Java 8 for you.


If these do not cover your operating system, there are more helpful links on the Java website.

Once Java is installer, you can either set the environment variables for Java (Windows), or simply use the downloaded jdk directory path to run the java command.

# How to Run in Command Line

If you are more familiar with Java, have Java 8 installed on your machine, and would like to run the .jar file yourself, you can use the following command to do so:

**NOTE - unless you want to use absolute paths, run all of these commands while you are in the Main directory for this project, called HarrisERP! Otherwise, you will need to use full absolute path names to reach the .jar file and/or the other files!**

The .jar file is located at **HarrisERP\RunnableJar\HarrisERPExercise.jar**.

Windows - in the command line, navigate to the **HarrisERP** folder. If your environment variable for Java is set, type **java -jar RunnableJar\HarrisERPExercise.jar**. If you do not have the environment variable for Java 8 set up (and typing java -version does not work), then you can still use the path to the java.exe file to run java commands. You will need to know the path to where you installed Java, which should be something similar to **"C:\Program Files\Java\jdk1.8.0_161\bin\java.exe**. Using that path you would type **"C:\Program Files\Java\jdk1.8.0_161\bin\java.exe -jar RunnableJar\HarrisERPExercise.jar**.  Or you can use the path to the Java 8 jre that is included in the HarrisERP folder. Using this, the path would be **JavaWindows\bin\java.eve -jar RunnableJar\HarrisERPExercise.jar**.

Mac - Running the program in Mac's terminal is the exact same as on Windows, except the paths would be different. If Java 8 is installed, you should be able to just use **java -jar** command, and do not have to use the whole absolute path.

Linux - Running the program in a Linux terminal is the exact same as on Windows, except the paths would be different. If Java 8 is installed, you should be able to just use **java -jar** command, and do not have to use the whole absolute path.
