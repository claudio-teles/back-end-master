package claudioteles.com.github.backendmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(generator = "gerador_de_id_cliente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id_cliente", sequenceName = "sequencia_cliente", initialValue = 50, allocationSize = 1)
	@Column(name = "id_cliente", nullable = false)
	private Long idCliente;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 60, nullable = false)
	private String endereco;
	@Column(length = 20, nullable = false)
	private String telefone;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_de_nascimento", nullable = false)
	private Date dataDeNascimento;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, String endereco, String telefone, Date dataDeNascimento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}

