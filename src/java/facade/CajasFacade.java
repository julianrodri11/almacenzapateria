/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Cajas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JULIAN
 */
@Stateless
public class CajasFacade extends AbstractFacade<Cajas> {
    @PersistenceContext(unitName = "zapateria_julianrPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CajasFacade() {
        super(Cajas.class);
    }
    
}
