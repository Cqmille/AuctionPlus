package fr.auctionplus.app.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

import fr.auctionplus.app.bo.Auction;

import java.util.List;

public class AuctionDAO {
    // The single instance of the AuctionDAO class
    private static volatile AuctionDAO instance = null;

    // The EntityManagerFactory instance that is used to create EntityManager objects
    @PersistenceUnit(name = "default")
    private EntityManagerFactory emf;

    // Private constructor to prevent direct instantiation of the AuctionDAO class
    private AuctionDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Public synchronized static method that returns the single AuctionDAO instance
    public static AuctionDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            // Create a new AuctionDAO instance with the specified EntityManagerFactory
            // and store it in the instance field
            instance = new AuctionDAO(emf);
        }

        // Return the AuctionDAO instance
        return instance;
    }

    public void save(Auction auction) {
        // Create an EntityManager object using the EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();

        // Persist the Auction object to the database
        em.persist(auction);

        // Commit the transaction
        em.getTransaction().commit();

        // Print a message to the console indicating that the auction was saved to the database
        System.out.println("Ajouté en base : " + auction);

        // Close the EntityManager
        em.close();
    }

    public List<Auction> findAll() {
        EntityManager em = emf.createEntityManager();

        List<Auction> auctions;
        auctions = em.createQuery("SELECT a FROM Auction a").getResultList();

        em.close();
        return auctions;
    }

    public List<Auction> findLast(int n) {
        EntityManager em = emf.createEntityManager();

        List<Auction> auctions;
        auctions = em.createQuery("SELECT a FROM Auction a ORDER BY a.auctionId DESC")
                .setMaxResults(n)
                .getResultList();

        em.close();
        return auctions;
    }

    public void updateAuction(Auction auction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Auction managedAuction = em.find(Auction.class, auction.getAuctionId());
        managedAuction.setItemName(auction.getItemName());
        managedAuction.setItemDescription(auction.getItemDescription());

        em.persist(managedAuction);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAuction(Auction auction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Auction managedAuction = em.find(Auction.class, auction.getAuctionId());

        em.remove(managedAuction);
        em.getTransaction().commit();
        em.close();
    }

    public List<Auction> findBySellerId(int userId) {
        EntityManager em = emf.createEntityManager();

        List<Auction> auctions;
        auctions = em.createQuery("SELECT a FROM Auction a WHERE a.sellerId = :sellerId")
                .setParameter("sellerId", userId)
                .getResultList();

        em.close();
        return auctions;
    }

}