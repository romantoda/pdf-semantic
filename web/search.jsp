<%-- 
    Document   : Search
    Created on : Dec 2, 2015, 10:31:06 PM
    Author     : Roman Toda <roman.toda@gmail.com>
--%>

<%@page import="myObjects.Search_Params"%>

<div id="search">

    <div id="search_l">
	Enter String: <br/> <br/> <br/> <br/>
	Was searching:
    </div>


    <div id="search_r">
	<form method="post" action ="SearchPDF">
		<input id= "search_box" name="search_string" type="text" required>
		<span class="arrow_box"> </span>
		<input id="submit" type="submit" value="Search"> 
		&nbsp &nbsp &nbsp &nbsp
		<span class="width:2%; margin-left:2%;"> </span>
		<input type="radio" name="search_where" value="0" checked > Files &nbsp &nbsp &nbsp
		<input type="radio" name="search_where" value="1" > Pages &nbsp &nbsp &nbsp
		<input type="radio" name="search_where" value="2" > Paragraphs &nbsp &nbsp &nbsp
	</form>    
    </div>
        
<% 
    Search_Params sp = (Search_Params)session.getAttribute("SearchParams");	
    if (sp == null || (sp.getSearchString().isEmpty() && sp.getSearchFileID() == -1) ) out.print("-----") ;
    else { 
        if (sp.getSearchWhere()==0) out.print(" [in Files]");
        else if (sp.getSearchWhere()==1) out.print("[in Pages]");
            else if (sp.getSearchWhere()==2) out.print("[in Paragraphs]");
                else out.print("<in unknown>");

        if (sp.getSearchFileID() == -1) {
            out.print("similar to string: [");
            out.print(sp.getSearchString());
            out.print("]");
        } else 
            if (sp.getSearchPageID() == -1) {
                out.print("similar to file with id:[");
                out.print(sp.getSearchFileID());
                out.print("]");
            } else
                if (sp.getSearchParagraphID() == -1) {
                    out.print("similar to a page num:[");
                    out.print(sp.getSearchPageID());
                    out.print("] in file:[");
                    out.print(sp.getSearchFileID());
                    out.print("]");
                } else {
                    out.print("similar to a paragraph id:[");
                    out.print(sp.getSearchParagraphID());
                    out.print("] page num:[");
                    out.print(sp.getSearchPageID());
                    out.print("] in file:[");
                    out.print(sp.getSearchFileID());
                    out.print("]");
                }
    }
%>

</div> 

