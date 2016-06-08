package de.rwth.example.myJerseyRest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import de.rwth.example.myJerseyRest.services.interfaces.ItemDAO;
import de.rwth.example.myJerseyRest.services.ItemMemoryDAO;

public class InjectionBinder extends AbstractBinder {

  /* (non-Javadoc)
	 * @see org.glassfish.hk2.utilities.binding.AbstractBinder#configure()
	 */
	protected void configure() {
    bind(new ItemMemoryDAO()).to(ItemDAO.class);
  }
}
