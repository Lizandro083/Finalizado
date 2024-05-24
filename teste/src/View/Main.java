package View;

import javax.swing.JOptionPane;

import Controller.Cardapio;
import Model.ItemMenu;

import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<ItemMenu> itensSelecionados = new ArrayList<>();
    private static Cardapio cardapio; 

    public static void main(String[] args) {
        cardapio = new Cardapio(); 
        cardapio.inicializarCardapio();

        int escolhaOpcao;
        do {
            String opcaoEscolhida = JOptionPane.showInputDialog(null,
                    "Escolha uma opção:\n" +
                            "0 - Pratos\n" +
                            "1 - Bebidas\n" +
                            "2 - Sobremesas\n" +
                            "3 - Sair",
                    "Opções", JOptionPane.PLAIN_MESSAGE);

            escolhaOpcao = Integer.parseInt(opcaoEscolhida);

            switch (escolhaOpcao) {
                case 0:
                    escolherItem(cardapio.getPratos(), "Prato");
                    break;
                case 1:
                    escolherItem(cardapio.getBebidas(), "Bebida");
                    break;
                 case 2:
                    escolherItem(cardapio.getsobremesas(), "sobremesas");
                    break;
                case 3:
                    mostrarNotaFiscal();
                    JOptionPane.showMessageDialog(null, "Compra finalizada. Obrigado!",
                            "Finalizar", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (escolhaOpcao != 3);
    }

    public static void escolherItem(List<ItemMenu> itens, String tipo) {
        int escolha;
        do {
            StringBuilder opcoes = new StringBuilder();
            opcoes.append("Escolha um ").append(tipo).append(":\n");
            for (int i = 0; i < itens.size(); i++) {
                opcoes.append(i).append(" - ").append(itens.get(i).getNome()).append("\n");
            }
            opcoes.append("9 - Finalizar compra");

            String escolhaItem = JOptionPane.showInputDialog(null, opcoes.toString(),
                    "Escolher " + tipo, JOptionPane.PLAIN_MESSAGE);

            escolha = Integer.parseInt(escolhaItem);

            if (escolha >= 0 && escolha < itens.size()) {
                itensSelecionados.add(itens.get(escolha));
                JOptionPane.showMessageDialog(null, "Você escolheu: " + itens.get(escolha).getNome(),
                        "Escolha", JOptionPane.INFORMATION_MESSAGE);

                String continuar = JOptionPane.showInputDialog(null,
                        "O que deseja fazer agora?\n" +
                                "0 - Escolher outro Prato\n" +
                                "1 - Escolher outra Bebida\n" +
                                "2 - Escolher outra Sobremesa\n" +
                                "3 - Finalizar",
                        "Próxima Ação", JOptionPane.PLAIN_MESSAGE);

                int continuarEscolha = Integer.parseInt(continuar);

                if (continuarEscolha == 0) {
                    escolherItem(cardapio.getPratos(), "Prato");
                } else if (continuarEscolha == 1) {
                    escolherItem(cardapio.getBebidas(), "Bebida");
                 } else if (continuarEscolha == 2) {
                    escolherItem(cardapio.getsobremesas(), "sobremesas");
                } else if (continuarEscolha == 3) {
                    escolherPagamento();
                    break;
                }
            } else if (escolha != 9) {
                JOptionPane.showMessageDialog(null, "Opção inválida!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (escolha != 9);
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
        @SuppressWarnings("unused")
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
        StringBuilder nota = new StringBuilder();
        nota.append("--- Nota do Pedido ---\n");
        nota.append("Itens escolhidos:\n");
        double total = 0;

        for (ItemMenu item : itensSelecionados) {
            nota.append(item.getNome()).append(" - R$ ").append(item.getPreco()).append("\n");
            total += item.getPreco();
        }

        nota.append("\nTotal: R$ ").append(total);

        JOptionPane.showMessageDialog(null, nota.toString(),
                "Nota do Pedido", JOptionPane.PLAIN_MESSAGE);
    }

    public static void mostrarNotaFiscal() {
        gerarNotaPedido(); 
    }
}
