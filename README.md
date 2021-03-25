Its a Authorization and Resource Server pair.

# Authorization Server (AS)
Authorization Server still uses legacy jar. Spring team has dropped support for authorization server they encourage to use UAA, KeyCloak or any other available AS.
They have started experimental public project for Authorization Server. 

Announcement: https://spring.io/blog/2020/05/07/end-of-life-for-spring-security-oauth.
___
# Resource Server (RS)
But They continued with Oauth resource and client support in Spring Security 5.
It uses Spring Boot Oauth Resource jar that includes all relevant jar like Oauth resource server and spring security jar.
We can choose either Spring Boot jar version or specific jar which are required for RS with matching version.
Unlike legacy version it configures resource server under "WebSecurityConfigurerAdapter".
