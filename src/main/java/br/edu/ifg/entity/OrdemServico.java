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
@Table(name = "ordem_servico")
public class OrdemServico extends EntidadeBase {

	private static final long serialVersionUID = 3832771142184056704L;

	@Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false, updatable = false)
    private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal", nullable = false, updatable = false)
    private Animal animal;
	
	@Column(name = "data_serv", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataServico;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}
}