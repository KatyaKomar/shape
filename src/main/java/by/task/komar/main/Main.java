package by.task.komar.main;

import by.task.komar.comparator.RadiusComparator;
import by.task.komar.creator.ConeCreator;
import by.task.komar.entity.Point;
import by.task.komar.entity.Warehouse;
import by.task.komar.exception.ConeException;
import by.task.komar.observer.impl.ConeObserver;
import by.task.komar.parser.ConeParser;
import by.task.komar.reader.ConeReader;
import by.task.komar.repository.impl.ConeRepository;
import by.task.komar.repository.impl.SpecificationByHeight;
import by.task.komar.validator.ConeValidator;

public class Main {
    public static void main(String[] args) throws ConeException {
        ConeReader reader = new ConeReader();
        ConeParser parser = new ConeParser();
        ConeCreator creator = new ConeCreator();
        for (String line : reader.readFromFile("src\\main\\resources\\file\\figure.txt")) {
            if (ConeValidator.isValidate(line)) {
                double[] array = parser.parse(line);
                creator.addConeToRepository(array);
            }
        }
        creator.addConeToRepository(1, 1, 1, 1, 1);
        Point point = new Point(0, 0, 0);
        creator.addConeToRepository(point, 5.7, 0.1);
        Warehouse warehouse = Warehouse.getInstance();
        ConeRepository repository = ConeRepository.getInstance();
        System.out.println(warehouse.get(repository.get(1).getConeId()));
        ConeObserver observer = new ConeObserver();
        repository.get(1).attach(observer);
        repository.get(1).setHeight(0.5);
        System.out.println(warehouse.get(repository.get(1).getConeId()));
        System.out.println(repository.sort(new RadiusComparator()));
        System.out.println(repository.query(new SpecificationByHeight(1, 5)));
    }
}
