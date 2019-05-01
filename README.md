# pcc-hello-world-example
Sample "Hello World" Spring Boot application to work with Pivotal Cloud Cache(PCC)


## How to build

Run with `./gradlew build` to compile the application.

## How to run

#### On Pivotal Cloud Foundry (PCF)
This application can be `cf push`ed with the `manifest.yaml` present in the root directory.

Once the application is `cf push`ed you can access the URL `/hello` to view the simple output.

#### On local environment
Please start a local Geode cluster using `gfsh` CLI tool. Once you have at min one locator and 
server running, you can run the application locally using `./gradlew bootRun`  

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

- `@Region` - This annotation is used to define the object which will be pushed into the `Region` in 
PCC.

- `@EnableGemFireCaching` - Chooses PCC/GemFire as a Caching Provider. 
  
