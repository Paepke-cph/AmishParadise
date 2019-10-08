package servlet;

import core.Gender;
import core.Member;
import storage.DBStorage;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapper.MemberMapper;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private static final DBStorage storage = new DBStorage();
    private static final MemberMapper memberMapper = new MemberMapper(storage);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        if (cmd.equals("home")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if (cmd.equals("testSearch")) {
            request.setAttribute("allMembers", memberMapper.getAllMembers());
            request.getRequestDispatcher("jsp/SearchResult.jsp").forward(request, response);
        }
        else if (cmd.equals("logout")) {
            session.setAttribute("user", null);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if (cmd.equals("login")) {
            Member member = memberMapper.getMember(request.getParameter("username"));
            if (member != null) {
                session.setAttribute("user", member);
                request.getRequestDispatcher("jsp/UserHome.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
            }
        }
        else if(cmd.equals("updateMember")) {
            String bio = request.getParameter("bio");
            Member member = (Member)session.getAttribute("user");
            member.setBio(bio);
            storage.updateMember(member);
            session.setAttribute("user", member);
            request.getRequestDispatcher("jsp/UserHome.jsp").forward(request, response);
        }
        else if (cmd.equals("userHome")) {
            request.getRequestDispatcher("jsp/UserHome.jsp").forward(request, response);
        }
        else if (cmd.equals("register")) {
            request.getRequestDispatcher("jsp/RegisterMember.jsp").forward(request, response);
        }
        else if (cmd.equals("createMember")) {
            String fistName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            Gender gender = Gender.from(request.getParameter("gender"));
            String username = request.getParameter("username");
            LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
            Member member = new Member(username, fistName, lastName, birthdate, gender);
            int id = storage.createMember(member);
            if (id > 0) {
                member.setID(id);
                session.setAttribute("user", member);
                request.getRequestDispatcher("jsp/UserHome.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("jsp/RegisterMember.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
