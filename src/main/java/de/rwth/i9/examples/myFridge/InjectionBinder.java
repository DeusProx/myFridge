package de.rwth.i9.examples.myFridge;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;
import de.rwth.i9.examples.myFridge.services.ItemMemoryDAO;

public class InjectionBinder extends AbstractBinder {

  /* (non-Javadoc)
	 * @see org.glassfish.hk2.utilities.binding.AbstractBinder#configure()
	 */
	protected void configure() {
    bind(new ItemMemoryDAO()).to(ItemDAO.class);
  }
}
