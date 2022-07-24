/*

spring.datasource.username=u4xedst2g7dtksic
spring.datasource.password=Kb4TXH5YpqkPgYGOpXGn
spring.datasource.url=jdbc:mysql://u4xedst2g7dtksic:Kb4TXH5YpqkPgYGOpXGn@bdljgdhz1tixpqx6uvel-mysql.services.clever-cloud.com:3306/bdljgdhz1tixpqx6uvel

spring.datasource.username=root
spring.datasource.password=2539
spring.datasource.url=jdbc:mysql://localhost:3306/portfolioARGv2?useSSL=false&serverTimezone=UTC


@Test
public void testCreateUser() {
    User user = new User();
    user.setEmail("ravikumar@gmail.com");
    user.setPassword("ravi2020");
    user.setFirstName("Ravi");
    user.setLastName("Kumar");
     
    User savedUser = repo.save(user);
     
    User existUser = entityManager.find(User.class, savedUser.getId());
     
    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
     
}*/