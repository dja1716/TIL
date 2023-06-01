### one of SOLID prinfiples of object-oriented programming
- The **Single-responsibility principle**: "There should never be more than one reason for a class to change". In other words, every class should have only one responsibility
- The **Open-closed principle**: "Software entities ... should be open for extension, but closed for modification"
- The **Liskov substitution principle**: "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it
- The **Interface segregation principle**: "Clients should not be forced to depend upon interfaces that they do not use
- the **Dependency inversion prinvicple**: "Depend upon abstractions, [not] concretions"
- reference: https://en.wikipedia.org/wiki/SOLID#:~:text=The%20SOLID%20concepts%20are,%2C%20but%20closed%20for%20modification.%22

# Understanding dependency injection - ANGULAR
- Dependency injection, or DI, is one of the fundamental concepts in Angular
- Two main roles exist in the DI system: dependency consumer and dependency provider.
- Angular facilitates the interaction between dependency consumers and dependency providers using an abstraction called Injector
- When a dependency is requested, the injector checks its registry to see if there is an instance already available there. If not, a new instance is created and stored in the registry
- Angular creates an application-wide injector (also known as "root" injector) during the application bootstrap process, as well as any other injectors as needed.
- An object in the Angular dependency-injection system that can find a named dependency in its cache or create a dependency using a configured provider
- reference: https://angular.io/guide/dependency-injection

# NestJS and Dependency Injection
- **controllers** - usually responsible for getting http requests from the particular route and invocation of domain specific services and preparation http responses
- **services** - the main business unit and it's intermediate layer between controllers and repositories
- **repositories** - responsible for communication with any persistent layer, it may be either any relational DB (Postgres, MySQL) or NoSQL DB (MongoDB, Redis)
- reference: https://medium.com/geekculture/nestjs-and-dependency-injection-3ce0886148c4

# Nest js document
- When the application is bootstrapped, every dependency must be resolved, and therefore every provider has to be instantiated
- To use dependency injection in NestJS, you need to follow these steps:
  1. Create a provider: A provider is a class that creates and manages a particular type of object. You can create a provider by adding the @Injectable() decorator to a class
  2. Register the provider: You need to register the provider with the DI container. You can do this by adding the provider to the providers array of a module or by using the @Injectable() decorator to specify the provider's scope.
  3. Inject the provider: You cna now inject the provider into other classes that require its functionality. You can do this by using the @Inject() decorator or by adding the provider as a constructor parameter

- ways to implements injection (class-based injection / property-based injection / factory providers)
- By default, providers in NestJS are singleton-scoped, which means that the DI container creates only one instance of each provider and shares it across the entire application
