# 🧠 SmartPrep AI - Automated Study Deck Generator

Welcome to my SmartPrep API! I built this project to solve a problem I face as a student: spending too much time making flashcards instead of actually studying them. 

This is a full-stack, AI-integrated educational platform. It takes raw, unstructured text (like lecture notes) and uses Google Gemini's LLM to automatically generate structured, highly focused flashcards. I engineered the backend from scratch using Spring Boot, prioritizing security, clean data architecture, and performance tracking.

## 🛠️ Tech Stack
* **Backend:** Java 17, Spring Boot 3, Spring Data JPA, Hibernate
* **AI Integration:** Spring AI, Google Gemini LLM
* **Security:** Spring Security, JWT (JSON Web Tokens), BCrypt Password Hashing
* **Database:** PostgreSQL
* **Performance Monitoring:** Spring AOP (Aspect-Oriented Programming)

## ✨ Key Architectural Features
* **Stateless JWT Authentication:** Implemented a custom Spring Security filter chain to issue and validate time-boxed JWTs, ensuring secure, stateless API communication that can easily horizontally scale.
* **Structured AI Outputs:** Utilized Spring AI's `BeanOutputConverter` to force the Gemini LLM to return strict JSON data, mapping the unpredictable AI text directly into type-safe Java Records.
* **Bidirectional Database Mapping:** Designed relational PostgreSQL tables using `@OneToMany` and `@ManyToOne` mappings, utilizing `@JsonIgnore` to prevent infinite serialization loops during HTTP responses.
* **Non-Invasive Latency Tracking:** Deployed Spring AOP with `@Around` advice to automatically intercept and log the execution time of external AI API calls without polluting the core business logic.

## 🎯 Learning Outcomes
Building this project provided hands-on experience with enterprise-grade backend architecture and modern web security. Key takeaways include:

* **Stateless Security Architecture:** Mastered the implementation of JSON Web Tokens (JWTs) and custom Spring Security filter chains (`OncePerRequestFilter`) to build a highly scalable, stateless authentication system.
* **Applied Cryptography:** Gained practical understanding of symmetric encryption (for signing/verifying JWTs) and one-way cryptographic hashing (using BCrypt for password protection).
* **AI Output Structuring:** Learned how to safely integrate unpredictable LLMs into strictly-typed Java applications by using Spring AI's `BeanOutputConverter` to enforce predictable JSON responses from Google Gemini.
* **Aspect-Oriented Programming (AOP):** Successfully applied AOP (`@Around` advice) to decouple cross-cutting concerns, allowing for non-invasive performance and latency tracking of external API calls.
* **Advanced JPA/Hibernate Mapping:** Solved complex data serialization issues (like infinite recursion) when mapping bidirectional `@OneToMany` database relationships to RESTful JSON payloads.
