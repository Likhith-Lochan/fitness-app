# 🏃‍♂️ Fitness App - Microservices System

This project is a full-stack **fitness tracking application** built with Spring Boot microservices, RabbitMQ messaging, OAuth2 authentication, and a modern React + Vite frontend.

---

## 🚀 Architecture Overview

```bash
.
├── activity-service/       # Tracks user activity like running, jogging
├── ai-service/             # Recommends activities via RabbitMQ messages
├── user-service/           # Manages user profile info
├── config-server/          # Centralized configuration for all services
├── server/          # Service discovery for all microservices
├── api-gateway/            # Routes frontend traffic to services securely
├── frontend-app-frontend/               # React + Vite frontend client
├── docker-compose.yml      # All services wired together in one place
