FROM midocker.azurecr.io/core-openjdk:1.0.9-11-new-relic-7.4.2
LABEL vendor="MovingIMAGE EVP GmbH"

COPY target/{{service-name}}.jar /opt/application.jar

CMD ["-jar /opt/application.jar"]