# Trello API Testing with RestAssured
![TrelloRestAssuredPic](https://github.com/user-attachments/assets/76618ad1-30f1-4e0c-ab1b-06dfa14b3e95)

This repository contains the test automation scripts for testing the [Trello API](https://developer.atlassian.com/cloud/trello/rest/) using RestAssured and TestNG.

## Introduction
This project demonstrates automated API testing using RestAssured for the Trello API. It is designed to interact with Trello's API through RESTful requests.
The tests cover the basic CRUD operations (Create, Read, Update, Delete) for boards, lists, and cards on Trello.

## Technologies Used
- RestAssured
- TestNG

## Prerequisites
Before diving into the project, ensure you have the following prerequisites:

- Java (Version 8 or higher).
- Maven for project management.
- An IDE like Eclipse or IntelliJ.
- RestAssured.
- TestNG.
- Optionally, Allure Reports for enhanced reporting.

## Installation
 1. Clone this repository:
    ```console
    git clone https://github.com/DinaMagdyS/TrelloRestAssure.git


2. Import the project into your favorite IDE (e.g., IntelliJ IDEA or Eclipse).
3. Install the required dependencies (TestNG, RestAssured) using Maven.
4. Install Allure on your system.  https://github.com/allure-framework/allure2/releases
5. Install Allure TestNG depenency. 

## Project Structure
The project structure is organized as follows:

- utils: package containing utility classes.
  
○ Data: Provides test data and variables shared across different test classes.

○ SetUp: Contains creation and deletion requests used in end to end scenario.

○ Utils: Contains classes defining base URLs, API endpoints and Authentication Key and Token. 

- trelloTests: Package contains test automation scripts.
  
○ BaseTest: Contains base test classes or utility classes shared across different test classes.

○ BoardTests: Contains tests related to Trello boards.

○ CardTests: Contains tests related to Trello cards.

○ ListsTests: Contains tests related to Trello lists.

○ ChecklistTests: Contains tests related to Trello checklists.

○ E2E: Contains tests related to end to end scenario.

## Execution 


https://github.com/user-attachments/assets/01d1b29a-9f03-4b79-a0ba-d6a549d85164



https://github.com/user-attachments/assets/c24fb043-9bc3-4f5d-9cee-13c9809ae2ab





## Allure Reports
After Running, copy the absolute path of the 'allure-results' folder and in your terminal (cmd) 
```console
allure serve absolutepath
```
![AllureReport](https://github.com/user-attachments/assets/0b0155d6-d5ef-4c0a-beb0-2ab33f8decde)

## Contact 
For any queries or assistance, feel free to contact me via email at dinamagdyelmorsy@outlook.com
