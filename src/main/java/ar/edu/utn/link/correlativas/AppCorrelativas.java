package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.RepoAlumno;
import ar.edu.utn.link.correlativas.app.RepoMateria;
import ar.edu.utn.link.correlativas.app.RepoMateriaJPA;
import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AppCorrelativas {

    @Autowired
    RepositoryRestConfiguration config; //Nos permite acceder a la configuracion de Spring, para modificarlo

    @Value("${algo}")
    private int unNumero;

    @Value("${path}")
    private String pepito;

    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner init(RepoMateriaJPA repo, RepoAlumno repoAlumno){

        config.exposeIdsFor(Materia.class); //Le indicamos a Spring que muestre el id de la clase Materia

        return (cosas) -> {

            repo.save(new Materia("SO", 2));
            repo.save(new Materia("DDS", 3));
            repo.save(new Materia("Algo", 1));
            repo.save(new Materia("Analisis", 2));
            repo.save(new Materia("Sintaxis", 3));

            repoAlumno.save(new Alumno("pepe"));
            repoAlumno.save(new Alumno("juan"));
            repoAlumno.save(new Alumno("jorge"));
        };
    }
}
