package br.com.fiap.WellDone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.WellDone.model.Pedido;
import br.com.fiap.WellDone.repository.PedidosRep;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidosRep pedidoRepository;

    @GetMapping("/new")
    public String pedidoForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("title", "Adicionar/Editar Pedido");
        return "pedido-form";
    }

    @PostMapping("/save")
    public String savePedido(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedido/list";
    }

    @GetMapping("/list")
    public String listPedidos(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("title", "Lista de Pedidos");
        return "pedido-list";
    }

    @GetMapping("/edit/{id}")
    public String editPedido(@PathVariable("id") Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido inválido: " + id));
        model.addAttribute("pedido", pedido);
        model.addAttribute("title", "Editar Pedido");
        return "pedido-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePedido(@PathVariable("id") Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedido/list";
    }
}
