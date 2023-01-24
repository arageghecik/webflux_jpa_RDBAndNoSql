current:Nosql(mongoDB)
tag:RelationDb checking to RelationDatabase variant

app gets data from http://localhost:7634/aircraft (you need to run planefinder tag:without_cloud_strategy app or plainfinder_without_cloud_strategy)
and save it in its db

In JPA compared with redis repository we added in Aircraft
@Entity instead of @RedisHash
@GeneratedValue for id - it means id generated automatically
and @id imported from javax.persistence.Id instead of org.springframework.data.annotation.Id



it uses lomback lib\
@Data - annotation equivalent methods equals(), hashcode(), toString(), getters and setters\
@NoArgsConstructor, @AllArgsConstructor, equivalent constructor without argument and constructor with all arguments

### mongo

sudo systemctl status mongod\
sudo systemctl start mongod

for mongo you need to add this dependencies

```xml
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb-reactive</artifactId>
 </dependency>
 ```
 
 and for test (if you dosen't have local mongo db) you can add embed mongo for tests
 ```xml
  <dependency>
       <groupId>de.flapdoodle.embed</groupId>
       <artifactId>de.flapdoodle.embed.mongo</artifactId>
       <scope>test</scope>
  </dependency>
```

you have to install db(mongo,maria,postgres)\
for mongo I installed by official documentation and sudo systemctl start mongoDB\
and didn't set any login, pass, dbname, for mongo and @id annotation set by org.springframework.data.annotation.Id

it has DataLoader class with method annotated @PostConstruct which can load data to DB\
alternative way to set properties spring.datasource.initialization-mode=always, spring.jpa.hibernate.ddl-auto=none\
and to make schema-{platform}.sql or/and data-{platform}.sql and property spring.datasourse.platform(u can without platform)

you can use MongoRepository(PagingAndSortingRepository + CrudRepository), but if it is not necessary use CrudRepository
