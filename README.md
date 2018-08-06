# task-planner
Plans and assigns task


APP Functionality 
•	Login
•	LogOut
•	List Task 
•	Create Task
•	Update Task 
•	Delete Task 

Execute by calling mvn spring-boot:run

Two users are configured for Sign in :
1.	UserName: joy  ; Password: 123 ; Role : USER
2.	UserName: admin  ; Password: admin   ; Role : ADMIN


DB credentials(admin / admin)


Tech Stack Used :
Backend 
•	Spring Boot 
•	Spring MVC
•	Spring Data JPA 
•	H2 DB 
•	Spring Security 
Frontend
•	Html
•	CSS
•	JavaScript


Using Docker commands also this application can be built . 
Go inside the task-planner app and execute the below commands . Make sure you have docker installed:

docker build -t joy1987/taskplanner-0.1.0 -f Dockerfile .
docker run --name taskplanner -v /usr/local/repo:/root/.m2  -p 9000:9000  joy1987/taskplanner-0.1.0
