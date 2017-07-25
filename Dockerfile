FROM tomee:8-jre-7.0.3-webprofile
ENV DEPLOYMENT_DIR /usr/local/tomee/webapps
COPY ./build/libs/cards.war ${DEPLOYMENT_DIR}

RUN mkdir /sqlite-db
VOLUME /sqlite-db

ENV CATALINA_OPTS "-Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
ENV JPDA_OPTS "-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"

EXPOSE 8000