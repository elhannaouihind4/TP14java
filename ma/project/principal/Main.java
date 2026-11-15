package ma.project.principal;



import ma.project.entities.Machine;
import ma.project.entities.Salle;
import ma.project.service.MachineService;
import ma.project.service.SalleService;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // 1. Création des salles
        Salle s1 = new Salle(1, "C1", "Salle Physique");
        Salle s2 = new Salle(2, "A2", "Salle Systeme");

        // 2. Ajout des salles
        salleService.ajouter(s1);
        salleService.ajouter(s2);

        System.out.println(" LISTE DES SALLES ");

        List<Salle> salles = salleService.getAll();

        for (int i = 0; i < salles.size(); i++) {
            System.out.println(salles.get(i));
        }

        // 3. Création des machines
        Machine m1 = new Machine(1, "PC-Mac-13", new Date(), s1);
        Machine m2 = new Machine(2, "PC-Dell-06", new Date(), s1);
        Machine m3 = new Machine(3, "PC-toshiba-01", new Date(), s2);

        // 4. Ajout des machines
        machineService.ajouter(m1);
        machineService.ajouter(m2);
        machineService.ajouter(m3);

        // 5. Afficher les machines de la salle C1
        System.out.println("\n MACHINES DE LA SALLE C1 ");

        List<Machine> machinesA1 =
                machineService.getMachinesBySalle(1);

        for (int i = 0; i < machinesA1.size(); i++) {
            System.out.println(machinesA1.get(i));
        }

        // 6. Recherche d'une machine par ID
        System.out.println("\n RECHERCHE MACHINE ID 1 ");

        Machine machine = machineService.getById(1);

        System.out.println(machine);

        // 7. Modification d'une machine
        System.out.println("\n MODIFICATION ");

        m1.setRef("PC-DELL-PRO");

        machineService.modifier(m1);

        System.out.println(machineService.getById(1));

        // 8. Suppression d'une machine
        System.out.println("\n SUPPRESSION MACHINE 3 ");

        machineService.supprimer(m3);

        // 9. Affichage de toutes les machines
        System.out.println("\n LISTE FINALE DES MACHINES ");

        List<Machine> toutes = machineService.getAll();

        for (int i = 0; i < toutes.size(); i++) {
            System.out.println(toutes.get(i));
        }
    }
}