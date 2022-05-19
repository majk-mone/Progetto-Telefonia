package telefonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonia.model.ClienteModel;
import telefonia.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteModel inserisciCliente(ClienteModel c) {
	return clienteRepository.save(c);
    }

    public ClienteModel updateCliente(Integer id, ClienteModel c) {
	ClienteModel clienteDaAggiornare = clienteRepository.getById(id);
	clienteDaAggiornare.setNome(c.getNome());
	clienteDaAggiornare.setCognome(c.getCognome());
	clienteDaAggiornare.setCodFiscale(c.getCodFiscale());
	clienteDaAggiornare.setNumero(c.getNumero());
	clienteDaAggiornare.setStatoLinea(c.getStatoLinea());
	clienteDaAggiornare.setTipoLinea(c.getTipoLinea());

	return clienteRepository.save(clienteDaAggiornare);
    }

    public void eliminaCliente(Integer id) {
	clienteRepository.deleteById(id);
    }

}
