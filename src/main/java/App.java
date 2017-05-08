import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";



    get("/", (request,response) -> {
      Map<String,Object> model = new HashMap<String,Object>();
      model.put("Stylist",Stylist.all());
      model.put("Client",Client.all());
      model.put("template","templates/index.vtl");
      return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());
  }



}
