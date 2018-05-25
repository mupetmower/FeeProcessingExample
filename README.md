# HarrisERPExercise - Fee Processor

This program was created in Eclipse in a Java 8 environment. Since I used some stream functionality and some lambdas, Java 8 is required to run this program. The stream API and lambda support is not in Java 7 and lower.

# NOTES

In the folder this was downloaded with, There should be folders named JavaWindows, JavaMac, JavaLinux. These are where copies of the Java 8 jre reside. I have included these so that it is not necessary for the user to install anything. If you would like to install Java 8 on your machine anyway, please continue to section titled **How to Check Java Version**. Otherwise, continue to the section titled **How to Run with Embedded JRE**.

# How to Run with Embedded JRE

In the main folder you have downloaded called **HarrisERP** there should be files named **RunOnWindows**, **RunOnMac**, and **RunOnLinux**. Simply double-click the file that correcsponds to your operating system, or right-click and choose Open. This should bring up your terminal/console and you should see a command followed by **Welcom to Fee Processor**. You are no running the program and can follow on-screen instructions.

# How to Check Java Version

If you are unsure whether you already have Java installed on your machine, please refer to:

Windows - open command prompt and type **java -version**

Mac - open terminal and type **java -version**

Linux - 


If you java version says something like **java version "1.8.0_###"** then you already have Java 8 installed and can continue to **How to Run in Command Line**. If you instead see **java version "1.7.0_###"**, another number, or an error saying it could not find the java command, then you do not have java 8 installed. Please refer back to section **How to Run with Embedded JRE** or continue to **How to Install Java 8**.

# How to Install Java 8

To install Java 8, please head to https://java.com/en/download/manual.jsp. Choose which operating system you are using (Windows/Mac/Linux). There are also intallation instructions provided to the side of the operating system download choice. 

For instructions:

Windows - https://java.com/en/download/help/windows_manual_download.xml

Mac - https://java.com/en/download/help/mac_install.xml

Linux - https://java.com/en/download/help/linux_install.xml 


If these do not cover your operating system, there are more helpful links on the Java website.

Once Java is installer, you can either set the environment variables for Java (Windows), or simply use the downloaded jdk directory path to run the java command.

# How to Run in Command Line

If you are more familiar with Java, have Java 8 installed on your machine, and would like to run the .jar file yourself, you can use the following command to do so:

**NOTE - run all of these commands while you are in the Main directory for this project, called HarrisERP! Otherwise, you will need to use full absolute path names to reach the .jar file and/or the other files!**

Windows - in the command line, navigate to the **HarrisERP** folder. If your environment variable for Java is set, type **java -jar RunnableJar\HarrisERPExercise.jar**. If you do not have the environment variable for Java 8 set up (and typing java -version does not work), then you can still use the path to the java.exe file to run java commands. You will need to know the path to where you installed Java, which should be something similar to **"C:\Program Files\Java\jdk1.8.0_161\bin\java.exe**. Using that path you would type **"C:\Program Files\Java\jdk1.8.0_161\bin\java.exe -jar RunnableJar\HarrisERPExercise.jar**.  Or you can use the path to the Java 8 jre that is included in the HarrisERP folder. Using this, the path would be **JavaWindows\bin\java.eve -jar RunnableJar\HarrisERPExercise.jar**.

Mac - Running the program in Mac's terminal is the exact same as on Windows, except the paths would be different.

Linux - Running the program in a Linux terminal is the exact same as on Windows, except the paths would be different.
