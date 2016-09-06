package de.rwth.i9.examples.myFridge;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;
import de.rwth.i9.examples.myFridge.services.ItemMemoryDAO;
import de.rwth.i9.examples.myFridge.services.ItemSQLiteDAO;

import java.util.ResourceBundle;

public class InjectionBinder extends AbstractBinder {

    ResourceBundle config = ResourceBundle.getBundle("config");

    /* (non-Javadoc)
       * @see org.glassfish.hk2.utilities.binding.AbstractBinder#configure()
       */
    protected void configure() {
        this.configureDAO();
    }

    protected void configureDAO() {
        String storageType = this.config.getString("storageType");
        System.out.println("Used StorageType: " + storageType);
        switch(storageType) {
            case "memory":
                bind(new ItemMemoryDAO()).to(ItemDAO.class);
                break;
            case "sqlite":
                bind(new ItemSQLiteDAO()).to(ItemDAO.class);
                break;
            default:
                throw new IllegalArgumentException(storageType + " is not a valid choice as StorageType!");
        }
    }
}
