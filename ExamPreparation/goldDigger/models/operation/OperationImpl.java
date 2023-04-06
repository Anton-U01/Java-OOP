package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OperationImpl implements Operation{

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<Discoverer> discovererList = discoverers.stream().filter(Discoverer::canDig).collect(Collectors.toList());
        Collection<String> exhibits = spot.getExhibits();
        for (Discoverer discoverer : discovererList) {
            while (exhibits.iterator().hasNext() && discoverer.canDig()){
                discoverer.dig();
                String currentExh = exhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(currentExh);
                exhibits.remove(currentExh);
            }
        }
    }
}
