
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[play.mvc.Http.Request,org.webjars.play.WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: play.mvc.Http.Request, webJarsUtil: org.webjars.play.WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Reactive Stock News Dashboard</title>

    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.55*/routes/*8.61*/.Assets.at("images/favicon.png")),format.raw/*8.93*/("""">

    """),_display_(/*10.6*/Html(webJarsUtil.css("bootstrap.min.css"))),format.raw/*10.48*/("""
    """),format.raw/*11.5*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*11.50*/routes/*11.56*/.Assets.at("stylesheets/main.min.css")),format.raw/*11.94*/("""">

    """),_display_(/*13.6*/Html(webJarsUtil.script("jquery.min.js"))),format.raw/*13.47*/("""
    """),_display_(/*14.6*/Html(webJarsUtil.script("jquery.flot.js"))),format.raw/*14.48*/("""
    """),format.raw/*15.5*/("""<script type='text/javascript' src='"""),_display_(/*15.42*/routes/*15.48*/.Assets.at("javascripts/index.js")),format.raw/*15.82*/("""'></script>
</head>
<body data-ws-url=""""),_display_(/*17.21*/routes/*17.27*/.HomeController.ws.webSocketURL(request)),format.raw/*17.67*/("""">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="#">Reactive Stocks</a>
                <form id="addsymbolform" class="navbar-form pull-right">
                    <input id="addsymboltext" type="text" class="span2" placeholder="SYMBOL">
                    <button type="submit" class="btn">Add Stock</button>
                </form>
            </div>
        </div>
    </div>

    <div id="stocks" class="container">

    </div>
</body>
</html>
"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,webJarsUtil:org.webjars.play.WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(request,webJarsUtil)

  def f:((play.mvc.Http.Request,org.webjars.play.WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (request,webJarsUtil) => apply(request,webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Aug 26 18:39:46 EDT 2018
                  SOURCE: /Users/sergeymikhaylov/Local Documents/Programming/Trading/app/views/index.scala.html
                  HASH: 3042c11c5df06d7fc6f0324c2f4e9f48d2ef2a2b
                  MATRIX: 992->1|1161->77|1322->212|1336->218|1388->250|1423->259|1486->301|1518->306|1590->351|1605->357|1664->395|1699->404|1761->445|1793->451|1856->493|1888->498|1952->535|1967->541|2022->575|2089->615|2104->621|2165->661
                  LINES: 28->1|33->2|39->8|39->8|39->8|41->10|41->10|42->11|42->11|42->11|42->11|44->13|44->13|45->14|45->14|46->15|46->15|46->15|46->15|48->17|48->17|48->17
                  -- GENERATED --
              */
          