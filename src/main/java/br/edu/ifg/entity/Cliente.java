package br.edu.ifg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.edu.ifg.common.EntidadeBase;

@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeBase {

	private static final long serialVersionUID = 3832771142184056704L;

	@Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = true, length = 14)
    private String cpf;
    
    @Column(name = "telefone", nullable = true)
    private String telefone;
    
    @Column(name = "endereco", nullable = true)
    private String endereco;

    @Column(name = "dt_cad", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_cad", nullable = false, updatable = false)
    private Usuario usuarioCad;
    
    @Column(name = "dt_alt", nullable = true, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAlt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_alt", nullable = true, updatable = false)
    private Usuario usuarioAlt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public Usuario getUsuarioCad() {
		return usuarioCad;
	}

	public void setUsuarioCad(Usuario usuarioCad) {
		this.usuarioCad = usuarioCad;
	}

	public Date getDataAlt() {
		return dataAlt;
	}

	public void setDataAlt(Date dataAlt) {
		this.dataAlt = dataAlt;
	}

	public Usuario getUsuarioAlt() {
		return usuarioAlt;
	}

	public void setUsuarioAlt(Usuario usuarioAlt) {
		this.usuarioAlt = usuarioAlt;
	}
}