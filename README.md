# account-service

# REMEMBER UPDATE VERSION
- pom.xml
- README
- commit
- tag


# Generate Jar before build
````
./.mvn/mvnw clean install
````

# build
````
docker build -t "solidnetworkxyz/account-service:1.3" .
````

# run
````
docker run --rm -it -p 80:80 solidnetworkxyz/account-service:1.3
````
# login
````
docker login -u solidnetworkxyz
````

# push
````
docker push solidnetworkxyz/account-service:1.3
````

