package by.task.komar.main;

import by.task.komar.comparator.ConeRadiusComparator;
import by.task.komar.filler.RepositoryFiller;
import by.task.komar.filler.WarehouseFiller;
import by.task.komar.entity.Point;
import by.task.komar.entity.Warehouse;
import by.task.komar.exception.ConeException;
import by.task.komar.observer.impl.ConeObserverImpl;
import by.task.komar.parser.ConeParser;
import by.task.komar.reader.ConeReader;
import by.task.komar.repository.impl.ConeRepository;
import by.task.komar.repository.impl.HeightSpecification;
import by.task.komar.validator.ConeValidator;

public class Main {
    public static void main(String[] args) throws ConeException {
        ConeReader reader = new ConeReader();
        ConeParser parser = new ConeParser();
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        for (String line : reader.readFromFile("src\\main\\resources\\file\\figure.txt")) {
            if (ConeValidator.isValidate(line)) {
                double[] array = parser.parse(line);
                repositoryFiller.fillConeRepository(array);
                warehouseFiller.fillConeWarehouse(array);
            }
        }
        repositoryFiller.fillConeRepository(1, 1, 1, 1, 1);
        warehouseFiller.fillConeWarehouse(1, 1, 1, 1, 1);
        Point point = new Point(0, 0, 0);
        repositoryFiller.fillConeRepository(point, 5.7, 0.1);
        warehouseFiller.fillConeWarehouse(point, 5.7, 0.1);
        Warehouse warehouse = Warehouse.getInstance();
        ConeRepository repository = ConeRepository.getInstance();
        System.out.println(warehouse.get(6L));
        ConeObserverImpl observer = new ConeObserverImpl();
        repository.get(1).attach(observer);
        repository.get(1).setHeight(0.5);
        System.out.println(warehouse.get(repository.get(1).getConeId()));
        System.out.println(repository.sort(new ConeRadiusComparator()));
        System.out.println(repository.query(new HeightSpecification(1, 5)));
    }
}
