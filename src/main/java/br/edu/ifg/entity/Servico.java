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
import br.edu.ifg.util.Utils;

@Entity
@Table(name = "servico")
public class Servico extends EntidadeBase {

	private static final long serialVersionUID = 3832771142184056704L;

	@Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "tipo", nullable = false)
    private String tipo;
	
	@Column(name = "valor", nullable = false)
    private Float valor;
	
	@Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dt_cad", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_cad", nullable = false, updatable = false)
    private Usuario usuarioCad;
    
    @Column(name = "dt_alt", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataAlt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_alt", nullable = true)
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipoeValor(){
		return this.tipo + " (R$ " + Utils.formatarValor(this.valor.doubleValue()) + ")";
	}
}