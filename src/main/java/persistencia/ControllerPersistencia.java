/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.EstadoReporte;
import logica.ReporteSemanal;
import logica.Ropa;
import logica.User;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author tobar
 */
public class ControllerPersistencia {
    RopaJpaController ropa=new RopaJpaController();
    UserJpaController user=new UserJpaController();
    VentaJpaController venta=new VentaJpaController();
    ReporteSemanalJpaController reporte=new ReporteSemanalJpaController();
    public void crearUsuario(User usu){
        user.create(usu);
    }
    public void crearRopa(Ropa rop){
        ropa.create(rop);
    }
    public void crearReporte(ReporteSemanal rep) {
        reporte.create(rep);
    }
    public void crearVenta(Venta ven){
        venta.create(ven);
    }
    public List<User> getUsuarios() {
        return user.findUserEntities();
    }
    public List<Ropa> getRopa() {
        return ropa.findRopaEntities();
    }
    
    public Ropa buscarRopaId(int productoId) {
        return ropa.findRopa(productoId);
    }

    public boolean editarRopa(Ropa r) {
        try {
            ropa.edit(r);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void borrarRopa(int productoId) {
        try {
            ropa.destroy(productoId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Venta> obtenerVentasPorFechas(Date inicio, Date fin) {
        return venta.obtenerVentasPorFechas(inicio, fin);
    }

    public List<ReporteSemanal> obtenerReportes() {
        return reporte.findReporteSemanalEntities();
    }
}
