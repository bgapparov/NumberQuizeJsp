package busines;

import model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quiz quiz = new Quiz();

        boolean isCorrectAnswer = true;
        if(request.getParameter("btnRestart")!=null){
//            request.getSession().invalidate();
            setSessionQuiz(request, quiz);
        }else {
            quiz = getSessionQuiz(request);
            String answer = request.getParameter("txtAnswer");
            if(!"".equals(answer) && answer!=null) {
                isCorrectAnswer = quiz.isCorrect(answer);
                if (isCorrectAnswer) {
                    quiz.scoreAnswer();
                } else {
                    quiz.wrongAnswer();
                }
            }
        }
        request.setAttribute("isCorrectAnswer", isCorrectAnswer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("NumberQuiz.jsp");
        dispatcher.forward(request, response);
        setSessionQuiz(request, quiz);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quiz quiz = getSessionQuiz(request);
        request.setAttribute("isCorrectAnswer", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("NumberQuiz.jsp");
        dispatcher.forward(request, response);
    }

    private Quiz getSessionQuiz(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object attrQuiz = session.getAttribute("quiz");
        if(attrQuiz == null){
            session.setAttribute("quiz", new Quiz());
        }
        return (Quiz)session.getAttribute("quiz");
    }
    private void setSessionQuiz(HttpServletRequest request, Quiz quiz) {
        request.getSession().setAttribute("quiz", quiz);
    }
}
