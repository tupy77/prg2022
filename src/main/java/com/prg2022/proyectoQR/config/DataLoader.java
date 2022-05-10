package com.prg2022.proyectoQR.config;

import java.util.List;

import com.prg2022.proyectoQR.Repository.AlumnoRepository;
import com.prg2022.proyectoQR.Repository.BrigadaRepository;
import com.prg2022.proyectoQR.Repository.RolesRepository;
import com.prg2022.proyectoQR.modelos.Alumno;
import com.prg2022.proyectoQR.modelos.Brigada;
import com.prg2022.proyectoQR.modelos.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {



    private AlumnoRepository aRepository;
    private BrigadaRepository bRepository;
    private RolesRepository rRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(AlumnoRepository aRepository, BrigadaRepository bRepository, RolesRepository rRepository) {
        this.aRepository = aRepository;
        this.bRepository = bRepository;
        this.rRepository = rRepository;
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        List<Alumno> alumno = aRepository.findByDni("Admin");
        if (alumno.size() == 0) {
            System.out.println("No hay administrador, creando usuario Admin con password 1234");
            List<Brigada> brigada = bRepository.findByDescripcion("Sistema");
            if (brigada.size() == 0) {
                bRepository.save(new Brigada("Sistema"));
                brigada = bRepository.findByDescripcion("Sistema");
            }
            List<Roles> roles = rRepository.findByTipo("Admin");
            if (roles.size() == 0) {
                rRepository.save(new Roles("Admin"));
                roles = rRepository.findByTipo("Admin");
            }
            if (roles.size() > 0) {
                System.out.println("Tenemos roles");
            }
            Alumno agregado = aRepository.save(new Alumno("Administrador","Admin", brigada.get(0), roles.get(0)));
            agregado.setClave(passwordEncoder.encode("1234"));
            aRepository.save(agregado);
        }

        
    }
}