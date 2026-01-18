# Rule Engine Spring Boot

A Spring Boot backend project implementing a simple rule engine for evaluating transactions based on rules.

## Tech Stack
- Java 17
- Spring Boot
- Maven

## Project Structure
```
src/main/java/com/leadicon/ruleengine
├── controller
├── model
├── service
```
## How to Run
```bash
mvn clean install
mvn spring-boot:run
```
> Application will start on http://localhost:8080/
> Swagger UI: http://localhost:8080/swagger-ui/index.html

## Sample Test
### Add Rules (POST /rules)
```json
[
{ "condition": "amount > 1000 && type == 'credit'" },
{ "condition": "category == 'grocery'" }
]
```
### Evaluate Transactions (POST /evaluate)
```json
[
{ "id": 1, "amount": 2500, "type": "credit", "category": "electronics" },
{ "id": 2, "amount": 120, "type": "debit", "category": "grocery" },
{ "id": 3, "amount": 800, "type": "credit", "category": "fashion" }
]
```
### Expected Output
```json
[
{
"id": 1,
"amount": 2500,
"type": "credit",
"category": "electronics"
},
{
"id": 2,
"amount": 120,
"type": "debit",
"category": "grocery"
}
]

```

## Author

> Anurag Tarai
