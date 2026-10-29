# Kozhakhmet Zhanakhmet Student API

**Student:** Zhanakhmet Kozhakhmet  
**Course:** DevOps  
**Project:** Spring Boot CRUD API with PostgreSQL, Docker Compose, Git and Jenkins CI/CD.

## Run
```bash
docker compose up --build -d
docker compose ps
docker compose logs -f app
```
API base URL: `http://localhost:8080/api/students`

## Create
```bash
curl -i -X POST http://localhost:8080/api/students -H 'Content-Type: application/json' -d '{"name":"Zhanakhmet Kozhakhmet","email":"zhanakhmet.kozhakhmet@example.com","course":"Software Engineering"}'
```
## Read all / one
```bash
curl -i http://localhost:8080/api/students
curl -i http://localhost:8080/api/students/1
```
## Update
```bash
curl -i -X PUT http://localhost:8080/api/students/1 -H 'Content-Type: application/json' -d '{"name":"Zhanakhmet Kozhakhmet","email":"zhanakhmet.updated@example.com","course":"DevOps"}'
```
## Delete / nonexistent ID
```bash
curl -i -X DELETE http://localhost:8080/api/students/1
curl -i http://localhost:8080/api/students/99999
```
## Linux report
```bash
chmod 755 scripts/Kozhakhmet_Zhanakhmet_system_report.sh
./scripts/Kozhakhmet_Zhanakhmet_system_report.sh
```
The script displays and saves system information in `logs/Kozhakhmet_Zhanakhmet_system_report.log`.

## Git workflow
```bash
git init
git config user.name "Zhanakhmet Kozhakhmet"
git config user.email "YOUR_EMAIL"
git add .
git commit -m "Initial commit: Zhanakhmet Kozhakhmet Student API"
git switch -c feature/kozhakhmet-zhanakhmet-crud
git add .
git commit -m "Add student CRUD API"
git switch main
git merge feature/kozhakhmet-zhanakhmet-crud
git tag v1.0-kozhakhmet-zhanakhmet
```

## Credentials
Compose fallback credentials are for local coursework only. For real deployment, set `POSTGRES_USER` and `POSTGRES_PASSWORD` in an untracked `.env` file or use a secret manager. Never commit real passwords or production credentials.

## Jenkins
The Jenkinsfile includes Checkout, Build, Test, Docker Build and Verify. The Jenkins agent must have Java 21, Gradle and Docker available. This starter uses the installed `gradle` command; if your environment requires the Gradle wrapper, add wrapper files and use `./gradlew`.

## Notes
This is a learning project, not a production-hardened service. The API uses Hibernate `ddl-auto=update` for coursework convenience.
