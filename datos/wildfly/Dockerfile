# Base image
FROM jboss/wildfly:16.0.0.Final
 
# Create user jota with password jota1234
RUN /opt/jboss/wildfly/bin/add-user.sh admin 12345 --silent
  
# Run
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c", "standalone.xml"]