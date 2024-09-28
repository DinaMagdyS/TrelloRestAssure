# Trello API Testing with RestAssured
![TrelloRestAssuredPic](https://github.com/user-attachments/assets/76618ad1-30f1-4e0c-ab1b-06dfa14b3e95)

This repository contains the test automation scripts for testing the [Trello API](https://developer.atlassian.com/cloud/trello/rest/) using RestAssured and TestNG.

## Introduction
This project demonstrates automated API testing using RestAssured for the Trello API. It is designed to interact with Trello's API through RESTful requests.
The tests cover the basic CRUD operations (Create, Read, Update, Delete) for boards, lists, and cards on Trello.

## Technologies Used
<img src="https://private-user-images.githubusercontent.com/122634626/311574401-735af872-df76-4f8e-84ff-28795f8d28f4.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mjc1MjE3MzIsIm5iZiI6MTcyNzUyMTQzMiwicGF0aCI6Ii8xMjI2MzQ2MjYvMzExNTc0NDAxLTczNWFmODcyLWRmNzYtNGY4ZS04NGZmLTI4Nzk1ZjhkMjhmNC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwOTI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDkyOFQxMTAzNTJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iZWE0ZWE4ZjAxOTY4Y2U5NDJhYjk1YjgyZjJhOTkyYzBkYjQzM2RkYzEwZDg1NmM5NDc0MjdkZTgzYjg3ODE1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.rP0bjORGI8lg3IOoCfI0QtyKayOSfpAY7GMCoSxcra8" width="40" height="40" alt="RestAssured" secured-asset-link="" style="max-width: 100%;"><img src="https://private-user-images.githubusercontent.com/122634626/306417621-86a31183-1950-4cf4-bbbe-c1c1d6dc2567.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mjc1MjE3MzIsIm5iZiI6MTcyNzUyMTQzMiwicGF0aCI6Ii8xMjI2MzQ2MjYvMzA2NDE3NjIxLTg2YTMxMTgzLTE5NTAtNGNmNC1iYmJlLWMxYzFkNmRjMjU2Ny5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwOTI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDkyOFQxMTAzNTJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kNDA4NmUzMDQzM2VjMmI2N2U0ODZjZmRlNDQ0NGRmZjAzNzdjNmZjMjJhYTRlMDE2ZGU3YzBiZmJlZDZkODIzJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.jeXQs4WDbNpq3Tnwz83AP_FlkbBxATXJa-r_0fdwa1w" width="40" height="40" alt="TestNG" secured-asset-link="" style="max-width: 100%;">
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

## Contact 
For any queries or assistance, feel free to contact me via email at dinamagdyelmorsy@outlook.com
