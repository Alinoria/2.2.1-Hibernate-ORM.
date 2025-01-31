package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("Toyota", 423);
      Car car2 = new Car("Suzuki", 999);
      Car car3 = new Car("Audi", 121);
      Car car4 = new Car("BMW", 666);
      Car car5 = new Car("WAZ", 321);



      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));



      userService.add(new User("User5", "Lastname5", "user4@mail.ru", car1));
      userService.add(new User("User6", "Lastname6", "user4@mail.ru", car2));
      userService.add(new User("User7", "Lastname7", "user4@mail.ru", car3));
      userService.add(new User("User8", "Lastname8", "user4@mail.ru", car4));
      userService.add(new User("User9", "Lastname9", "user4@mail.ru", car5));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      context.close();
   }
}
