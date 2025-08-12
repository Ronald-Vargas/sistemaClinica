
package Appointment;


public class Appointment {
    
    private String idCita;
    private String fechaCita;
    private String hora;
    private String fechaRegistro;
    private String estado;
    private String area;   
    private String id;

    public Appointment(String idCita, String fechaCita, String hora, String fechaRegistro, String estado, String area, String id) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.area = area;
        this.id = id;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    
    
    
    
    
    
}
