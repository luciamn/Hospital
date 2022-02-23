package es.cesar.hospital.BBDD;

import es.cesar.hospital.modelo.*;
import es.cesar.hospital.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Conectar implements CommandLineRunner {

    private final TipoCitaRepositorio tipoCita;
    private final TipoPersonalRepositorio tipoPersonal;
    private final TipoVacunaRepositorio tipoVacuna;
    private final AmbulaciaRepositorio ambulacia;
    private final ConductorRepositorio conductor;
    private final HabitacionRepositorio habitacion;
    private final PlantaRepositorio planta;
    private final VacunaRepositorio vacuna;
    private final ZonaRepositorio zona;

    @Autowired
    public Conectar(
            TipoCitaRepositorio tipoCita,
            TipoPersonalRepositorio tipoPersonal,
            TipoVacunaRepositorio tipoVacuna,
            AmbulaciaRepositorio ambulacia,
            ConductorRepositorio conductor,
            HabitacionRepositorio habitacion,
            PlantaRepositorio planta,
            VacunaRepositorio vacuna,
            ZonaRepositorio zona
    ){
        this.tipoCita = tipoCita;
        this.tipoPersonal = tipoPersonal;
        this.tipoVacuna = tipoVacuna;
        this.ambulacia = ambulacia;
        this.conductor = conductor;
        this.habitacion = habitacion;
        this.planta = planta;
        this.vacuna = vacuna;
        this.zona = zona;
    }

    @Override
    public void run(String... strings) {

        this.tipoCita.save(new TipoCita("Vacunacion"));
        this.tipoCita.save(new TipoCita("Consulta"));
        this.tipoCita.save(new TipoCita("Urgencia"));

        this.tipoPersonal.save(new TipoPersonal("Pediatra"));
        this.tipoPersonal.save(new TipoPersonal("Cardiologo"));
        this.tipoPersonal.save(new TipoPersonal("Psiquiatra"));
        this.tipoPersonal.save(new TipoPersonal("Enfermero"));
        this.tipoPersonal.save(new TipoPersonal("Cirujano"));
        this.tipoPersonal.save(new TipoPersonal("Neurologo"));

        this.tipoVacuna.save(new TipoVacuna("Pfizer"));
        this.tipoVacuna.save(new TipoVacuna("Moderna"));
        this.tipoVacuna.save(new TipoVacuna("Astrazeneca"));

        this.ambulacia.save(new Ambulancia("2080DRT", "A1"));
        this.ambulacia.save(new Ambulancia("3270GSP", "A1"));
        this.ambulacia.save(new Ambulancia("5719FJH", "A2"));
        this.ambulacia.save(new Ambulancia("1073DBN", "A2"));
        this.ambulacia.save(new Ambulancia("4084TEP", "B"));
        this.ambulacia.save(new Ambulancia("9620IOP", "B"));
        this.ambulacia.save(new Ambulancia("0581NJK", "B"));
        this.ambulacia.save(new Ambulancia("8719ASX", "C"));
        this.ambulacia.save(new Ambulancia("3584INL", "C"));
        this.ambulacia.save(new Ambulancia("6217RMY", "C"));

        int contadorZona = 0;

        for (int i = 0; i < 3; i++) {
            String [] arrayEsp = {"Enfermeria", "Pediatria", "Psiquiatria", "Neurologia", "Cardiologia", "Cirugia"};
            Planta planta = new Planta(i + 1);
            this.planta.save(planta);
            for (int j = 0; j < 2; j++) {
                Zona zona = new Zona(arrayEsp[contadorZona], planta);
                this.zona.save(zona);
                contadorZona ++;
                for (int k = 0; k < 10; k++) {
                    this.habitacion.save(new Habitacion(i + 1, zona));
                }
            }
        }


    }
}

