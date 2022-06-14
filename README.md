# Trade-Management-System-using-Corda
A Trade Management System to facilitate the transactions between Buyer, Seller and Trader
# SOFTWARES NEEDED: -
IntelliJ
Java JDK 8
Git
Gradle
# Steps: -
1. Open the Corda Application in IntelliJ IDEA.
2. Now Open the Command prompt in the Corda Application.
3. Use “gradlew clean deployNodes”command.
    a.  Nodes are built on the Cordapp installed on them.
4.  Go to the “build/nodes” folder.
    a.  A folder for each generated node
    b.  A runnodes shell script for running all the nodes simultaneously on OSX
    c.  A runnodes.bat batch file for running all the nodes simultaneously on Windows
5.  To start the nodes and the sample CorDapp
    a.  Run the command “\build\nodes\runnodes.bat”.
    b.  Start a Spring Boot server for Party A. Run the command: “gradlew.bat runPartyAServer” on command prompt.
    c.  Similarly, Run other party servers.
6.  Interact with the sample CorDapp: 
    a.  Via HTTP.  
    b.  Via interactive shell.
    c.  Via h2 console.
7.  Nodes started via the command line will display an interactive shell
    a.  Type flow list in the shell to see a list of the flows that your node can run. 
    b.  Type flow start following the flow name to initiate the flow between Nodes
8.  The Spring Boot servers run locally on the following ports:
    a.  PartyA: localhost:50005 
    b.  PartyB: localhost:50006 
9.  Inorder to Run the application using h2 console, Copy paste the JDBC URL into the H2 console. The database will contain all the data about the particular node
10. Test the Cordapp.
    a.  Run an integration test to calibrate your environment.
    b.  Run the CorDapp’s contract tests by running the Run Contract Tests – Java. 
    c.  Run the CorDapp’s flow tests by running the Run Flow Tests - Java run configuration.

