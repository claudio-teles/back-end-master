package claudioteles.com.github.backendmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(generator = "gerador_de_id_adminstrador", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id_adminstrador", sequenceName = "sequencia_adminstrador", initialValue = 50, allocationSize = 1)
	private Long id;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 40, nullable = false)
	private String senha;
	private Boolean login;
	
	public Administrador() {
		super();
	}

	public Administrador(String nome, String senha, Boolean login) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}
	
}
