package cinema;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import myinputs.Ler;

public class Estatisticas {

    //numero de filmes por realizador 
    public static int totalFilmesRealizador(ArrayList<Filmes> filmes, String s) {
        int count = 0;
        for (int i = 0; i < filmes.size(); i++) {
            ArrayList<Realizadores> realizadores = filmes.get(i).getRealizadores();
            for (int j = 0; j < realizadores.size(); j++) {
                if (realizadores.get(j).getNome().equals(s)) {
                    count++;
                }
            }
        }
        return count;
    }

    // numero de vezes que o cliente vai ao cinema
    public static int numVezesClienteCinema(Clientes cliente) {
        int count = 0;
        ArrayList<Bilhetes> bilhetes = Operacoes.lerFBilhetes();
        for (int i = 0; i < bilhetes.size(); i++) {
            if (bilhetes.get(i).getNif() == cliente.getNif()) {
                count++;
            }
        }
        return count;
    }
    // Total de vendas de Filmes por Sessão

    public static double totalVendasFilme(Filmes filme) {
        double valor = 0;
        ArrayList<Sessoes> sessoes = filme.getSessao();
        for (int i = 0; i < sessoes.size(); i++) {
            valor += sessoes.get(i).getMontante();
        }
        return valor;
    }

    // Numero de Filmes por Ator
    public static int totalFilmesAtor(ArrayList<Filmes> filmes, String s) {
        int count = 0;
        for (int i = 0; i < filmes.size(); i++) {
            ArrayList<Atores> atores = filmes.get(i).getAtores();
            for (int j = 0; j < atores.size(); j++) {
                if (atores.get(j).getNome().equals(s)) {
                    count++;
                }
            }
        }
        return count;
    }

// Media de lotação da Sala
    public static double mediaLotacaoSala(Salas sala, ArrayList<Filmes> filmes) {
        double soma = 0;
        int count = 0;
        for (int i = 0; i < filmes.size(); i++) {
            ArrayList<Sessoes> sessoes = filmes.get(i).getSessao();
            for (int j = 0; j < sessoes.size(); j++) {
                if (sessoes.get(j).getSala() == sala.getId()) {
                    soma += sessoes.get(j).getLugarN();
                    count++;
                }
            }
        }
        return soma / count;
    }

    //  Lucro de filme
    public static double lucroVendasFilme(Filmes filme) {
        double valor = 0;
        ArrayList<Sessoes> sessoes = filme.getSessao();
        for (int i = 0; i < sessoes.size(); i++) {
            valor += sessoes.get(i).getLucro();
        }
        return valor;
    }

    public static double lucrototal(ArrayList<Filmes> filmes) {
        double total = 0.0;
        System.out.println("Introduza a data inicial: (dd/mm/aaaa hh:mm)");
        LocalDateTime dtin = null;
        do {
            try {
                dtin = Operacoes.DateHInput(Ler.umaString());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa hh:mm");
            }
        } while (dtin == null);
        System.out.println("Introduza a data final: (dd/mm/aaaa hh:mm)");
        LocalDateTime dtfim = null;

        do {
            try {
                dtfim = Operacoes.DateHInput(Ler.umaString());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data incorrecto, por favor utilize dd/mm/aaaa hh:mm");
            }
        } while (dtfim == null);
        ArrayList<Sessoes> s = new ArrayList<Sessoes>();

        for (int i = 0;
                i < filmes.size();
                i++) {
            s = filmes.get(i).getSessao();
            for (int j = 0; j < s.size(); j++) {
                if (dtin.isBefore(s.get(j).getDataHora()) && dtfim.isAfter(s.get(j).getDataHora())) {
                    total += s.get(j).getLucro();
                }
            }
        }

        return total;
    }

    public static double totalVendasSessao(Filmes filme, Sessoes sessao) {
        double valor = 0;

        valor += sessao.getMontante();

        return valor;
    }
}
