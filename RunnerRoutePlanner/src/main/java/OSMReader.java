import java.util.Map;

import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.container.v0_6.WayContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Tag;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;

public class OSMReader implements Sink {

	public void initialize(Map<String, Object> metaData) {
		// TODO Auto-generated method stub
		
	}

	public void complete() {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void process(EntityContainer entityContainer) {
		if(entityContainer instanceof WayContainer) {
			Way myWay = ((WayContainer) entityContainer).getEntity();
			for(Tag myTag : myWay.getTags()) {
				System.out.print(myTag.getKey() + ",");
			}
			System.out.println("");
		}
	}

}
