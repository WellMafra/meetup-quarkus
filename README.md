# Quakus
> Quarkus - Supersonic Subatomic Java

[Quakus.io](https://github.com/quarkusio/quarkus)

#### How this project was created
```jshelllanguage
mvn io.quarkus:quarkus-maven-plugin:0.19.1:create \
    -DprojectGroupId=com.meetup-quarkus \
    -DprojectArtifactId=meetup-quarkus \
    -DprojectVersion=0.0.1-SNAPSHOT \
    -DclassName="com.meetup.attendee.AttendeeResource" \
    -Dpath="/attendee" \
    -Dextensions="resteasy-jsonb, hibernate-orm-panache, jdbc-postgresql"
```

#### Running in dev mode with hot reload
```jshelllanguage
mvn compile quarkus:dev
```

#### Compiling to native image
```jshelllanguage
mvn clean install -Dnative
```