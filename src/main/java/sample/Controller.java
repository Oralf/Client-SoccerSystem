package sample;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class Controller {

    public Button tryButton;


    public void tryfunction(MouseEvent mouseEvent){
        String output = null;
        String output2 = null;

        output=connectToServer("Hello","func","id123","oralf");
        //    ClientConfig config = new DefaultClientConfig();
        //    Client client = Client.create(config);
        //WebResource webResource = client.resource("http://localhost:8080/ServerTry_war_exploded/rest/Hello");
        //WebResource service = client.resource(UriBuilder.fromUri("http://132.72.65.77:8080/ServerTry_war_exploded/rest/Hello/func/changed").build());
        //WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/ServerTry_war_exploded/rest/Hello/func/31232/orald").build());

      // output=webResource.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).getEntity(String.class);
        System.out.println(output);

        tryButton.setText(output+"");
    }

    private String connectToServer(String appName, String funcName, String... parameters){
        String ans="";
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/ServerTry_war_exploded/rest").build());
        service=service.path(appName).path(funcName);
        //service.path(appName).path(funcName);
        for (String param:parameters) {
            service=service.path(param);
        }
        ans=service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).getEntity(String.class);
        System.out.println(ans);
        return ans;
    }

}
