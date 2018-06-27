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
@Table(name = "item_ordem_servico")
public class ItemOrdemServico extends EntidadeBase {

	private static final long serialVersionUID = 3832771142184056704L;

	@Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico", nullable = false, updatable = false)
    private Servico servico;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_os", nullable = false, updatable = false)
    private OrdemServico ordemServico;

    @Column(name = "dt_cad", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_cad", nullable = false, updatable = false)
    private Usuario usuarioCad;
    
    @Column(name = "dt_alt", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAlt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_alt", nullable = false, updatable = false)
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

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}
}