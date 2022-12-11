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
            List<Auction> auctions = AuctionManager.getInstance().findLast(3);
            request.setAttribute("auctions", auctions);
            request.getRequestDispatcher("auctions.jsp").forward(request, response);
        } catch (IOException e) {
            ServletContext context = getServletContext();
            context.log("Une erreur s'est produite lors de la récupération de la liste des enchères", e);
            String errorMessage = "Une erreur s'est produite lors de la récupération de la liste des enchères: " + e.getMessage();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorMessage);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
