/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Encuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ariel-linux
 */
@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> implements EncuestaFacadeLocal {
    @PersistenceContext(unitName = "cl.G2Pingeso_easy-planning-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }
    
}
