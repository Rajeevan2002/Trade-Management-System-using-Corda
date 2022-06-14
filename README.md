# Trade-Management-System-using-Corda
A Trade Management System to facilitate the transactions between Buyer, Seller and Trader
## SOFTWARES NEEDED: -
* IntelliJ 2017.x, 2018.x, 2019.x, and 2020.x
* Java JDK 8
* Git
* Gradle
## Steps: -
* Open the Corda Application in IntelliJ IDEA.
* Now Open the Command prompt in the Corda Application.
* Use “gradlew clean deployNodes”command.
  * Nodes are built on the Cordapp installed on them.
* Go to the “build/nodes” folder.
  * A folder for each generated node
  * A runnodes shell script for running all the nodes simultaneously on OSX
  * A  runnodes.bat batch file for running all the nodes simultaneously on Windows
* To start the nodes and the sample CorDapp
  * Run the command “\build\nodes\runnodes.bat”.
  * Start a Spring Boot server for Party A. Run the command: “gradlew.bat runPartyAServer” on command prompt.
  * Similarly, Run other party servers.
* Interact with the sample CorDapp: 
  * Via HTTP.  
  * Via interactive shell.
  * Via h2 console.
* Nodes started via the command line will display an interactive shell
  * Type flow list in the shell to see a list of the flows that your node can run. 
  * Type flow start following the flow name to initiate the flow between Nodes
* The Spring Boot servers run locally on the following ports:
  * PartyA: localhost:50005 
  * PartyB: localhost:50006 
* Inorder to Run the application using h2 console, Copy paste the JDBC URL into the H2 console. The database will contain all the data about the particular node
* Test the Cordapp.
  * Run an integration test to calibrate your environment.
  * Run the CorDapp’s contract tests by running the Run Contract Tests – Java. 
  * Run the CorDapp’s flow tests by running the Run Flow Tests - Java run configuration.

