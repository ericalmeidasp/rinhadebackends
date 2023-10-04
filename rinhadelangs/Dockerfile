FROM alpine AS build
RUN mkdir -p /home/app
COPY ./pom.xml /home/app
COPY ./ /home/app

RUN wget -O /etc/apk/keys/amazoncorretto.rsa.pub  https://apk.corretto.aws/amazoncorretto.rsa.pub
RUN echo "https://apk.corretto.aws/" >> /etc/apk/repositories
RUN apk update
RUN apk add amazon-corretto-21

RUN apk add maven

RUN mvn -f /home/app/pom.xml clean package

COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx900m","-Xms650m","/usr/local/lib/app.jar"]
