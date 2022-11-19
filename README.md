In JPA compared with redis repository we added in Aircraft
@Entity instead of @RedisHash
@GeneratedValue for id - it means id generated automatically
and @id imported from javax.persistence.Id instead of org.springframework.data.annotation.Id;

