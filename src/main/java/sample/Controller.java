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
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        //WebResource webResource = client.resource("http://localhost:8080/ServerTry_war_exploded/rest/Hello");
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/ServerTry_war_exploded/rest/Hello").build());
        output=service.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString();
        System.out.println(output);
        output2=service.accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println(output2);
        //response
        /*
        try {
         //   String value=retrievedText;
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8080/ServerTry_war_exploded/rest/Hello");
            ClientResponse response = webResource.accept("text/html").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            output = response.getEntity(String.class);
            if(output==null){
                System.out.println("the output is null");
            }
            System.out.println(output.toString());
            System.out.println("\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        */
        //return output2;
        tryButton.setText(output2);
    }

}
