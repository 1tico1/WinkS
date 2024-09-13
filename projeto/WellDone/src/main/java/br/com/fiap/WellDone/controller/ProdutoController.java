package br.com.fiap.WellDone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.WellDone.model.Produto;
import br.com.fiap.WellDone.repository.ProdutoRep;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRep produtoRepository;

    @GetMapping("/new")
    public String produtoForm(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("title", "Adicionar/Editar Produto");
        return "produto-form";
    }

    @PostMapping("/save")
    public String saveProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produto/list";
    }

    @GetMapping("/list")
    public String listProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("title", "Lista de Produtos");
        return "produto-list";
    }

    @GetMapping("/edit/{id}")
    public String editProduto(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + id));
        model.addAttribute("produto", produto);
        model.addAttribute("title", "Editar Produto");
        return "produto-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduto(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produto/list";
    }
}
