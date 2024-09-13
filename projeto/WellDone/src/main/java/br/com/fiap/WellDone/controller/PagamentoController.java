package br.com.fiap.WellDone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.WellDone.model.Pagamento;
import br.com.fiap.WellDone.repository.PagamentoRep;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRep pagamentoRepository;

    @GetMapping("/new")
    public String pagamentoForm(Model model) {
        model.addAttribute("pagamento", new Pagamento());
        model.addAttribute("title", "Adicionar/Editar Pagamento");
        return "pagamento-form";
    }

    @PostMapping("/save")
    public String savePagamento(@ModelAttribute Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
        return "redirect:/pagamento/list";
    }

    @GetMapping("/list")
    public String listPagamentos(Model model) {
        model.addAttribute("pagamentos", pagamentoRepository.findAll());
        model.addAttribute("title", "Lista de Pagamentos");
        return "pagamento-list";
    }

    @GetMapping("/edit/{id}")
    public String editPagamento(@PathVariable("id") Long id, Model model) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pagamento inválido: " + id));
        model.addAttribute("pagamento", pagamento);
        model.addAttribute("title", "Editar Pagamento");
        return "pagamento-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePagamento(@PathVariable("id") Long id) {
        pagamentoRepository.deleteById(id);
        return "redirect:/pagamento/list";
    }
}
