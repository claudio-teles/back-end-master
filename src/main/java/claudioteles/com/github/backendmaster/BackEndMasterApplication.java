package claudioteles.com.github.backendmaster;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import claudioteles.com.github.backendmaster.model.Administrador;
import claudioteles.com.github.backendmaster.repository.AdministradorRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BackEndMasterApplication {
	
	@Autowired
	private AdministradorRepository adr;
	
	@PostConstruct
    public void initAdms() {
        List<Administrador> adms = Stream.of(
                new Administrador("Adm1", "SenhaAdm1", false),
                new Administrador("Adm2", "SenhaAdm2", false)
        ).collect(Collectors.toList());
        adr.saveAll(adms);
    }

	public static void main(String[] args) {
		SpringApplication.run(BackEndMasterApplication.class, args);
	}

}
