package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.ItemMenu;

public class Cardapio {
    private List<ItemMenu> pratos;
    private List<ItemMenu> bebidas;
    private List<ItemMenu> sobremesas;

    public Cardapio() {
        pratos = new ArrayList<>();
        bebidas = new ArrayList<>();
        sobremesas = new ArrayList<>();
    }
    public void adicionarPrato(ItemMenu prato) {
        pratos.add(prato);
    }

    public void adicionarBebida(ItemMenu bebida) {
        bebidas.add(bebida);
    }
      
    public void adicionarsobremesas(ItemMenu sobremesa) {
    	sobremesas.add(sobremesa);
    }


    public List<ItemMenu> getPratos() {
        return pratos;
    }

    public List<ItemMenu> getBebidas() {
        return bebidas;
    }
    public List<ItemMenu> getsobremesas() {
        return sobremesas;
    }

    public void inicializarCardapio() {
        // Adicionando 8 opções de pratos
        adicionarPrato(new ItemMenu(0, "Camarão à Baiana", 45.99));
        adicionarPrato(new ItemMenu(1, "Lagosta Grelhada", 80.55));
        adicionarPrato(new ItemMenu(2, "Peixe Frito", 35.99));
        adicionarPrato(new ItemMenu(3, "Moqueca de Peixe", 50.55));
        adicionarPrato(new ItemMenu(4, "Arroz de Polvo", 60.99));
        adicionarPrato(new ItemMenu(5, "Risoto de Camarão", 55.55));
        adicionarPrato(new ItemMenu(6, "Filé de Salmão", 70.99));
        adicionarPrato(new ItemMenu(7, "Ceviche de Peixe", 40.99));
        adicionarPrato(new ItemMenu(8, "Paella de Frutos do Mar", 90.99));
  
        // Adicionando 8 opções de bebidas
        adicionarBebida(new ItemMenu(0, "Refrigerante", 5.55));
        adicionarBebida(new ItemMenu(1, "Suco de Laranja", 6.55));
        adicionarBebida(new ItemMenu(2, "Cerveja", 7.99));
        adicionarBebida(new ItemMenu(3, "Vinho Tinto", 25.99));
        adicionarBebida(new ItemMenu(4, "Vinho Branco", 30.99));
        adicionarBebida(new ItemMenu(5, "Água com Gás", 4.55));
        adicionarBebida(new ItemMenu(6, "Água sem Gás", 3.99));
        adicionarBebida(new ItemMenu(7, "Coquetel de Frutas", 15.55));
        adicionarBebida(new ItemMenu(8, "Caipirinha", 12.99));
     
        // Adicionando 10 opções de sobremesas
        adicionarsobremesas(new ItemMenu(0, "Torta de Chocolate", 29.55));
        adicionarsobremesas(new ItemMenu(1, "Cheesecake de Frutas Vermelhas", 29.55));
        adicionarsobremesas(new ItemMenu(2, "Mousse de Maracujá", 30.55));
        adicionarsobremesas(new ItemMenu(3, "Creme Brûlée", 14.55));
        adicionarsobremesas(new ItemMenu(4, "Tiramisù", 60.55));
        adicionarsobremesas(new ItemMenu(5, "Pudim de Leite Condensado", 29.55));
        adicionarsobremesas(new ItemMenu(6, "Sorvete Artesanal de morango", 25.55));
        adicionarsobremesas(new ItemMenu(7, "Torta de Limão", 29.55));
        adicionarsobremesas(new ItemMenu(8, "Pavê de Chocolate e Amêndoas", 59.55));
        adicionarsobremesas(new ItemMenu(9, "Frutas Flambadas", 55.55));
        adicionarsobremesas(new ItemMenu(10, "Torta de morango", 35.55));
    }
}
