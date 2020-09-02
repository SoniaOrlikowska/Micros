https://hub.docker.com/_/maven

Build a docker image

```bash
docker build -t quiz-java-app .
```

Run a container with the image and issue the container an instruction to build the project with Maven

```bash
docker run --rm --mount type=bind,source="$(pwd)",target="/usr/src/" quiz-java-app mvn clean install
```

Once finished run the app

```bash
java -jar target/Micros-1.0-SNAPSHOT.jar
```
