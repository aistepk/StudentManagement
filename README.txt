# Server programming, school project, Student Management Rest-API

# Clone or download the repository

# For this project to work you need to have Wildfly ready on your computer

# Create database in your preferred sql and connect it to available port

# The following example was written in derby

# Open a terminal and navigate to your bin derby folder (db-derby\bin if you are using derby) and execute following command:

  NetworkServerControl.bat -p 50000 start
  
 #Then, open another terminal and navigate to db-derby\bin and run ij.bat, then in ij terminal, run the following command:
 
  connect 'jdbc:derby://localhost:50000/StudentSystem; create=true' ;

# Make sure your standalone.xml file is configured for the database you created, the datasource, connection URL and driver tags shoud be updated
# depending on your specifications, for example:

  <datasource jndi-name="java:/StudentSystem" pool-name="StudentSystem" enabled="true" use-java-context="true">
    <connection-url>jdbc:derby://localhost:50000/StudentSystem</connection-url>
      <driver>derbyclient.jar</driver>
      <security>
           <user-name>APP</user-name>
           <password>APP</password>
      </security>
  </datasource>
 
# In the third terminal, navigate to bin folder in wildfly and run standalone.bat       
         
# Open the project in your preferred IDE 

# Open build.xml file ant run it as "ant build" to deploy it on Wildfly



Authors: Aiste and Shahid  