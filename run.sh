HADOOP_CLIENT_DIR=/opt/cloudera/parcels/CDH/lib/hadoop/client/
HIVE_LIB_DIR=/opt/cloudera/parcels/CDH/lib/hive/lib
IMPALA_LIB_DIR=/opt/cloudera/parcels/CDH/lib/impala/lib



CLASSPATH=$CLASSPATH:./cloudera-impala-1.0.jar

java -cp $CLASSPATH com.linage.transform.ClouderaImpala
sh hj_tranlog_transform.sh > output.log
