package fr.auctionplus.app.bll;

import fr.auctionplus.app.dal.AuctionDAO;
import fr.auctionplus.app.bo.Auction;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AuctionManager {
    // The single instance of the AuctionManager class
    private static volatile AuctionManager instance = null;

    // The AuctionDAO instance that is used to persist Auction objects to the database
    private AuctionDAO auctionDAO;

    // Private constructor to prevent direct instantiation of the AuctionManager class
    private AuctionManager(AuctionDAO auctionDAO) {
        this.auctionDAO = auctionDAO;
    }

    public static synchronized AuctionManager getInstance() throws IOException {
        if (instance == null) {
            // Create an EntityManagerFactory using the values from the app.properties file
            EntityManagerFactory emf = createEntityManagerFactory();

            // Create a new AuctionManager instance with the specified AuctionDAO instance
            // and store it in the instance field
            instance = new AuctionManager(AuctionDAO.getInstance(emf));
        }

        // Return the AuctionManager instance
        return instance;
    }

    // Creates an EntityManagerFactory using the values from the app.properties file
    private static EntityManagerFactory createEntityManagerFactory() throws IOException {
        // Read the values from the app.properties file
        Properties appProperties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        appProperties.load(classLoader.getResourceAsStream("app.properties"));

        String databaseUrl = appProperties.getProperty("database.url");
        String databaseDriver = appProperties.getProperty("database.driver");
        String databaseUsername = appProperties.getProperty("database.username");
        String databasePassword = appProperties.getProperty("database.password");

        // Use the values from the app.properties file to create an EntityManagerFactory
        Map<String, String> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.url", databaseUrl);
        properties.put("jakarta.persistence.jdbc.driver", databaseDriver);
        properties.put("jakarta.persistence.jdbc.user", databaseUsername);
        properties.put("jakarta.persistence.jdbc.password", databasePassword);

        return Persistence.createEntityManagerFactory("default", properties);
    }

    public void save(Auction auction) {
        auctionDAO.save(auction);
    }

    public List<Auction> findAll() {
        return auctionDAO.findAll();
    }

}
