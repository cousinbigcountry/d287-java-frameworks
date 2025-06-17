package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(inhousePartRepository.count() == 0) {

            //Creating object for InhousePart Class
            InhousePart Chain = new InhousePart();

            //Setting values for Chain
            Chain.setName("Chain");
            Chain.setInv(25);
            Chain.setPrice(10.00);
            Chain.setId(1001);

            inhousePartRepository.save(Chain);

            //Creating object for InhousePart Class
            InhousePart Handlebars = new InhousePart();

            //Setting values for Handlebars
            Handlebars.setName("Handlebars");
            Handlebars.setInv(25);
            Handlebars.setPrice(35.00);
            Handlebars.setId(1002);

            inhousePartRepository.save(Handlebars);

            //Creating object for InhousePart Class
            InhousePart Wheels = new InhousePart();

            //Setting values for Wheels
            Wheels.setName("Wheels");
            Wheels.setInv(50);
            Wheels.setPrice(45.00);
            Wheels.setId(1003);

            inhousePartRepository.save(Wheels);
        }

        if(outsourcedPartRepository.count() == 0) {
            //Creating object for OutsourcedPart class
            OutsourcedPart Chassis = new OutsourcedPart();

            //Setting values for Chassis
            Chassis.setCompanyName("Spartanburg Chassis");
            Chassis.setName("Chassis");
            Chassis.setInv(25);
            Chassis.setPrice(50.00);
            Chassis.setId(2001);

            outsourcedPartRepository.save(Chassis);

            //Creating object for OutsourcedPart class
            OutsourcedPart Tires = new OutsourcedPart();

            //Setting values for Tires
            Tires.setCompanyName("Duncan Tires");
            Tires.setName("Tire");
            Tires.setInv(50);
            Tires.setPrice(50.00);
            Tires.setId(2002);

            outsourcedPartRepository.save(Tires);
        }
        if(productRepository.count() == 0) {
            //Creating Race Bike Product
            Product RaceBicycle = new Product(3001,"Race Bicycle", 1000.00, 10);
            productRepository.save(RaceBicycle);

            //Creating Mountain Bike Product
            Product MtnBicycle = new Product(3002,"Mountain Bicycle", 900.00, 10);
            productRepository.save(MtnBicycle);

            //Creating BMX Bike Product
            Product BmxBicycle = new Product(3003,"BMX Bicycle", 800.00, 10);
            productRepository.save(BmxBicycle);

            //Creating Cruiser Bike Product
            Product CruiserBicycle = new Product(3004,"Cruiser Bicycle", 700.00, 10);
            productRepository.save(CruiserBicycle);

            //Creating Cruiser Bike Product
            Product KidsBicycle = new Product(3005,"Kids Bicycle", 500.00, 10);
            productRepository.save(KidsBicycle);
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
