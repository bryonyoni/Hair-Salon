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

    get("/stylists",(request,response) ->{
      Map<String,Object> model = new HashMap<String,Object>();
      model.put("stylists",Stylist.all());
      model.put("template","templates/stylists.vtl");
      return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());

    get("/stylists/new",(request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/stylist-form.vtl");
      return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());

    post("/stylists/success",(request,response) -> {
      Map<String,Object> model = new HashMap<String,Object>();
      String name = request.queryParams("name");
      String image = request.queryParams("image");
      Stylist newStylist = new Stylist(name,image);
      newStylist.save();
      model.put("template","templates/stylist-success.vtl");
      return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());

    get("/stylists/:id",(request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
      model.put("stylist",stylist);
      model.put("template","templates/stylist.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());


  }



}
