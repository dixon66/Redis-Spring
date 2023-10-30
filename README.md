# Redis-Spring
Understanding system design concept by getting started on [Caching](https://genesis.hashnode.dev/caching-enhancing-performance-and-scalability) /[blog2](https://genesis.hashnode.dev/application-caching-in-spring-quick-introduction)

# Overview



https://github.com/dixon66/Redis-Spring/assets/52631366/850b2bf9-d3d1-42ea-b7ac-4143802eb64f

Caching is a pivotal component in system design that significantly influences the performance and scalability of applications. In this blog, we'll delve into details of caching, its types, eviction strategies, and cache consistency, all with real-world examples and Java Spring. Let's understand how caching optimizes your system.

## **Table of Contents**

1. **How It Works: An Overview of Caching**
    
    * Caching Fundamentals
        
    * Benefits of Caching
        
    * When to Use Caching
        
2. **Types of Caching**
    
    * Application Caching
        
    * Browser Caching
        
    * Distributed Caching
        
    * Global Cache
        
    * Content Delivery Network (CDN)
        
    * Database Query Caching
        
    * In-Memory Caching (e.g., Redis, Memcached)
        
3. **Cache Invalidation: Managing Stale Data**
    
    * Write Through Cache
        
    * Write Around Cache
        
    * Write Back Cache
        
4. **Cache Eviction Strategies: Making Space for New Data**
    
    * Refresh-Ahead
        
    * Least Recently Used (LRU)
        
    * Least Frequently Used (LFU)
        
    * Most Recently Used (MRU)
        
    * Random Replacement
        

## **How It Works: An Overview of Caching**

### **Caching Fundamentals**

Caching is the process of storing frequently accessed data in a high-speed data storage layer, reducing the need to fetch the data from the original source. It can be a database, a web service, or any other data repository. Caching works on the principle of fetching data once and serving it from the cache for subsequent requests.

### **Benefits of Caching**

Caching offers several advantages:

* **Faster Response Times**: Cached data retrieval is much quicker than fetching from the source, resulting in faster response times for users.
    
* **Reduced Load on Resources**: It eases the load on the data source, ensuring it doesn't get overwhelmed with frequent requests.
    
* **Improved Scalability**: Caching can be distributed, making it easier to scale your application horizontally.
    
* **Enhanced Reliability**: Cached data can act as a backup, ensuring system availability even if the original source experiences downtime.
    

### **When to Use Caching**

Caching is invaluable in scenarios where data access is a bottleneck. Use it when:

* Data doesn't change frequently.
    
* Data is costly to compute or retrieve.
    
* Frequent data requests impact system performance.
    

In the next sections, we'll explore different types of caching and delve into cache invalidation strategies.

## **Disadvantages of Caching**

While caching brings substantial benefits to a system, it's important to be aware of its limitations:

* **Potential Stale Data**: Caching introduces the risk of serving outdated or stale data, especially if the cache is not properly managed or invalidated.
    
* **Increased Complexity**: Implementing caching adds complexity to the system, requiring careful consideration of cache synchronization and invalidation strategies.
    
* **Memory Overhead**: In-memory caching solutions like Redis or Memcached may consume a significant amount of RAM, potentially limiting the amount of data that can be cached.
    
* **Cache Coherency**: In distributed environments, maintaining cache coherency across multiple nodes can be challenging and may require additional synchronization mechanisms.
    

## **When Not to Use Caching**

While caching is a powerful tool, there are scenarios where it may not be the best solution:

* **Highly Dynamic Data**: If the data changes rapidly and frequently, caching may lead to a high rate of stale data, rendering it less effective.
    
* **Limited Available Memory**: In situations where memory resources are constrained, caching may not be feasible, as it could lead to performance degradation or even system crashes.
    
* **Security Concerns**: Caching sensitive or confidential information may pose security risks if the cache is not adequately protected or encrypted.
    
* **Small-scale Applications**: For small-scale applications with minimal traffic and low data access latency, the overhead of implementing caching may outweigh the benefits.
    

## **Types of Caching**

### **Application Caching**

[Application caching](https://genesis.hashnode.dev/application-caching-in-spring-quick-introduction?ref=twitter-share) involves storing data within an application's memory to optimize data retrieval. Java Spring provides a robust framework for implementing application caching. to know more click

#### Java Spring Code Example

```plaintext
// Define a simple cache
@Cacheable("myCache")
public MyData retrieveData(String key) {
    // Logic to fetch data
}
```

### **Browser Caching**

Browser caching stores web page assets like images, scripts, and styles locally on the user's device. This reduces the need for repeated downloads and speeds up page loading.

### **Distributed Caching**

Distributed caching spans multiple servers, enabling data sharing and load balancing across applications.

### **Global Cache**

Global caching involves a centralized cache accessible across all application instances.

### **Content Delivery Network (CDN)**

CDNs cache content geographically closer to users, ensuring fast content delivery.

### **Database Query Caching**

Database query caching stores frequently used SQL query results to optimize database access.

### **In-Memory Caching**

In-memory caching systems like Redis and Memcached store data in RAM, ensuring blazing-fast data retrieval.

### Page caching

Saving a webpage's final rendered content so that it can be quickly delivered to subsequent visitors without the need to reprocess or regenerate the page.

### Object Caching

Storing the results of expensive computations, database queries, or other operations in memory or a cache store. This technique is commonly used to improve the performance of applications by reducing the time it takes to access frequently requested data.

In the upcoming sections, we'll discuss cache invalidation and eviction policies.

## **Cache Invalidation: Managing Stale Data**

Cache invalidation is the process of removing or updating cached data to maintain data consistency.

### **Write Through Cache**

A write-through cache writes data both to the cache and the underlying data source, ensuring data consistency.

### **Write Around Cache**

A write-around cache writes data only to the underlying data source, skipping the cache. Useful for infrequently accessed data.

### **Write Back Cache**

A write-back cache initially writes data to the cache and later synchronizes it with the underlying data source.

## **Cache Eviction Strategies: Making Space for New Data**

Cache eviction strategies decide which data to remove from the cache when it reaches its capacity.

### **Refresh-Ahead**

Refresh-ahead involves pre-fetching data before it expires, reducing the chances of serving stale data.

### **Least Recently Used (LRU)**

LRU removes the least recently accessed data from the cache when it reaches capacity.

### **Least Frequently Used (LFU)**

LFU removes the least frequently accessed data from the cache.

### **Most Recently Used (MRU)**

MRU keeps the most recently accessed data in the cache.

### **Random Replacement**

Random replacement evicts data randomly from the cache.

## **Conclusion**

Caching enhances the performance and scalability of systems. By implementing the right caching strategy and eviction policy, you can significantly improve your application's responsiveness. Understanding caching is a fundamental skill for any technical professional.

In your system design journey, remember that caching is your ally in achieving fast, responsive, and reliable applications.

---

Application caching in Spring allows you to store frequently accessed data in memory, reducing the need to fetch it from the source every time. This can significantly improve the performance of your application.

### **Java Spring Code Example**

```java
// Import necessary libraries
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    // Define a cache named "userData"
    @Cacheable(value = "userData", key = "#userId")
    public UserData getUserData(int userId) {
        // Simulate fetching data from a database
        // Replace this with your actual data retrieval logic
        return fetchDataFromDatabase(userId);
    }

    private UserData fetchDataFromDatabase(int userId) {
        // Simulate database query
        // Replace this with your actual database query
        System.out.println("Fetching data from database for user ID: " + userId);
        // Assuming this method returns UserData object
        return new UserData(userId, "John Doe");
    }
}
```

In this example, we're creating a `DataService` class that contains a method `getUserData(int userId)`. This method is annotated with `@Cacheable` which indicates that the result of this method should be cached.

* `@Cacheable(value = "userData", key = "#userId")`: This annotation specifies that the method's result should be cached. The `value` attribute represents the name of the cache (in this case, "userData"). The `key` attribute specifies how to generate the cache key, in this case, it's based on the `userId`.
    
* `fetchDataFromDatabase(int userId)`: This is a simulated method that fetches data from a database. In a real-world scenario, this is where you would perform your actual data retrieval logic.
    

### **Explanation**

1. When `getUserData(int userId)` is called for the first time with a specific `userId`, Spring checks if there's already a cached result for the given `userId`.
    
2. If there's a cache hit (i.e., the result is already cached), Spring returns the cached result without executing the method.
    
3. If it's a cache miss (i.e., the result is not cached), Spring executes the method `fetchDataFromDatabase(int userId)`.
    
4. The result is returned and cached using the specified cache name ("userData") and cache key (based on the `userId`).
    
5. Subsequent calls with the same `userId` will retrieve the result from the cache without executing the method again.
    

### **Important Notes**

* Ensure you have a caching provider configured in your Spring application (e.g., using Redis or Ehcache).
    
* Make sure to handle cache eviction and cache invalidation based on your application's requirements.
    

This example demonstrates how Spring's caching mechanism can be employed to efficiently handle frequently accessed data. Replace the simulated database access with your actual data retrieval logic.

## **Simple Application Caching Example with Spring**

For this example, let's imagine we have a service that fetches user details by their ID from a database. We want to use caching to improve the performance of this operation.

### **Step 1: Set Up a Spring Boot Project**

1. Create a new Spring Boot project using Spring Initializer ([https://start.spring.io/](https://start.spring.io/)).
    
2. Add the dependencies for "Spring Web" and "Spring Cache" to your project.
    

### **Step 2: Enable Caching in Your Application**

Open your main application class (usually [`Application.java`](https://start.spring.io/)) and add `@EnableCaching` annotation to enable caching in your Spring application:

```java
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### **Step 3: Create a Service Class**

Next, create a service class that will contain the method we want to cache. In this case, let's create a class named `UserService`.

```java
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(value = "userData", key = "#userId")
    public UserData getUserData(int userId) {
        // Simulate fetching data from a database
        return fetchDataFromDatabase(userId);
    }

    private UserData fetchDataFromDatabase(int userId) {
        // Simulate database query
        System.out.println("Fetching data from database for user ID: " + userId);
        return new UserData(userId, "John Doe");
    }
}
```

### **Step 4: Create a Model Class**

Create a simple `UserData` class to represent user data.

```java
public class UserData {
    private int id;
    private String name;

    // Constructor, getters, and setters
    // ...
}
```

### **Step 5: Create a Controller**

Create a controller class to handle HTTP requests.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public UserData getUserData(@PathVariable int userId) {
        return userService.getUserData(userId);
    }
}
```

### **Step 6: Run and Test**

Start your Spring Boot application and make GET requests to [`http://localhost:8080/user/{userId}`](https://start.spring.io/) (replace `{userId}` with an actual user ID).

### **How It Works**

1. When you make a request to get user data, Spring will first check the cache named "userData" to see if the data for the given user ID is already available.
    
2. If found in the cache, Spring will return the cached data directly, without executing the method.
    
3. If not found in the cache, the method `getUserData` will be executed, which will simulate fetching data from a database.
    
4. The retrieved data will be cached using the specified cache name ("userData") and cache key (based on the user ID).
    
5. Subsequent requests with the same user ID will retrieve the result from the cache without executing the method again.
    

To add a caching provider like Redis to your Spring Boot application, you'll need to follow specific steps for each provider.(likely you can add Ehcache or Hazelcast to spring)

**Adding Redis as the Caching Provider**

#### Step 1: Add Redis Dependencies

Open your `pom.xml` file and add the following dependencies for Redis:

```plaintext
<dependencies>
    <!-- Other dependencies -->

    <!-- Add Redis Dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
</dependencies>
```

#### Step 2: Configure Redis in [`application.properties`](https://start.spring.io/) or `application.yml`

Open your [`application.properties`](https://start.spring.io/) or `application.yml` file and add the following properties to configure Redis:

For [`application.properties`](https://start.spring.io/):

```plaintext
propertiesCopy code# Redis Configuration
spring.redis.host=localhost
spring.redis.port=6379
```

For `application.yml`:

```yaml
yamlCopy code# Redis Configuration
spring:
  redis:
    host: localhost
    port: 6379
```

These configurations assume that Redis is running on the local machine with the default port (6379). Adjust the properties as needed for your specific Redis setup.

#### Step 3: Enable Caching

If you've already added `@EnableCaching` to your main-application class (as in the previous example), you're all set.

#### Step 4: Test with Redis

Now, when you run your Spring Boot application, it will use Redis as the caching provider.

### **Caching Annotations:**

1. **@Cacheable**:
    
    * Indicates that a method's result should be cached for a specific cache name.
        
    * If the same method is called again with the same arguments, the cached result is returned instead of re-executing the method.
        
    
    Example:
    
    ```java
    @Cacheable(value = "userData", key = "#userId")
    public UserData getUserData(int userId) {
        // ...
    }
    ```
    
2. **@CachePut**:
    
    * Forces a method to execute and update the cache with the result.
        
    * It's used for scenarios where you want to ensure that a method always updates the cache.
        
    
    Example:
    
    ```java
    @CachePut(value = "userData", key = "#userId")
    public UserData updateUser(int userId, UserData newData) {
        // ...
    }
    ```
    
3. **@CacheEvict**:
    
    * Removes entries from the cache.
        
    * It's used when you want to explicitly evict (invalidate) cached entries.
        
    
    Example:
    
    ```plaintext
    @CacheEvict(value = "userData", key = "#userId")
    public void deleteUser(int userId) {
        // ...
    }
    ```
    
4. **@Caching**:
    
    * Allows multiple caching annotations to be applied to the same method.
        
    
    Example:
    
    ```java
    @Caching(
        cacheable = @Cacheable(value = "userData", key = "#userId"),
        put = @CachePut(value = "userData", key = "#userId")
    )
    public UserData getUserData(int userId) {
        // ...
    }
    ```
    

### **Cache Manager Methods:**

1. **getCache(String name)**:
    
    * Retrieves the named cache.
        
    
    Example:
    
    ```java
    Cache userDataCache = cacheManager.getCache("userData");
    ```
    
2. **getCacheNames()**:
    
    * Returns the names of all caches.
        
    
    Example:
    
    ```java
    Set<String> cacheNames = cacheManager.getCacheNames();
    ```
    

### **When to Use These Annotations and Methods:**

1. **@Cacheable**:
    
    * Use when you want to cache the result of a method that has expensive computation or database access.
        
    * It's suitable for read-heavy operations where the data doesn't change frequently.
        
2. **@CachePut**:
    
    * Use when you want to ensure a method always updates the cache, regardless of whether the result was previously cached.
        
3. **@CacheEvict**:
    
    * Use when you want to explicitly evict (invalidate) cached entries, such as after a data update or deletion.
        
4. **@Caching**:
    
    * Use when you want to apply multiple caching annotations to the same method.
        
5. **Cache Manager Methods**:
    
    * Use when you need to interact with the cache manager programmatically, for example, to retrieve a specific cache or get a list of cache names.
        

### **Example Usage:**

```java
@Cacheable(value = "userData", key = "#userId")
public UserData getUserData(int userId) {
   // Simulate fetching data from a database
   return fetchDataFromDatabase(userId);
}

@CachePut(value = "userData", key = "#userId")
public UserData updateUser(int userId, UserData newData) {
   // Simulate updating data in a database
   return updateDataInDatabase(userId, newData);
}

@CacheEvict(value = "userData", key = "#userId")
public void deleteUser(int userId) {
   // Simulate deleting data from a database
   deleteDataFromDatabase(userId);
}
```

In this example, `getUserData` fetches user data from a database and caches the result. `updateUser` updates the user data in the database and ensures that the cache is updated. `deleteUser` deletes the user data from the database and evicts it from the cache.

---

### More

###   
In the `@Cacheable` annotation you provided:

```java
javaCopy code@Cacheable(key = "#id", value = "Product", unless = "#result.price < 1000")
public Product findProduct(@PathVariable int id) {
    return productService.findProductById(id);
}
```

* `key = "#id"`: This specifies that the `id` parameter of the method will be used as the cache key. This means that if the method is called with the same `id`, it will return the cached result if available.
    
* `value = "Product"`: This indicates the name of the cache where the result will be stored. In this case, it's set to "Product".
    
* `unless = "#result.price < 1000"`: This is a condition that, if evaluated to `true`, will prevent the result from being cached. In this case, it means that if the `price` of the returned `Product` is less than 1000, the result won't be cached.
    
    * `#result`: This is a SpEL (Spring Expression Language) expression referring to the return value of the method. In this case, it refers to the `Product` object returned by `findProductById(id)`.
        
    * `#result.price < 1000`: This is a condition in SpEL. It checks if the `price` of the returned `Product` is less than 1000.
        

Putting it all together, this `unless` condition means that if the `Product` returned has a price less than 1000, the caching won't be applied, and the method will be executed every time it's called with that `id`.

For example, if you have a product with a price of 800, it won't be cached because it meets the condition `#result.price < 1000`. However, if you have a product with a price of 1200, it will be cached and subsequent calls with the same `id` will return the cached result without executing the method.

---


[Sharding](https://aws.amazon.com/blogs/database/sharding-with-amazon-relational-database-service/) is a database optimization technique for achieving horizontal scalability in databases, instead of increasing the size of the database we can split the database (existing database) into smaller ones this is the concept of sharding. Sharding can also be said as a specific type of partitioning, this is about horizontal sharding (not vertical sharding), only horizontal sharding is applicable for scaling large databases. **In short horizontal sharding is the optimization technique that splitting one large database into multiple small databases so that now instead of having one big database we have smaller individual ones and each of those can have the same hardware setup thus getting more performance and more data storage.**

**Optimization techniques before Sharding:**

1. **Scaling up the Hardware -**  there is a limit as increasing the RAM/CPU/hardware components has a limit and its cost to too much and with an increase in components the performance need not increase linearly or whatever because there is a limit to the load system can handle.
    
2. **Add replicas of the same database/ duplicates -**  say we have 3 instances of same database one master and 2 slaves. Every write operation is performed on the master and all read operation is done on the slave database in this way the load is balanced, but with this comes the problem of consistency, every time the write operation is done on the master it has to update all its slave. There may be delays and data is not consistent across the database.
    
3. **Finally SHARDING –** splitting one full data base into small databases say using the most unique key possible. For example we have a customer table with attributes of csut\_id,cust\_namr,cust\_points. Cust\_id will be the most unique key and using that instead of having all the data in a single database this is split into different databases say from cus\_id from 1-3 is on one database, 4-6 on second instance of database, 7-9 is another database. Now we have different database for the same table it becomes mandatory to have a **hashing function (**which maps the correct customer request to the correct database table**) or a Routing interface/layer that maps to the correct customer request to the correct database table. THIS IS CALLED A INTERMEDIARY layer(**which is between the application layer and database layer**). This process forces to have this layer**
    

**Pros:**

1. **Infinite horizontal scalability**
    

1. **Availability & Fault tolerance** – even If one set or one database goes down (1-3) the other database still exists so the application runs.
    

       **Cons:**

1. **Complexity – pattern Mapping**
    

1. **Interaction layer/ intermediary layer**
    
2. **Non-uniformity -  say the data is sharded based on the customer but we have one client who is very big and not held in a single** sharded **database in this case for the same customer resharding is required**
    

**4.** **Make queries complicated – say we need to get all the customer data the query has to go through all the database and its tables so the intermediatory layer or routing layer needs to know where all this is located and querry should have  logic to a. perform the query, summarize, c. aggregate and send back**

---

For demo [GitHub](https://github.com/dixon66/Redis-Spring). Have fun learning🚀!!

[Consistent hashing](https://www.toptal.com/big-data/consistent-hashing)
