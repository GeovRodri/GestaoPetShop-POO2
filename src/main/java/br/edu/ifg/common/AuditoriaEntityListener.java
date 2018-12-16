package br.edu.ifg.common;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.util.BeanUtil;

public class AuditoriaEntityListener {

    @PrePersist
    public void prePersist(EntidadeBase entidade) {
        Usuario usuario = this.buscarUsuario();

        entidade.setDataCad(new Date());
        entidade.setUsuarioCad(usuario);
    }

    @PreUpdate
    public void preUpdate(EntidadeBase entidade) {
        Usuario usuario = this.buscarUsuario();
        entidade.setUsuarioAlt(usuario);
        entidade.setDataAlt(new Date());
    }

    private Usuario buscarUsuario() {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        return entityManager.find(Usuario.class, 1);
    }
}