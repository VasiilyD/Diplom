package ua.kiev.prog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ua.kiev.prog.model.Client;
import ua.kiev.prog.model.CustomUser;
import ua.kiev.prog.model.UserRole;
import ua.kiev.prog.service.ClientService;
import ua.kiev.prog.service.UserService;

@SpringBootApplication
//
@EnableAutoConfiguration
//
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService.addUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN,"","");
                userService.addUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER,"","");
            }
        };
    }

    //@Bean
    //public CommandLineRunner client (final ClientService clientService){
     //   return new CommandLineRunner() {
       //     @Override
         //   public void run(String... strings) throws Exception {
           //     clientService.addClient(12,"login","password",21,"email","23344555");
            //}
        //};
    //}

    @Bean
    public UrlBasedViewResolver setupViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;

    }
}