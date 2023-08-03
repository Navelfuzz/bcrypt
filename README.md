# Lab: Class 14

## Auth with Bcrypt

### Resources
[jBCrypt](https://www.mindrot.org/projects/jBCrypt/)

```
// Hash a password for the first time
String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

// gensalt's log_rounds parameter determines the complexity
// the work factor is 2**log_rounds, and the default is 10
String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

// Check that an unencrypted password matches one that has
// previously been hashed
if (BCrypt.checkpw(candidate, hashed))
System.out.println("It matches");
else
System.out.println("It does not match");
```

Create a server to protect site content by requiring users to sign up for an account and log in. 
Users should only be able to see the protected areas of site after they’ve logged in and established an 
authenticated session.

Create the authentication system for this server on your own. Do not use Spring’s own built-in auth system.

Display a user’s username somewhere on the page to indicate to a user that they’re logged in.

Use `Bcrypt` to hash and check user passwords. Make sure not to return user’s passwords or their hashes, 
if you return user information in the response to any request.

### Gotchas
Do not code this in any of your existing projects. Otherwise, you will have to remove this authentication code 
later when you do the Spring Security labs, which has historically proven quite tricky.

Do not create a class named “User” for this project. If you do, Hibernate will be very unhappy with you 
when you try to save it to the database.

___

## Feature Tasks

* Create a database.
* Create a table that models users with a username, id, and hashed password.
* Create a table that models posts with a postId, userId and text content.
* Create a table with a 1-to-many relationship between users and posts.
* Create login/signup page.
* Authenticate the site so only logged-in users can see posts.
* Unauthenticated users accessing protected areas of site should be redirected to login/signup page.
* Use Bcrypt to hash all passwords stored on the site.
