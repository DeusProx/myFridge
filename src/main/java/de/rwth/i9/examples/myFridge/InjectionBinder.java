package de.rwth.i9.examples.myFridge;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;
import de.rwth.i9.examples.myFridge.services.ItemMemoryDAO;
import de.rwth.i9.examples.myFridge.services.ItemSQLiteDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class InjectionBinder extends AbstractBinder {

    Properties prop = new Properties();

    public InjectionBinder() {
      super();
      InputStream isConfig = null;
      try {
        isConfig = new FileInputStream("src/main/resources/config.prop");
        this.prop.load(isConfig);
      } catch (IOException ex) {
        ex.printStackTrace();
      } finally {
        if (isConfig != null) {
          try {
            isConfig.close();
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      }
    }

    /* (non-Javadoc)
       * @see org.glassfish.hk2.utilities.binding.AbstractBinder#configure()
       */
    protected void configure() {
        this.configureDAO();
    }

    protected void configureDAO() {
        String storageType = this.prop.getProperty("storageType");
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
