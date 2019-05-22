# pcc-hello-world-example
Sample "Hello World" Spring Boot application to work with Pivotal Cloud Cache(PCC)


## Build the App

With a current working directory of `pcc-hello-world-example`,
build the app with:

```
$ ./gradlew build
```

## Run the App

There are two options for running the app: locally and with PCC in
a PCF environment.

#### Run the App Locally with Apache Geode

To run the app locally, follow these steps:

1. Acquire and build or install Apache Geode (https://geode.apache.org/)
in order to use gfsh.

2. Run gfsh.

3. Start a minimal pool which includes one locator and one server.
The server must listen on port 40404.

    ```
    gfsh>start locator --name=loc1
    ```

    ```
    gfsh>start server --name=s1 --server-port=40404
    ```

4. In a second shell, with a current working directory of
`pcc-examples/pcc-hello-world-example`,
run the app:

    ```
    $ ./gradlew bootRun
    ```
5. In a web browser, enter either of the two REST endpoints.

    - `localhost:8080/` should return `PONG`. 
    - `localhost:8080/hello` should return the string
    `Key: HelloWorld cached with value: XXXXXXXXXXXXXXXX`,
    where `XXXX` will be replaced by the system time when the key/value
    pair was cached. 

6. Use a control-C to stop the app when finished.
To shut down the Geode cluster, run the gfsh command:

    ```
    gfsh>shutdown --include-locators=true
    ```

#### On Pivotal Cloud Foundry (PCF)

This application can be `cf push`ed with the `manifest.yml` present in the root directory.

There are have two options for running the app within the PCF environment.

**Modify the Manifest and Do a `cf push`**

1. Append your PCC service name to the `manifest.yml` file,
replacing `PCC-SERVICE-NAME` with the name of your PCC service instance,
such that the `manifest.yml` file contains:

    ```
    ---
    applications:
      - name: hello-world-pcc
        path: ./build/libs/demo-1.0.0-M1.jar
        services:
          - PCC-SERVICE-NAME
    ```

2. `cf push`, and note the app URL.

**`cf push`, Bind, and Restage the APP**

1. `cf push --no-start` to push the app without starting,
and note the app URL.
2. `cf bs hello-world-pcc <service instance name>` to bind the service to app
3. `cf restage hello-world-pcc` to start with service

Once the application is running, 
in a web browser, enter either of the two REST endpoints,
replacing `APP-URL` with your app's URL.

- `APP-URL/` should return `PONG`. 
- `APP-URL/hello` should return the string
`Key: HelloWorld cached with value: XXXXXXXXXXXXXXXX`,
where `XXXX` will be replaced by the system time when the key/value
pair was cached. 

## Explanation of REST Endpoints

This is a Spring Boot application which has 2 REST endpoints

1. `/` - landing page url. Returns the string `Pong`.
2. `/hello` - Hits a service which retrieves the `HelloWorld` key with
its value, a timestamp. If the `HelloWorld` key has not yet been cached
(a cache miss),
the current time is obtained to be used as the value.
The key/value pair is placed into the cache.
And, subsequent uses of this endpoint return the cached value.



## How the application works

Spring Boot helps us create most of bits necessary to run this application with a 
Pivotal Cloud Cache(PCC) cluster.
Few annotation to notice

- `@SpringBootApplication` - This will help developer not to make any more configuration that 
might be required to run this application as a jar on the container

- `@Cacheable` - This annotation helps developer indicate that the method `sayHelloWorld()` 
will be cached with the name specified on the annotation.

- `@Service` - This annotation on class `HelloWorldService` makes the class condidate for spring 
component scanning

#### PCC Specific Annotations 

- `@EnableClusterConfiguration(useHttp = true)` - This annotation indicates that the configuration 
that will be created in a PCC cluster would be saved using `ClusterConfigurationService`, a concept 
in PCC. We dont need to dig into it more here, but it will use http protocol to send the 
configurations needed from this application to PCC cluster.

- `@EnableCachingDefinedRegions` - This annotation will ensure that `Region`( a concept in PCC which 
is analogus to `Map`), will be created based on Spring Caching abstraction.
 
  
### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Official Pivotal Cloud Cache documentation](https://docs.pivotal.io/p-cloud-cache/1-7/app-development.html)
* [Official Spring Boot Data Geode documentation](https://docs.spring.io/autorepo/docs/spring-boot-data-geode-build/1.0.0.BUILD-SNAPSHOT/reference/htmlsingle/#geode-autoconfiguration-annotations-extension-caching)

### Guides
The following guides illustrate how to use some features concretely:

* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Pivotal GemFire - details of Cluster Configuration](http://gemfire.docs.pivotal.io/98/geode/configuring/cluster_config/gfsh_persist.html)

