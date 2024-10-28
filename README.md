# KLSETracker

KLSETracker is a Java Spring Boot application I developed to fetch and analyze daily stock data from the **Kuala Lumpur Stock Exchange (KLSE)**. The application counts the number of gainers and losers each day and stores this data in an H2 in-memory database, allowing for easy access and review.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Database](#database)
- [Testing](#testing)
- [License](#license)

## Project Overview
The **KLSETracker** application fetches stock data from KLSE daily and performs the following tasks:
1. Analyzes the stock data to determine the number of gainers and losers.
2. Stores the daily counts of gainers and losers in an H2 database with the following schema:

record_datetime   num_gainers   num_losers

## Features
- Fetches real-time stock data from KLSE.
- Analyzes data to count stock gainers and losers.
- Schedules data fetching and analysis daily.
- Stores results in an H2 in-memory database for quick access.

## Technologies Used
- **Java**: Main programming language.
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For seamless data access and repository setup.
- **H2 Database**: In-memory database for storing analyzed data.
- **Quartz Scheduler**: To automate daily data fetching.
- **Jsoup**: Library for parsing HTML and fetching data from the web.

## Setup and Installation

### Prerequisites
- **Java 8** or higher installed.

### Installation
1. Download or clone the repository and navigate to the folder containing the `.jar` file:
```bash
git clone https://github.com/hezkyDev/KLSETracker.git
cd KLSETracker

Usage

Running the Application

To start the application, use the precompiled .jar file:

java -jar target/KLSETracker-0.0.1-SNAPSHOT.jar

The application will start, and you’ll see logs indicating the scheduled tasks and data-fetching process.

Accessing the H2 Database

	1.	H2 Console: Access the H2 database console to view the STOCK_SUMMARY table.
	2.	URL: Open a browser and go to:

http://localhost:8080/h2-console


	3.	JDBC URL: Use the following JDBC URL to connect:

jdbc:h2:mem:testdb


	4.	Credentials: Default H2 credentials are:
	•	User Name: sa
	•	Password: (leave blank)

Querying the Database

In the H2 console, use the following SQL query to see the stored records:

SELECT * FROM STOCK_SUMMARY;

Database

KLSETracker uses an H2 in-memory database with a single table:

	•	Table: STOCK_SUMMARY
	•	Columns:
	•	ID (Auto-generated ID)
	•	NUM_GAINERS (Integer count of stock gainers)
	•	NUM_LOSERS (Integer count of stock losers)
	•	RECORD_DATE_TIME (Timestamp of the record)

Testing

Running Tests

The project includes unit tests using JUnit 5 and Mockito to validate core functionality.

If you’d like to re-run tests or make changes:

	1.	Run Tests in Eclipse:
	•	Right-click on the src/test/java folder or individual test files.
	•	Select Run As > JUnit Test.
	2.	Run Tests with Maven:
	•	To run all tests using Maven, use:

mvn test



Key Test Files

	•	StockServiceTest.java: Tests for StockService to ensure data fetching and saving works as expected.
	•	StockDataFetcherTest.java: Tests for StockDataFetcher to verify that data parsing from KLSE works as expected.

License

This project is licensed under the MIT License. See the LICENSE file for details.
