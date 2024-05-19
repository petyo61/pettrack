## Comments On Pet Tracking Application task.

### Requirements part:
A lot is defined in freetext before this section, that might be an intended hardening of the task. In real work this is not acceptable.

1. "pet tracking data" is not defined. The requirement is not specifying what data will be sent to the API. Of course in real word application it should be.
2. "Entity" usually is the piece of data that gets stored in the DB. Since this application does not expose the DB, it is considered an implementation detail, not a requirement. In any good design entity is separated from the DTO that is handled by the API. Exposing entities is a security risk and design antipattern. So defining an "Entity" only implicitly defines the REST API DTO. You want an app receiving data, but you don't specify what the data will be.
3. Again enforces an implementation detail that is irrelevant. Here we seee that we are supposed to create a hierarchy of entities for nothing. the whole pet-dog-cat family will be represented by one table anyway. Validation of data depending on pet type can be done many ways the inheritance does not help in that.
4. "received pet count data" is I hope intentionally ambiguous. Up to this point there was no word about "pet count data" we don't know what it could mean. One thing seems to be clear that we will not get "count" like data at all. Otherwise, it should be specified somewhere.
5. Tests are good if we have a clear requirement. How could a test "ensure correctness" when we don't specify what correct is?
6. Tests are usually executed as a part of the build phase. Every build system has different ways to execute tests separately. Should we document here the build system?

"We don't expect you to work more 2-3 hours..." is an insult. From zero setting up an empty Spring Boot app, make it build with dependencies and commit to a fresh GIT repo is alone more than 2 hour due to unforeseeable obstacles. It is only possible if someone starts a new Spring Boot app daily, and routinely. There is no such person on this planet.

"Note: Feel free to reach out..." another insult. In that 2 hours? How? You don't even mention any way to access you.
