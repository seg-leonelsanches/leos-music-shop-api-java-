package br.com.segment.leosmusicstoreapi.data;

import br.com.segment.leosmusicstoreapi.models.Admin;
import br.com.segment.leosmusicstoreapi.models.DrumKit;
import br.com.segment.leosmusicstoreapi.models.Manufacturer;
import br.com.segment.leosmusicstoreapi.repositories.AdminRepository;
import br.com.segment.leosmusicstoreapi.repositories.DrumKitRepository;
import br.com.segment.leosmusicstoreapi.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private DrumKitRepository drumkitRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer(null, "Tama", null));
        manufacturers.add(new Manufacturer(null, "DW", null));

        manufacturerRepository.save(manufacturers.get(0));
        manufacturerRepository.save(manufacturers.get(1));

        drumkitRepository.save(new DrumKit(null, "DW Bobby Jarzombek Signature", manufacturers.get(1)));

        adminRepository.save(
                new Admin(
                        null,
                        "Leonel",
                        "Sanches",
                        "leonel.sanches@segment.com",
                        passwordEncoder.encode("hackme#123")
                )
        );
    }
}