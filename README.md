# ReviewsDownloader
Simple application that downloads some data from a public api and shows them to the user, allowing him to perform some basic operation on the data. This is an assignment to complete in a fixed amount of time (some hours) so some features have just been sketched.

### What the app does
This app simply downloads some reviews of a travel experience and allows to control the sorting of the reviews by rating.

### How to build the project
The project has been created with Android Studio thus it has the structure of a standard Android project. Nothing particular is required in order to run it: just clone the repo, import it with Android Studio and run the application.

### Generate a release apk
In order to be able to have a release apk you can either update the proguard file by adding the missing libraries or disable proguard.

### Todos
- Add more filters and parameters to the search
- Add pagination to the search
- Add proguard exception for the libraries used
- Change dimensions of some parameters basing on different screen dimensions
- Package fix