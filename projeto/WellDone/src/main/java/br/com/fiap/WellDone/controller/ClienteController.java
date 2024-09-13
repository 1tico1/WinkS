package br.com.fiap.WellDone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.WellDone.model.Cliente;
import br.com.fiap.WellDone.repository.ClienteRep;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRep clienteRepository;

    @GetMapping("/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("title", "Adicionar/Editar Cliente");
        return "cliente-form";
    }

    @PostMapping("/save")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/cliente/list";
    }

    @GetMapping("/list")
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("title", "Lista de Clientes");
        return "cliente-list";
    }

    @GetMapping("/edit/{id}")
    public String editCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id));
        model.addAttribute("cliente", cliente);
        model.addAttribute("title", "Editar Cliente");
        return "cliente-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/cliente/list";
    }
}
