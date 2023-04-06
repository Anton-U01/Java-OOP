package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;

public class ControllerImpl implements Controller{
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectedCounter;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = null;
        switch (kind){
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED,kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        if(discovererRepository.byName(discovererName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST,discovererName));
        }
        discovererRepository.remove(discovererRepository.byName(discovererName));
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE,discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> perfectDiscoverers = discovererRepository.getCollection().stream().filter(d -> d.getEnergy() > 45).collect(Collectors.toList());
        if(perfectDiscoverers.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Spot spot = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot,perfectDiscoverers);
        long tiredDiscoverers = perfectDiscoverers.stream().filter(d -> d.getEnergy() == 0).count();
        inspectedCounter++;
        return String.format(ConstantMessages.INSPECT_SPOT,spotName,tiredDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(FINAL_SPOT_INSPECT,inspectedCounter)).append(System.lineSeparator());
        builder.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        Collection<Discoverer> discoverers = discovererRepository.getCollection();
        for (Discoverer discoverer : discoverers) {
            builder.append(String.format(FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            builder.append(String.format(FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());
            Collection<String> exhibits = discoverer.getMuseum().getExhibits();
            if(exhibits.isEmpty()){
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None")).append(System.lineSeparator());
            } else {
                String allMuseumExhibitsText = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,exhibits);
                builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,allMuseumExhibitsText)).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
