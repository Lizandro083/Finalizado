package View;

import javax.swing.JOptionPane;

import Controller.Cardapio;
import Model.ItemMenu;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        cardapio.inicializarCardapio();

        int escolhaOpcao;
        do {
            String opcaoEscolhida = JOptionPane.showInputDialog(null,
                    "Escolha uma opção:\n" +
                            "0 - Pratos\n" +
                            "1 - Bebidas\n" +
                            "2 - Sair",
                    "Opções", JOptionPane.PLAIN_MESSAGE);

            escolhaOpcao = Integer.parseInt(opcaoEscolhida);

            switch (escolhaOpcao) {
                case 0:
                    escolherItem(cardapio.getPratos());
                    break;
                case 1:
                    escolherItem(cardapio.getBebidas());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Compra finalizada. Obrigado!",
                            "Finalizar", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (escolhaOpcao != 2);
    }

    public static void escolherItem(List<ItemMenu> itens) {
        int escolha;
        do {
            StringBuilder opcoes = new StringBuilder();
            opcoes.append("Escolha um item:\n");
            for (int i = 0; i < itens.size(); i++) {
                opcoes.append(i).append(" - ").append(itens.get(i).getNome()).append("\n");
            }
            opcoes.append("9 - Finalizar compra");

            String escolhaItem = JOptionPane.showInputDialog(null, opcoes.toString(),
                    "Escolher Item", JOptionPane.PLAIN_MESSAGE);

            escolha = Integer.parseInt(escolhaItem);

            if (escolha >= 0 && escolha < itens.size()) {
                JOptionPane.showMessageDialog(null, "Você escolheu: " + itens.get(escolha).getNome(),
                        "Escolha", JOptionPane.INFORMATION_MESSAGE);
            } else if (escolha != 9) {
                JOptionPane.showMessageDialog(null, "Opção inválida!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (escolha != 9);

        escolherPagamento();
    }

    public static void escolherPagamento() {
        String opcaoPagamento = JOptionPane.showInputDialog(null,
                "Escolha a forma de pagamento:\n" +
                        "0 - Cartão\n" +
                        "1 - PIX\n" +
                        "2 - Dinheiro",
                "Pagamento", JOptionPane.PLAIN_MESSAGE);

        int escolhaPagamento = Integer.parseInt(opcaoPagamento);

        if (escolhaPagamento == 0) {
            escolherTipoCartao();
        } else {
            gerarNotaPedido(); 
            JOptionPane.showMessageDialog(null, "Compra finalizada. Obrigado!",
                    "Finalizar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void escolherTipoCartao() {
        String tipoCartao = JOptionPane.showInputDialog(null,
                "Escolha o tipo de cartão:\n" +
                        "0 - Débito\n" +
                        "1 - Crédito",
                "Tipo de Cartão", JOptionPane.PLAIN_MESSAGE);

        
        gerarNotaPedido();

        JOptionPane.showMessageDialog(null, "Compra finalizada. Obrigado!",
                "Finalizar", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void gerarNotaPedido() {
        JOptionPane.showMessageDialog(null, "--- Nota do Pedido ---\n" +
                "Detalhes do pedido aqui...",
                "Nota do Pedido", JOptionPane.PLAIN_MESSAGE);
    }
}
