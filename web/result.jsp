<%-- 
    Document   : Result
    Created on : Dec 2, 2015, 10:31:06 PM
    Author     : Roman Toda <roman.toda@gmail.com>

--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="myObjects.Search_Result" %>
<%@page import="myObjects.Search_Params" %>


<% 
    ArrayList rows = (ArrayList)session.getAttribute("SearchResults");	
    if (rows != null)
        if (rows.size()>0) 
        {
        for (int i = 0; i < rows.size(); i++) { 
            Search_Result sr = (Search_Result) rows.get(i);
            String simFile;
            String simPage;
            String simParagraph;
            String simTo;
            simTo = "&search_fileID="+sr.getFileID();
            simTo+= "&search_pageID="+sr.getPageID();
            simTo+= "&search_paragraphID="+sr.getParagraphID();

            simFile="search_where=0"+simTo;
            simPage="search_where=1"+simTo;
            simParagraph="search_where=2"+simTo;
            
            String fileName = sr.getFileName();
            
            if (sr.getPageID()!=-1) 
            { 
                fileName+= " [";
                fileName+= sr.getPageID();
                if (sr.getParagraphID()!=-1) { 
                    fileName+= ":";
                    fileName+= sr.getParagraphID(); 
                }
                fileName+="]";
            }
%>

<hr color="#ebebeb">  


<div id="table">
    <div id="row">
        <div id="cell" style=""><% out.println(sr.getScore()); %> </div>
        <div id="cell" style=""> 
            <a href="viewpdf.jsp?<%=simFile%>"><% out.println(fileName); %></a>    
        </div>
    </div>
</div>
<p class= "summary"><% out.println(sr.getText()); %> 
   <a href="viewpdf.jsp?<%=simFile%>">More..</a> <br/>
   <span style="font-size:120%; padding-top:2%; padding-right:2%; float:left; text-align:left;"> Similar: </span>
   <button type="button" class="button button_similar" onclick="window.location.href = 'SearchPDF?<%=simFile%>'; return true;"> Files</button>
   <button type="button" class="button button_similar" onclick="window.location.href = 'SearchPDF?<%=simPage%>'; return true;"> Pages</button>
   <button type="button" class="button button_similar" onclick="window.location.href = 'SearchPDF?<%=simParagraph%>'; return true;"> Paragraphs</button>	
</p>	
<%      }
    }
    else out.print("No results") ;
%>
	 
