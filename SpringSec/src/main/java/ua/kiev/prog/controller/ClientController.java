package ua.kiev.prog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kiev.prog.model.Client;
import ua.kiev.prog.service.ClientService;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired(required = true)
   // @Qualifier(value = "clientService")

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    @RequestMapping(value = "clients", method = RequestMethod.GET)

    public String listClients(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("listClients", this.clientService.listClient());

        return "clients";
    }

    @RequestMapping(value = "/clients/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client) {

        if (client.getId() == 0) {
            this.clientService.addClient(client);
        } else {
            this.clientService.updateClient(client);
        }
        return "redirect:/clients";

    }

    @RequestMapping("/remove/{id}")
    public String removeClient(@PathVariable("id") int id) {
        this.clientService.removeClient(id);
        return "redirect:/clients";

    }

    @RequestMapping("edit/{id}")
    public String editClient(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClient());

        return "clients";
    }

    @RequestMapping("clientData/{id}")
    public String clientData(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", this.clientService.getClientById(id));

        return "clientData";

    }

}
