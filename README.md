Portfolio Analysis and Management System

Overview

The Portfolio Analysis and Management System is a comprehensive solution designed to help users effectively manage their financial investments. By analyzing investment portfolios, performing risk assessments, and offering tailored suggestions for portfolio rebalancing, this system empowers users to make informed financial decisions. The system leverages CAS (Consolidated Account Statement) documents to generate a detailed view of a user’s investment portfolio.

![neew](https://github.com/user-attachments/assets/381f84c6-2d59-478b-b2f5-4d83dbe4e990)


Key Features

	•	Portfolio Analysis:
	•	Automatic parsing and processing of CAS documents.
	•	Visual representations of portfolio composition.
	•	Performance tracking and analysis based on historical data.
	•	Risk Assessment:
	•	Personalized user risk profiling based on a dynamic questionnaire.
	•	Risk-return analysis to match portfolio risk levels.
	•	Metrics to evaluate portfolio diversification.
	•	Investment Management:
	•	Real-time tracking of portfolio performance.
	•	Investment recommendations based on market data.
	•	Suggestions for portfolio rebalancing to optimize returns.

Project Status

The project is currently in development. The following key components have been implemented:

	•	Risk Profiling based on a dynamic questionnaire.
	•	Fetching Investment Portfolios from external APIs (e.g., RapidAPI).
	•	Basic Portfolio Analysis using stock and mutual fund data from external APIs like Twelve Data.
	•	Initial Risk Profiling and Matching of the user’s portfolio with their risk profile.

System Flow

The full system flow includes user authentication, portfolio fetching, risk profiling, and investment management. Below is a brief flowchart showing the process:

	1.	User Authentication: Users log in, and their risk profile is created based on their responses to a dynamic questionnaire.
	2.	Fetch Investment Portfolio: The system fetches the user’s portfolio from external data sources.
	3.	Portfolio Analysis & Risk Evaluation: The portfolio is analyzed to match the user’s risk profile, and rebalancing suggestions are generated.
	4.	Investment Suggestions & Gamification: Users are given suggestions for improving their portfolios and can manage financial goals through gamified tasks.


 Models and Services

The current development covers key entities like User, InvestmentPortfolio, MutualFund, and Equity. The backend architecture uses controllers, services, and repositories to handle these entities. Below is a diagram of the models and services implemented so far:

<img width="845" alt="Screenshot 2024-10-23 at 11 28 37 PM" src="https://github.com/user-attachments/assets/2054ec5b-b1dd-479c-8ab4-0bdfbf2bcc18">


<img width="906" alt="Screenshot 2024-10-23 at 11 29 16 PM" src="https://github.com/user-attachments/assets/5128bf84-69b4-40ab-952d-b24e7e62a6f4">

<img width="1003" alt="Screenshot 2024-10-23 at 11 29 05 PM" src="https://github.com/user-attachments/assets/3d804fe5-3e52-48df-b879-05e351bd231b">




Tech Stack

Backend

	•	Java with Spring Boot for the REST API services.
	•	PostgreSQL as the database for storing user and portfolio data.
	•	Spring Security for authentication and authorization.
	•	Integration with external financial data sources via RapidAPI and Twelve Data API.

