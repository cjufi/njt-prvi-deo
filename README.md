## pom.xml dependencies

```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>7.0.7</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.7.0</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>7.0.7</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.5.2.Final</version>
        </dependency>

        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.1.0</version>
        </dependency>

        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>org.eclipse.persistence.jpa</artifactId>
            <version>4.0.2</version>
        </dependency>
        
    </dependencies>
```

## hibernate.cfg.xml
```xml
 <?xml version='1.0' encoding='UTF-8'?>  
<!DOCTYPE hibernate-configuration PUBLIC  
   "-//Hibernate/Hibernate Configuration DTD 5.3//EN"  
   "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">  

<hibernate-configuration>  
   <session-factory>  
      <property name="hbm2ddl.auto">none</property>  
      <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>  
      <property name="connection.url">jdbc:mysql://localhost:3306/{{naziv_baze}}</property>  
      <property name="connection.username">root</property>  
      <property name="connection.password"></property>  
      <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property> 
      <mapping class="rs.ac.bg.fon.njt.njt_11_05_2026.domain.Izdavac"/>
      <mapping class="rs.ac.bg.fon.njt.njt_11_05_2026.domain.Pisac"/>
      <mapping class="rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga"/>
   </session-factory>  
</hibernate-configuration>
```
