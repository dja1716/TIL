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
## injector
- An object in the Angular dependency-injection system that can find a named dependency in its cache or create a dependency using a configured provider
## reference: https://angular.io/guide/dependency-injection
