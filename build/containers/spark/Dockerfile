FROM bitnami/spark:3.5.3

# Installs necessary jar dependencies for Spark jobs running on the cluster
USER root
RUN apt-get update && apt-get install curl -y
USER 1001
RUN curl https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-azure/3.4.0/hadoop-azure-3.4.0.jar --output /opt/bitnami/spark/jars/hadoop-azure-3.4.0.jar
RUN curl https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-common/3.4.0/hadoop-common-3.4.0.jar --output /opt/bitnami/spark/jars/hadoop-common-3.4.0.jar
RUN curl https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-aws/3.4.0/hadoop-aws-3.4.0.jar --output /opt/bitnami/spark/jars/hadoop-aws-3.4.0.jar
RUN curl https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-azure-datalake/3.4.0/hadoop-azure-datalake-3.4.0.jar --output /opt/bitnami/spark/jars/hadoop-azure-datalake-3.4.0.jar
RUN curl https://repo1.maven.org/maven2/io/delta/delta-storage/3.2.1/delta-storage-3.2.1.jar --output /opt/bitnami/spark/jars/delta-storage-3.2.1.jar
RUN curl https://repo1.maven.org/maven2/io/delta/delta-spark_2.12/3.2.1/delta-spark_2.12-3.2.1.jar --output /opt/bitnami/spark/jars/delta-spark_2.12-3.2.1.jar
RUN curl https://repo1.maven.org/maven2/org/apache/commons/commons-configuration2/2.9.0/commons-configuration2-2.9.0.jar --output /opt/bitnami/spark/jars/commons-configuration2-2.9.0.jar
RUN curl https://repo1.maven.org/maven2/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar --output /opt/bitnami/spark/jars/postgresql-42.6.0.jar
RUN curl https://repo1.maven.org/maven2/net/sourceforge/jtds/jtds/1.3.1/jtds-1.3.1.jar --output /opt/bitnami/spark/jars/jtds-1.3.1.jar