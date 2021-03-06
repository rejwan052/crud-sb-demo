package io.github.cepr0;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Profile("!test")
    @Bean
    public CommandLineRunner demo(UserRepo repo) {
        return args -> {
    
            Iterable<User> users = repo.findAll();
            if (users.iterator().hasNext()) {
                
                for (User user : users) {
                    System.out.println(user.toString());
                }
                
                return;
            }
    
            User u1 = repo.save(new User("Вася Пупкин", "vasya@demo.com", "123456"));
            u1.setRole(User.Role.ROLE_ADMIN);
            repo.save(u1);
            
            repo.save(new User("Алиса Селезнева", "alice@demo.com", "123456"));
            
            User u2 = repo.save(new User("Коля Герасимов", "kolya@demo.com", "123456"));
            u2.setEnabled(false);
            u2.setRole(User.Role.ROLE_ADMIN);
            repo.save(u2);

            repo.save(new User("Шерлок Холмс", "sherlock@demo.com", "123456"));
            repo.save(new User("Джон Ватсон", "watson@demo.com", "123456"));
            repo.save(new User("Остап Бендер", "bender@demo.com", "123456"));
            repo.save(new User("Киса Воробьянинов", "kisa@demo.com", "123456"));
    
            repo.save(new User("Frodo Baggins", "frodo@demo.com", "123456"));
            repo.save(new User("Gandalf the Grey", "gandalf@demo.com", "123456"));
            repo.save(new User("Sam Gamgee", "sam@demo.com", "123456"));
            repo.save(new User("Merry Brandybuck", "marry@demo.com", "123456"));
            repo.save(new User("Pippin Took", "pippin@demo.com", "123456"));
            repo.save(new User("Aragorn", "aragorn@demo.com", "123456"));
            repo.save(new User("Legolas", "legolas@demo.com", "123456"));
            repo.save(new User("Gimli", "gimli@demo.com", "123456"));
        };
    }
}
