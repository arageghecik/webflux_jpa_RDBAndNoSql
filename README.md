current:Nosql(mongoDB)
tag:RelationDb checking to RelationDatabase variant

app gets data from http://localhost:7634/aircraft(you need to run planefinder app)
and save it in its db

In JPA compared with redis repository we added in Aircraft
@Entity instead of @RedisHash
@GeneratedValue for id - it means id generated automatically
and @id imported from javax.persistence.Id instead of org.springframework.data.annotation.Id



it uses lomback lib\
@Data - annotation equivalent methods equals(), hashcode(), toString(), getters and setters\
@NoArgsConstructor, @AllArgsConstructor, equivalent constructor without argument and constructor with all arguments\


you have to install db(mongo,maria,postgres)\
for mongo I installed by official documentation and sudo systemctl start mongoDB\
and didn't set any login, pass, dbname, for mongo and @id annotation set by org.springframework.data.annotation.Id

it has DataLoader class with method annotated @PostConstruct which can load data to DB\
alternative way to set properties spring.datasource.initialization-mode=always, spring.jpa.hibernate.ddl-auto=none\
and to make schema-{platform}.sql or/and data-{platform}.sql and property spring.datasourse.platform(u can without platform)\

you can use MongoRepository(PagingAndSortingRepository + CrudRepository), but if it is not necessary use CrudRepository