FROM bladex/alpine-java:openjdk8-openj9_cn_slim

MAINTAINER alita@stu.scau.edu.cn

RUN mkdir -p /intellinan/mis

WORKDIR /intellinan/mis

EXPOSE 9200

ADD ./target/aotu-man-web.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=test", "catalina.out 2>&1"]
