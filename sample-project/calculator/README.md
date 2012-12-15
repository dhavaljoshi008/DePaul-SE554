JEE6 Calculator

Demo to show
1)  JPA
    If using Netbeans, use jta-data-source of jdbc/sample
    If using Eclipse, use jta-data-source of jdbc/__default (or you need to create the datasource in Glassfish domain)
2)  SB
3)  MDB
    If using Glassfish, can create the necessary resources using following 2 commands
    ./asadmin create-jms-resource --restype javax.jms.QueueConnectionFactory jms/QueueConnectionFactory
    ./asadmin create-jms-resource --restype javax.jms.Queue jms/CalculatorQ

