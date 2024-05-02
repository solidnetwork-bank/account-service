# account-service

# REMEMBER UPDATE VERSION
- pom.xml
- README
- commit
- tag


# Generate Jar before build
````
./.mvn/mvnw -B package --file pom.xml
````

# build
````
docker build -t "solidnetworkxyz/account-service:1.2" .
````

# run
````
docker run --rm -it -p 80:80 solidnetworkxyz/account-service:1.2
````
# login
````
docker login -u solidnetworkxyz
````

# push
````
docker push solidnetworkxyz/account-service:1.2
````

