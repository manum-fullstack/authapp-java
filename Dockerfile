FROM tomcat:9.0-jdk17

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Render provides PORT dynamically
ENV PORT=8080

# Tell Tomcat to use Render's PORT
ENV CATALINA_OPTS="-Dserver.port=${PORT}"

EXPOSE 8080

CMD ["catalina.sh", "run"]