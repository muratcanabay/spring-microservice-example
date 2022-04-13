# Table of Contents
- [Overview](#Overview)
- [Application List](#ApplicationList)
- [URLs](#URL)
- [Errors](#Error)

# Overview
Spring Boot based project to demonstrate microservice implementation.
Centralized Config Server retrieves properties from git repository: [Config Repository](#https://github.com/muratcanabay/config-repo)

### Spring Profile
Switch profile between **dev/test** to see the change in api-limit-service properties file.

### [Application List](#ApplicationList)

|          Application       |       Port        |
| -------------------------- | ----------------- |
|         Limits Service     |        1000       |
| Spring Cloud Config Server |        8888       |

### [URLs](#URL)

|                      URL                        |                      Description                    |
| ----------------------------------------------- | --------------------------------------------------- |
| http://localhost:1000/limits                    |                ***Api Limit Service***              |
|                                                 |                                                     |
| http://localhost:8888/api-limit-service/test    |          ***Config Server Test Properties***        |
| http://localhost:8888/api-limit-service/dev     |        ***Config Server Development Properties***   |

### [Errors](#error)
#### In case of ***java: variable first not initialized in the default constructor***

Make sure to Enable Lombok Annotation Processing