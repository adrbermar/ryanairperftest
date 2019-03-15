# ryanairperftest

Steps to execute performance tests using Gatling and Maven:

Pre-requirements:

•	Maven 3.6.0
•	Java 1.8

Steps:

1.	Download and clone source code from Github to local folder: 
git clone https://github.com/adrbermar/ryanairperftest.git

2.	Open terminal and go to folder root downloaded previously.

3.	Execute the following commands for each scenario:
1.	Unit Test: 
mvn gatling:test -Dgatling.simulationClass=test_scenarios.unitTest

2.	Load Test:
mvn gatling:test -Dgatling.simulationClass=test_scenarios.loadTest

3.	Distributed Load Test:
mvn gatling:test -Dgatling.simulationClass=test_scenarios.distributedLoadTest

4.	After finish executions, results and reports for every one are stored in:
/{yourFolder}/ryanair-perftests/target/gatling/
