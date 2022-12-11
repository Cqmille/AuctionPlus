package fr.auctionplus.app.web;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import fr.auctionplus.app.bll.AuctionManager;
import fr.auctionplus.app.bo.Auction;

@WebServlet(name = "AuctionsServlet", value = "/auctions")
public class AuctionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the list of auctions from the database using the AuctionManager
            List<Auction> auctions = AuctionManager.getInstance().findAll();

            // Set the list of auctions as a request attribute
            request.setAttribute("auctions", auctions);

            // Forward the request to the auctions.jsp page
            request.getRequestDispatcher("auctions.jsp").forward(request, response);
        } catch (IOException e) {
            // If an error occurs, print the stack trace to the console and send a 500 Internal Server Error response to the client
            //e.printStackTrace();
            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
