app gets data from http://localhost:7634/aircraft(you need to run planefinder app)
and save it in its db

In JPA compared with redis repository we added in Aircraft
@Entity instead of @RedisHash
@GeneratedValue for id - it means id generated automatically
and @id imported from javax.persistence.Id instead of org.springframework.data.annotation.Id



it uses lomback lib\
@Data - annotation equivalent methods equals(), hashcode(), toString(), getters and setters\
@NoArgsConstructor, @AllArgsConstructor, equivalent constructor without argument and constructor with all arguments

it has DataLoader class with method annotated @PostConstruct which can load data to DB