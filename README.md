# Git Analyzer

Git analyzer application for Scout24 home assignment, based on a simplified microservice architecture, docker containers.

### Architecture overview

![System Design](/documentation-resources/scout24-git-system-design.jpg)

### Screen Shots

![System Design](/documentation-resources/dashboard.png)
![System Design](/documentation-resources/home_screen.png)
![System Design](/documentation-resources/search_result.png)
![System Design](/documentation-resources/readme.png)

### Tech Stack

- UI: Angular8, Bootstrap

- API: Java8, Springboot

- Mysql, Redis

### How to Run

Simply execute

> docker-compose up

and go to

> localhost:4200

I pushed builded containers to my own docker hub account to prevent npm install, mvn build times etc.

### Discuss Topics

- Comsuming external apis from backend or frontend?

- How can we manage other git providers? (bitbucket,bitlocker)

- I had to put angular app to springboot project because git hub api seems doesn't let cors. I don't want to put oauth client id and secrets to angular app too. I really don't like to put angular app to springboot but i can't figure out better solution. Is it safe to store client id and client secret to angular app? Is there better solution?

### TODO

- Improve logging. Logging API, NoSql, Streaming, Notifications etc.

- Add paging to reduce traffic size.

- Add rate limiter to protect system.

- Organize cache logic, expire times etc.

- Add swagger for api documentation.

- Store session tokens to shared resource eg.Redis. Make stateless api for horizontal scaling.

- Solve single point of failures.

- Absolutely increase test coverage.

- Better ui design. For simplicity i put follower, following users to dashboard but it seems odd. Better analyze of needs and improve ui design

- Design CD pipelines, docker containers, kubernetes, Cloud deployment etc.
