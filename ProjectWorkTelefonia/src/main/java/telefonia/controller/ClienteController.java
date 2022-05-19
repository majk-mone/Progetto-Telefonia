package telefonia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telefonia.model.ClienteModel;
import telefonia.repository.ClienteRepository;
import telefonia.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/clienti")
    public List<ClienteModel> listaClient() {
	return clienteRepository.findAll();
    }

    @PostMapping("/clienti")
    public ClienteModel inserisciCliente(@RequestBody ClienteModel c) {
	return clienteService.inserisciCliente(c);

    }

    @PutMapping("/clienti/{id}")
    public ClienteModel updateCliente(@PathVariable(required = true) Integer id, @RequestBody ClienteModel c) {
	return clienteService.updateCliente(id, c);
    }

    @DeleteMapping("/clienti/{id}")
    public void eliminaCliente(@PathVariable(required = true) Integer id) {
	clienteService.eliminaCliente(id);

    }
}
