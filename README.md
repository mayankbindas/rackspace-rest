# rackspace-rest Test

## Running the service
To start this web service, install [Maven](https://maven.apache.org/install.html) and execute the following command

    mvn package
    
A war will be created. Deploy it to an application server.
    
Once the web service is started, it can be reached at

    http://localhost:8080/vehicle
    
## REST Endpoints
The following REST endpoints are available upon deployment:

| HTTP Verb        | URL           | Description  | Status Codes |
| ------------- |-------------|:-----| ----|
| `GET` | `http://localhost:8080/vehicle` | Obtains a list of all existing vehicles | <ul><li>`200 OK`</li></ul> |
| `GET` | `http://localhost:8080/vehicle/{id}` | Obtains the vehicle corresponding to the supplied vehicle ID | <ul><li>`200 OK` if vehicle exists</li><li>`404 Not Found` if vehicle does not exist</li></ul> |
| `POST` | `http://localhost:8080/vehicle` | Creates a new vehicle based on the payload contained in the request body | <ul><li>`201 Created` if vehicle successfully created</li></ul> |
| `PUT` | `http://localhost:8080/vehicle/{id}` | Updated an existing vehicle with the data contained in the request body | <ul><li>`200 OK` if vehicle successfully updated</li><li>`404 Not Found` if vehicle does not exist</li></ul> |
| `DELETE` | `http://localhost:8080/vehicle/{id}` | Deletes an existing vehicle that corresponds to the supplied vehicle ID | <ul><li>`203 No Content` if vehicle successfully deleted</li><li>`404 Not Found` if vehicle does not exist</li></ul> |
    