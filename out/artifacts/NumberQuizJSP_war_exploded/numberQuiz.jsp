<%@ page import="model.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: baiamang
  Date: 2020-05-11
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to number Quiz</title>
    <% Quiz quiz = (Quiz) session.getAttribute("quiz"); %>
</head>
<body <%= quiz.hasQuestion() ? "onload='javascript:myform.txtAnswer.focus()'" : "" %>>
<% if (!quiz.hasQuestion()) {%>
<form name="myform" action="post">
    <h3>Game Over</h3>
    <p>Your current score is ${quiz.getScore()}.</p>
    <p>Your Grade is <font style="color:red"></font></p>
    <h3><font style="color:red">${quiz.getGrade()}</font></h3>
    <p></p>
    <p><input type="submit" name="btnRestart" value="Start Over!"></p>
</form>
<% } else { %>
<h3>Have fun with NumberQuiz!</h3>
<p>Your current score is ${quiz.getScore()}.</p>
<p>Attempt ${quiz.getCurrentMistakeCount()} / 3 </p>
<p>Guess the next number in the sequence!</p>

<p><% quiz.getCurrentQuestion(); %></p>
<p>Your answer:<input type="text" name="txtAnswer" value="${quiz.getAnswerIfDidMoreMistake()}"></p>
<p><input type="submit" name="btnNext" value="Next"><input type="submit" name="btnRestart" value="Restart!"
                                                           onclick="return confirm('Do you want to start over?')"></p>

<%
    boolean isCorrectAnswer = (boolean) request.getAttribute("isCorrectAnswer");
    if (!isCorrectAnswer) {
%>
<p style="color:red">Your last answer was not correct! Please try again</p>
<%
    }
%>
<p><input type="button" name="btnHint" value="Hint?" onclick="alert('<%=quiz.getHint()%>')"></p>
<%
    }
%>
</body>
</html>
