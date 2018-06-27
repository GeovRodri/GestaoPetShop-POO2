package br.edu.ifg.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import br.edu.ifg.entity.Usuario;

@MappedSuperclass
public abstract class EntidadeBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public abstract void setUsuarioCad(Usuario usuarioCad);
	
	public abstract void setDataCad(Date dataCad);
	
	public abstract void setUsuarioAlt(Usuario usuarioAlt);	
}
